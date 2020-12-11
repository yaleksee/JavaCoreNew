package src.less15.ref.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MessageListner {
    private static final Map<String, Method> commands = new HashMap<>();
    //Map который хранит как ключ команду ("привет"), а как значение функцию которая будет обрабатывать команду
    private static final CommandListener listener = new CommandListener();
    //Объект класса с командами (по сути нужен нам для рефлекции)

    static {

        for (Method m : listener.getClass().getDeclaredMethods())
            //Берем список всех методов в классе CommandListener
        {
            //Смотрим, есть ли у метода нужная нам Аннотация @Command
            Command cmd = m.getAnnotation(Command.class); //Берем объект нашей Аннотации
            if (m.isAnnotationPresent(Command.class) && cmd.showInHelp())
            {
                commands.put(cmd.name(), m);
                //Обращаемся к аргументу name (чтобы использовать его как ключ), m - переменная хранящая наш метод
                for (String s : cmd.aliases())
                    //Также заносим каждый элемент aliases как ключ указывающий на тот же самый метод.
                {
                    commands.put(s, m);
                }
            }
        }
    }

    public void onMessageReceived(MessageReceivedEvent event) {

        String message = event.getMessage().toLowerCase().trim();

        if (message.startsWith("бот")) {
            try {
                String[] args = message.split(" ");
                String command = args[1].toLowerCase();
                String[] nArgs = Arrays.copyOfRange(args, 2, args.length);

                Method m = commands.get(command);
                if (m == null) {
                    //(вывод помощи)
                    return;
                }
                Command com = m.getAnnotation(Command.class);
                if (nArgs.length < com.minArgs()) {
                    //что-то если аргументов меньше чем нужно
                } else if (nArgs.length > com.maxArgs()) {
                    //что-то если аргументов больше чем нужно
                }
                m.invoke(listener, nArgs);
                //Через рефлекцию вызываем нашу функцию-обработчик
                // (именно потому что мы всегда передаем nArgs у функции должен быть параметр
                // String[] args - иначе она просто не будет найдена);
            } catch (ArrayIndexOutOfBoundsException e) {
                //Вывод списка команд или какого-либо сообщения, в случае если просто написать "Бот"
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

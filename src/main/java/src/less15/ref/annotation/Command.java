package src.less15.ref.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //Указывает, что наша Аннотация может использована во время выполнения
// через Reflection (нам как раз это нужно).
@Target(ElementType.METHOD) //Указывает, что целью нашей Аннотации является метод
// (не класс, не переменная, не поле, а именно метод).
public @interface Command //Описание. Заметим, что перед interface стоит @;
  {
    String name(); //Команда за которую будет отвечать функция (например "привет");

    String args(); //Аргументы команды, использоваться будут для вывода списка команд

    int minArgs() default 0; //Минимальное количество аргументов, сразу присвоили 0 (логично)

    String desc(); //Описание, тоже для списка

    int maxArgs() default Integer.MAX_VALUE; //Максимальное число аргументов. Вцелом необязательно,
    // но тоже можно использовать

    boolean showInHelp() default true; //Показывать ли команду в списке (вовсе необязательная строка,
    // но мало ли, пригодится!)

    String[] aliases(); //Какие команды будут считаться эквивалентными нашей
    // (Например для "привет", это может быть "Здаров", "Прив" и т.д., под каждый случай заводить функцию -
    // не рационально

}

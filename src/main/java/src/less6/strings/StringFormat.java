package src.less6.strings;

public class StringFormat {
    /**
     *  Спецификаторы формата
     * %a Шестнадцатеричное значение с плавающей точкой
     *
     * %b Логическое (булево) значение аргумента
     *
     * %c Символьное представление аргумента
     *
     * %d Десятичное целое значение аргумента
     *
     * %h Хэш-код аргумента
     *
     * %e Экспоненциальное представление аргумента
     *
     * %f Десятичное значение с плавающей точкой
     *
     * %g Выбирает более короткое представление из двух: %е или %f
     *
     * %o Восьмеричное целое значение аргумента
     *
     * %n Вставка символа новой строки
     *
     * %s Строковое представление аргумента
     *
     * %t Время и дата
     *
     * %x Шестнадцатеричное целое значение аргумента
     *
     * %% Вставка знака %
     *
     *
     *
     * Флаги формата
     * -         	Выравнивание влево
     * #         	Изменяет формат преобразования
     * 0         	Выводит значение, дополненное нулями вместо пробелов. Применим только к числам.
     * Пробел        	Положительные числа предваряются   пробелом
     * +        	Положительные числа предваряются знаком +. Применим только к числам.
     * ,         	Числовые значения включают разделители групп. Применим только к числам.
     * (          	Отрицательные числовые значения заключаются в скобки. Применим только к числам.
     */

    public static void main(String[] args) {
        String str = String.format("Строка c форматированием: %16.2f", 1000.0 / 3.0);
        System.out.println(str);


        System.out.printf("%,.2f%n", 10000.0 / 3.0);
        System.out.printf("%, (.2f%n", -10000.0 / 3.0);
        System.out.printf("%09.2f%n", 10000.0 / 3.0);
    }
}


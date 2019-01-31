package java_utill_other;

import java.util.Calendar;
import java.util.Formatter;

/** Спецификаторы формата:
 *      %a (%А)- шестнадцатиричное значение с плавающей точкой
 *      %b (%В) - логическое значение
 *      %с  - символ
 *      %d  - десятичное целое значение
 *      %h (%Н) - хэш код
 *      %е (%Е) - экспоненциальное представление
 *      %f - десятичное с плавающей точкой
 *      %g (%G) - спецификатор формата %e или %f в зависимости от форматируемого значения и заданой точности
 *      %о - восьмеричное целое число
 *      %s - символьная срока
 *      %t (%T) - вермя и дата
 *      %x (%X) - шестнадцатиричное целое число
 *      %% - вставляет знак %*/

public class Formatter_test {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();

        formatter.format("Try %s, or you will lose%c", "harder", '!');
        System.out.println(formatter);
        formatter.close();

        /* Форматирование даты и времени: (суфиксы)
        * а - сокращенное название дня недели
        * А - полное название дня недели
        * b - сокращенное название месяца
        * B - полное название месяца
        * с - стандартная строка даты и времени в формате день месяц дата чч::мм:мм:сс часовой пояс год
        * d - день месяца в демятичном представлении (01-31)
        * D - месяц/день/год
        * e - день месяца в демятичном представлении (1-31)
        * F - год/месяц/день
        * h - сокращенное название месяца
        * H,k - часы (00-23)
        * I,l - часы (00-12)
        * m - месяц в десятичном (0-13)
        * M - минуты (00-59)
        * p - pm/am
        * N - наносекунды
        * Q, s - милисекунд с 1970
        * r - чч:мм:сс 12-ч формат
        * R - чч:мм 24-ч формат
        * S - секунды
        * T - чч:мм:сс 24-ч формат
        * Y - год (00-9999
        * z - смещение относительно UTC
        * Z - наименование часового пояса*/

        System.out.println(String.format("Today is %tc", Calendar.getInstance()));
        System.out.println(String.format("Today is %td", Calendar.getInstance()));
        System.out.println(String.format("Today is %tD", Calendar.getInstance()));
        System.out.println(String.format("Today is %te", Calendar.getInstance()));
        System.out.println(String.format("Today is %tF", Calendar.getInstance()));
        System.out.println(String.format("Today is %th", Calendar.getInstance()));
        System.out.println(String.format("Today is %tb", Calendar.getInstance()));
        System.out.println(String.format("Today is %tp", Calendar.getInstance()));
        System.out.println(String.format("Today is %tT", Calendar.getInstance()));
        System.out.println(String.format("Today is %tr", Calendar.getInstance()));
        System.out.println(String.format("Today is %tZ", Calendar.getInstance()));

        //указание ширины
        System.out.println(String.format("Today is %f", 5.213));
        System.out.println(String.format("Today is %10f", 5.213));
        System.out.println(String.format("Today is %02f", 5.213));
        //указание точности (после запятой)
        System.out.println(String.format("Today is %.2f", 5.213));

        /*Признаки формата:
        *   - выравнивание по левому краю (по умолчанию по правому)
        *   # - альтернативный формат преобразования
        *   0  выводимые данные дополняются нулями вместо пробелов
        *   пробел - положительные числа выводятся с продшествующим пробелом
        *   + - положительные числа выводятся с предшествующим знаком +
        *   , - числовые значения содержат груповые разделители
        *   ( - отрицательное число заключается в скобки*/
        System.out.printf("Here: %(d", -15);
        System.out.printf("%nHere: %,d", -1532252);

        //прописные формы спецификаторов
        System.out.printf("%nHere: %A", 2252.32);
        System.out.printf("%nHere: %B", true);
        System.out.printf("%nHere: %S", "will be uppercase");
        //индекс аргумента
        System.out.printf("%nArgument index used: %2$s", "will be uppercase", "second argument");
        System.out.printf("%nArgument index used: %3$d", 3,5,62,1);
        System.out.printf("%nArgument index used: %.6s", "not all string will be taken");

    }
}

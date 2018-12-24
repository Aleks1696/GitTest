package everything.lamda;

public class NumberClass {
    public static void main(String[] args) {
        int k = 0;
        int[] array = {3,2,5,1,7,5};
        Number average = (a) -> {
            System.out.println("from lamda");
            int av = 0;
            for (int i : a){
                av += i;
            }
//            k++;  - захват переменной невозможен. к - завершенная переменная(почему то не может менятся)
            return av/a.length;
        };


        System.out.println(average.average(array));
    }
}

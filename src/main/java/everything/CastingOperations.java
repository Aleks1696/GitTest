package everything;

import java.io.IOException;

public class CastingOperations {
    public static void main(String [] args) throws IOException {

        int a = 10;
        a = a++ + a + a-- - a-- + ++a;
        System.out.println(a);

        System.out.println("------------------------");
        int marks = 8;
        int total = 10;
        System.out.println(total < marks && ++marks >5);
        System.out.println(marks);
        System.out.println(total == 10 || ++marks > 10);
        System.out.println(marks);

        System.out.println("--------------------------------");
        int count = 0;
        for (int i = 0; i < 10; ++i){
            System.out.println(i);
            count++;
        }
        System.out.println(count);

        System.out.println("--------------------------");
        int i;
        boolean b = true;
        if(b){
            i = 1;
        } else {
            i = 1;
        }
        System.out.println(i);

        System.out.println("----------------------------");
        String array[] = new String[][]{{null}, new String[]{"tra", "b"}, {new String()}} [0];

        System.out.println("------------------------");
//        Integer input = System.in.read();
        String str = "A";
        byte [] result = str.getBytes();
        System.out.println(result);
//        System.out.println(input.toString());

        for (byte b1 : result) {
            System.out.println(b1);
        }

        byte r = 122;
        System.out.println(7>5 ? "yes":"no");

        short s = (short) 304111;
        System.out.println("SHORT: " + s);

        System.out.println("============================");
        char c = 'A';
        System.out.println(++c);

        final int L;
        L = 3;
        System.out.println(L);
    }


}


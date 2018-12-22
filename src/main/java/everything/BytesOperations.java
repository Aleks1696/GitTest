package everything;

public class BytesOperations {

    public static void main(String[] args) {

        Integer a = -20;
        Integer b = 2;

        System.out.println("A: " + Integer.toBinaryString(a));
        System.out.println("B: " + Integer.toBinaryString(b));
        System.out.println("----------------------------------------");

        System.out.println("Operation in binary: | (OR) = " + Integer.toBinaryString (a | b));
        System.out.println("Operation: | (OR) = " + (a | b));
        System.out.println("-----------------------------------------");

        System.out.println("Operation in binary: & (AND) = " + Integer.toBinaryString (a & b));
        System.out.println("Operation: & (AND) = " + (a & b));
        System.out.println("-----------------------------------------");

        System.out.println("Operation in binary: ^ (XOR) = " + Integer.toBinaryString (a ^ b));
        System.out.println("Operation: ^ (XOR) = " + (a ^ b));
        System.out.println("-----------------------------------------");

        System.out.println("Operation in binary: ~ (Унарное отрицание) = " + Integer.toBinaryString (~ b));
        System.out.println("Operation: ~ (Унарное отрицание) (~b) = " + (~ b));
        System.out.println("-----------------------------------------");

        System.out.println("Operation in binary: >> = " + Integer.toBinaryString (a >> b));
        System.out.println("Operation: >> = " + (a >> b));
        System.out.println("-----------------------------------------");

        System.out.println("Operation in binary: >>> = " + Integer.toBinaryString (a >>> b));
        System.out.println("Operation: >>> = " + (a >>> b));
        System.out.println("-----------------------------------------");

        System.out.println("Operation in binary: << = " + Integer.toBinaryString (a << b));
        System.out.println("Operation: << = " + (a << b));
        System.out.println("-----------------------------------------");

    }

}

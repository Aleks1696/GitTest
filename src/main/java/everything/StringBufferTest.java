package everything;

public class StringBufferTest {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Это простой тест");
        System.out.println(sb.charAt(4));
        System.out.println(sb.charAt(7));
        System.out.println(sb.replace(4,8, "был"));
    }
}

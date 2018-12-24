package everything;

public class Generics<T> {
    T o;
    String string;
    public void gen(){

    }

    public T getO() {
        return o;
    }
}

class NonGen extends Generics{

    public NonGen() {

    }

    public void mdf(){

    }
}

class Main{
    public static void main(String[] args) {
        NonGen nonGen = new NonGen();
        System.out.println(nonGen.getO());
    }
}
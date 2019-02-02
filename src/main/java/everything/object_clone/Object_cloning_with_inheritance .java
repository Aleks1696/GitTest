package everything.object_clone;

import java.time.LocalDate;

/***/

class Object_cloning_with_inheritance {
    public static void main(String[] args) throws CloneNotSupportedException {


    }
}

class Object3 implements Cloneable{
    int x, y;
    String name;

    public Object3() {
    }
    public Object3(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public String toString() {
        final StringBuilder sb = new StringBuilder("Object3{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    protected Object clone() throws CloneNotSupportedException {
       return super.clone();
    }
}

class Object4 extends Object3 {
    Integer age;
    Object5 object = new Object5();

    public Object4(Integer age, Object5 object) {
        this.age = age;
        this.object = object;
    }

}
class Object5 {
    int a;
    LocalDate date = LocalDate.now();

    public String toString() {
        final StringBuilder sb = new StringBuilder("Object5{");
        sb.append("a=").append(a);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
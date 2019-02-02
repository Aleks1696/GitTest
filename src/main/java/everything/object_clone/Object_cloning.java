package everything.object_clone;

/**For cloning an object we need to override(or define a method clone) which
 * is going to create a copy of this object
 *      - Shallow copying - copies only primitive data and surprisingly Strings, Integers... BUT
 *      it does not make a copy of custom object fields (makes only a new reference to the same object)
 *      - Deep copying - it takes to make a shallow copy of 'general' object and then I need to
 *      manually make a copies from objects left (for example create a shallow copy of them as well or
 *      just simply make a new object)
 * */

public class Object_cloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Object3 original = new Object3(4,7,"Brend", 54);
        original.object2.k = 5;
        original.object2.nik = "Boeing";
        Object3 copy = (Object3)original.clone();

        System.out.println("Before: ");
        System.out.println(original);
        System.out.println(copy);

        copy.x = 1;
        copy.name = "New Brend";
        copy.age = 32;
        copy.object2.k = 0;
        copy.object2.nik = "Boeing 7777777";

        System.out.println("After: ");
        System.out.println(original);
        System.out.println(copy);

    }
}

class Object1 implements Cloneable{
    int x, y;
    String name;
    Integer age;
    Object4 object2 = new Object4();

    public Object1(int x, int y, String name, Integer age) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.age = age;
    }
    public String toString() {
        final StringBuilder sb = new StringBuilder("Object3{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", object2=").append(object2);
        sb.append('}');
        return sb.toString();
    }

    protected Object clone() throws CloneNotSupportedException {
        Object3 clone = (Object3)super.clone();
        Object4 object2Clone = (Object4) clone.object2.clone();
        clone.object2 = object2Clone;
        return clone;
    }
}

class Object2 implements Cloneable {
    int k;
    String nik;

    public String toString() {
        final StringBuilder sb = new StringBuilder("Object4{");
        sb.append("k=").append(k);
        sb.append(", nik='").append(nik).append('\'');
        sb.append('}');
        return sb.toString();
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

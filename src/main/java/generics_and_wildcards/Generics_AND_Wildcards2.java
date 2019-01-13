package generics_and_wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * PECS principle. Producer - extend , consumer - super
 * Producer is an parameter from which we take information
 * We set information from method to argument (consumer)
 * */


/**
 * Why this does not compile?
 *
 * List<? extends Number> list = new Arraylist();
 * list.add(new Integer(6));
 *      shortly speaking - it can not define list type!
 *
 * Since we don't know what the element type of c stands for, we cannot add objects to it.
 * The add() method takes arguments of type E, the element type of the collection.
 * When the actual type parameter is ?, it stands for some unknown type.
 * Any parameter we pass to add would have to be a subtype of this unknown type.
 * Since we don't know what type that is, we cannot pass anything in. The sole exception is null, which is a member of every type.
 *
 * On the other hand, given a List<?>, we can call get() and make use of the result.
 * The result type is an unknown type, but we always know that it is an object.
 * It is therefore safe to assign the result of get() to a variable of type Object or pass it as a parameter where the type Object is expected.
 * */

public class Generics_AND_Wildcards2 {

    public static void main(String[] args) {
        List<Doggie> doggies = new ArrayList<>();
        List<Pet> list = new ArrayList<>();
        list.addAll(doggies);
        List<Doggie> doggieList = new ArrayList<>();

        List<? extends Pet> pets = new ArrayList<>();
//        pets.add(new Kitty());                         //Because List<Doggie> is a subtype of List<? extends Pet>,
                                                        // you can assign 'doggie' to 'pets'. But you cannot use pets to add a new Kitty()
                                                        //to a list of pets.
        pets = doggieList;
        pets = new ArrayList<Pet>();


    }
}
class Animal{
    void feed(){}
}
class Pet extends Animal{
    void call(){}
}
class Kitty extends Pet{
    void meow(){}
}
class Doggie extends Pet{
    void bark(){}
}
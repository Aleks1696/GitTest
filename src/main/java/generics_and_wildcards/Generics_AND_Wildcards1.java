package generics_and_wildcards;

import java.util.*;

public class Generics_AND_Wildcards1 {

    public static void main(String[] args) {

        Predict<Long, Vehicle> predict = null;
        Checking<Vehicle> checking1 = null;

//        Collection<Car> cars = predict.getAll(new Checking<Car>() {
//            @Override
//            public boolean apply(Car expression) {
//                return false;
//            }
//        });
//
//        Collection<Car> cars1 = predict.getAll(new Checking<Vehicle>() {
//            @Override
//            public boolean apply(Vehicle expression) {
//                return false;
//            }
//        });
        Map<Long, Car> map = new HashMap<>(2);
        map.put(12L, new Car());
        map.put(11L, new Car());

        predict.putAll(map);
        predict.put(12L, new Car());

        predict.getAll(new HashSet<>());
    }
}


interface Predict<K, V> {
    Collection<V> getAll(Checking<? super V> p);
    void putAll(Map<K, ? extends V> map);
    void put(K key, V value);
    Map<K, V> getAll(Collection<? extends K> collection);
}

class PredictImpl<K, V> implements Predict {
    @Override
    public Collection getAll(Checking p) {
        return null;
    }

    @Override
    public void putAll(Map map) {

    }

    @Override
    public void put(Object key, Object value) {

    }

    @Override
    public Map getAll(Collection collection) {
        return null;
    }


}

interface Checking<E> {
    boolean apply(E expression);
}

class Vehicle {
    public String name;
}

class Car extends Vehicle {
    public Integer age;
}

package collections;

import java.util.*;

/**Vector is synchronized
 * if synchr. is unnecessary use ArrayList*/

/** Iterator vs Enumeration.
 *          Iterator has method 'remove()' while Enumeration does not
 *          Enumeration is legacy interface
 *          Presented at java 1.0 (Iterator 1.2 - now)
 *          Enumeration can work with legacy classes Vector, Stack, HashTable while Iterator all collections
 *          Iterator - fail-fast / Enumeration - fail-save (throws Exception if coll. is changed during
 *          iteration and not)
 *          */

public class Vector_test {
    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<>(8, 4);

        vector.add(4);
        vector.addAll(Arrays.asList(5,3,7,8,9));

        System.out.println(vector);

        System.out.println("Capacity: " + vector.capacity());
        System.out.println("Size: " + vector.size());
        vector.add(1);
        vector.add(2);
        vector.add(1,0);
        System.out.println("Capacity: " + vector.capacity());
        System.out.println("Size: " + vector.size());

        vector.addAll(2, Arrays.asList(10,11,12));
        //checks whether capacity is bigger than 'minCapacity' if not cap. will equals minCapacity
        vector.ensureCapacity(27);
        System.out.println(vector.capacity());
        //removes all elements but specified collection
        vector.retainAll(Arrays.asList(0,1,3,4,7));

        System.out.println(vector);
    }

}

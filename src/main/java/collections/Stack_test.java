package collections;

import java.util.Stack;

/**Stack (only empty constructor)
 *
 *      because it extends from Vector it uses all vector and its superclass methods
 *
 */

public class Stack_test {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(4);
        stack.push(7);
        stack.push(3);
        stack.push(1);
        stack.push(0);
        stack.push(9);

        //methods from vector
        stack.add(8);
        System.out.println(stack.capacity());
        System.out.println(stack.get(3));
        System.out.println(stack.indexOf(7));

        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Search (порядковый номер если брать сверху стека): " + stack.search(4));
        System.out.println(stack);
    }

}

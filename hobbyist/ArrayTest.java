import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class ArrayTest {
    public static void main(String[] args) {
        String arr[] = new String[5];
        arr[0] = "Hello ";
        arr[1] = "World";
        arr[2] = "!";
        arr[3] = " ";
        arr[4] = "I'm Wyatt Marcus\n";

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        // Array 2 ArrayList - Dynamic Array
        ArrayList<String> arrList = new ArrayList<String>(Arrays.asList(arr));
        arrList.add("Hello");
        arrList.add(" World");
        arrList.add(" My name is Kat Sherman\n");
        for (String s : arrList) {
            System.out.print(s);
        }

        // Linked List
        LinkedList <String> linkedList = new LinkedList<String>();
        linkedList.add("Hello");
        linkedList.add(" World");
        linkedList.add(" My name is Megan\n");
        for (String s : linkedList) {
            System.out.print(s);
        }
    }
}

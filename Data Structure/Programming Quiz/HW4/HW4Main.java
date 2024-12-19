public class HW4Main {

    public static void main(String[] args) {

        // Creating first sorted linked list: 1 -> 2 -> 4

        LinkedList<Integer> list1 = new LinkedList<>(1, new LinkedList(2, new LinkedList(4, null)));

        System.out.println(list1);       

        // Creating second sorted linked list: 1 -> 3 -> 4

        LinkedList<Integer> list2 = new LinkedList<>(1, new LinkedList(3, new LinkedList(5, null)));

        // Merging the lists

        HW4<Integer> h = new HW4<>();
        System.out.println(h.merge(list1, list2));   

     }

 }

 

 

public class LinkedList<T> {

T data;

LinkedList<T> next;

 

LinkedList(T d, LinkedList<T> n) {data=d; next=n;}

public String toString() {

String result = data.toString();

if(next != null) result += " "+ next.toString();

return result;

}

 

}
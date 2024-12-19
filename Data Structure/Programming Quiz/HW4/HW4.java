public class HW4<E extends Comparable<E>> {
    public LinkedList<E> merge(LinkedList<E> list1, LinkedList<E> list2){

        LinkedList<E> merged = new LinkedList(list1.length+list2.length);
        collections.copy(merged,list1);
        collections.copy(merged,list2);
        collections.sort(merged);
        return merged;
        
    }
    
}

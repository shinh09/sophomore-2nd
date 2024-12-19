public class HW2<T extends Comparable<T>> {
    public T max(T a, T b){
        if (a.compareTo(b)>0){
            return a;
        }else{return b;}
    }
}

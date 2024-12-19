public class HW2<T extends Comparable> {
    public T max(T num1, T num2) {
        if(num1.compareTo(num2)>0){
            return num1;
        }else{
            return num2;
        }
    }
}
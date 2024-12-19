public class HW7Main {

    public static void main(String[] args) {
  
           HW7 h = new HW7();
  
           int[][] tc = {
  
                          {-1, 1, 2, 3, 4, 5, 6}, // valid min heap: true
  
           };
  
           boolean[] expected = {true};
  
           for(int i = 0 ; i < tc.length; i++)
  
                  System.out.println(expected[i] + ": " + h.isHeap(tc[i]));
  
    }
  
  }
  
  
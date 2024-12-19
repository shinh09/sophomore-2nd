public class HW6Main {

    public static void main(String[] args) {
  
           HW6 hw = new HW6();
  
           Integer[] ar1 = {};
  
           TreeNode<Integer> t = TreeNode.constructTree(ar1);
  
           System.out.println(hw.isAVL(t));
  
    }
  
  }
  
  
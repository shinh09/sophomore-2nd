import java.util.*;

class TreeNode {
    String data;
    TreeNode left;
    TreeNode right;

    TreeNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static TreeNode constructTree(String postfix) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (isOperator(c)) {
                TreeNode right = stack.pop();
                TreeNode left = stack.pop();
                TreeNode node = new TreeNode(String.valueOf(c));
                node.left = left;
                node.right = right;
                stack.push(node);
            } else {
                stack.push(new TreeNode(String.valueOf(c)));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    public String toString() {
    	String str = data;
    	if(left != null) str = str + " left:  " + left.toString();
    	if(right!= null) str = str + " right: " + right.toString();
    	return str;
    }
}

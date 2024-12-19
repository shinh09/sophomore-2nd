enum BalanceStatus {
    AVL,			// This tree is an AVL tree
    NOT_AVL_DUE_TO_HEIGHT,		
// This tree is not an AVL tree due to the difference in height between the left and right subtrees
    NOT_AVL_DUE_TO_BST_PROPERTY // This tree is not even BST.
}

public class HW6TestCases {
	public static void main(String[] args) {
		HW6Main hw = new HW6Main();
        // Test Cases
        Integer[][] testCases = {
            {}, // Empty Tree
            {10}, // Single Node
            {10, 5, 20, 3, 7, 15, 25}, // Perfectly Balanced Tree
            {10, 5, 15, 3, null, null, null, null, 4}, // Left, right Heavy Tree
            {10, null, 20, null, null, null, 25}, // Right Heavy Tree
            {10, 5, 20, null, 2, 15, 25, null}, // Invalid BST Property
            {10, 5, 20, 3, 7, 15, 25, 1, 4, 6, 8, 13, 17, 22, 27}, // Deep Balanced Tree
            {10, 5, 20, 3, 7, 15, 25, 2, 4, 6, 8, 14, 18, 22, 28, 1, null, null, null, null, null, null, null, null, null, null, null, null, 19, null}, // Slightly Unbalanced Tree
            {10, 9, null, 8, null, null, null, 7}, // All Left Nodes
            {10, null, 11, null, null, null, 12, null, null, null, 13} // All Right Nodes
        };
        BalanceStatus[] expectedResults = {
            BalanceStatus.AVL,
            BalanceStatus.AVL,
            BalanceStatus.AVL,
            BalanceStatus.NOT_AVL_DUE_TO_HEIGHT,
            BalanceStatus.NOT_AVL_DUE_TO_HEIGHT,
            BalanceStatus.NOT_AVL_DUE_TO_BST_PROPERTY,
            BalanceStatus.AVL,
            BalanceStatus.NOT_AVL_DUE_TO_BST_PROPERTY,
            BalanceStatus.NOT_AVL_DUE_TO_HEIGHT,
            BalanceStatus.NOT_AVL_DUE_TO_HEIGHT
        };
        for (int i = 0; i < testCases.length; i++) {
        	TreeNode<Integer> root = null;
        	if(testCases[i].length!=0) root = root.constructTree(testCases[i]);
            BalanceStatus result = hw.isAVL(root);
            System.out.println("Test Case " + (i + 1) + ": " + result + " (Expected: " + expectedResults[i] + ")");
        }
	}
}

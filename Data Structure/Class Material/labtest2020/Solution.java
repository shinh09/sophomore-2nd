import java.util.*;

class Solution{
	public int largestPerimeter(int[] nums) {
		Arrays.sort(nums);
		
		if(nums[0]<nums[1]+nums[2]) {
			return nums[0]+nums[1]+nums[2];
		}else {
			return 0;
		}
	}
}

//Solution s = new Solution();
//
//// 문제 1: 트리 전위 순회 테스트
//List<Node> children3 = new ArrayList<>();
//children3.add(new Node(5, null));
//children3.add(new Node(6, null));
//
//List<Node> children1 = new ArrayList<>();
//children1.add(new Node(3, children3));
//children1.add(new Node(2, null));
//children1.add(new Node(4, null));
//
//Node root1 = new Node(1, children1);
//
//System.out.println("Problem 1: " + s.preorder(root1));


////문제 2: 가장 큰 삼각형 둘레 테스트
//int[] nums = {2, 1, 2};
//System.out.println("Problem 2: " + s.largestPerimeter(nums));
//
//// 문제 3: 최대값 생성 테스트
//System.out.println("Problem 3: " + s.getMaximumGenerated(7));
//}
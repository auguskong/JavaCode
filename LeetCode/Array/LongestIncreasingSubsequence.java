
//O(nlogn) Binary Search

public class Solution {

	public int longestIncreasingSubsequence(int[] nums) {
		int[] minLast = new int[nums.length + 1];
		minLast[0] = Integer.MIN_VALUE;
		for (int i = 1; i <= nums.length; i++) {
			minLast[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < nums.length; i++) {
			int index = binarySearch(minLast, nums[i]);
			minLast[index] = nums[i];
		}

		for (int i = )
	}
}
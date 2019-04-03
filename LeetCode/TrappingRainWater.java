/*
*Date: 05/19/18
*
*
*/

//solution from basketwang
public class Solution {
	public int trap(int[] height) {
		if (height == null || height.length < 3) return 0;
		int max = 0; //store the final result
		int leftmax = 0;
		int rightmax = 0;
		int i = 0;
		int j = height.length - 1;
		while (i < j) {
			leftmax = Math.max(leftmax, height[i]);
			rightmax = Math.max(rightmax, height[j]);
			//the smaller height determine the possible water level
			if (leftmax < rightmax) {
				max += leftmax - height[i];
				i++;
			} else {
				max += rightmax - height[j];
				j--;
			}
		}
		return max;
	}
}
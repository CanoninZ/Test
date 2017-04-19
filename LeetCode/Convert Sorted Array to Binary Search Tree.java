/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0 || nums == null) return null;
        return newNode(nums,0,nums.length - 1);

        
    }
    public TreeNode newNode(int[] nums, int lower, int higher){
            int mid = (higher - lower)/2 + lower;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = (mid - 1 < lower)? null:newNode(nums,lower,mid - 1);
            node.right = (mid  + 1 > higher)? null:newNode(nums,mid + 1,higher); 
            return node;
    }

//方法2
public TreeNode sortedArrayToBST(int[] num) {
    if (num.length == 0) {
        return null;
    }
    TreeNode head = helper(num, 0, num.length - 1);
    return head;
}

public TreeNode helper(int[] num, int low, int high) {
    if (low > high) { // Done
        return null;
    }
    int mid = (low + high) / 2;
    TreeNode node = new TreeNode(num[mid]);
    node.left = helper(num, low, mid - 1);
    node.right = helper(num, mid + 1, high);
    return node;
}



}
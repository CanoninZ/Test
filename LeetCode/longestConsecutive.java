/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// public class Solution {
//     public class element{
//         int counter = 0;
//         int max = 1;
//         int val = Integer.MIN_VALUE;
//     }
//     public int longestConsecutive(TreeNode root) {
//         if(root == null) return 0;
//         element ele = new element();
//         longestConsecutive(root,ele);
//         return ele.max;
//     }
    
//     public int longestConsecutive(TreeNode root, element ele) {
//         if(root.left == null && root.right == null){
//             ele.val = root.val;
//             ele.counter = 1;
//             return 1;
//         }
//         int left =0 , right = 0;
//         if(root.left != null){
//             left = longestConsecutive(root.left,ele);
//             if(ele.val - 1 == root.val){
//                 ele.counter++;
//             if(ele.counter > ele.max) ele.max = ele.counter;
//                 ele.val = root.val;
//         }else{
//             ele.val = root.val;
//             ele.counter = 1;  
//         }
//         }
//         if(root.right != null){
//             right = longestConsecutive(root.right,ele);
//                     if(ele.val - 1 == root.val){
//                 ele.counter++;
//             if(ele.counter > ele.max) ele.max = ele.counter;
//                 ele.val = root.val;
//         }else{
//             ele.val = root.val;
//             ele.counter = (left>right)? left:right;  
//         }
//         }
//         return ele.counter;
//     }
    
// }

// 不用全局变量

// public class Solution {
//     public int longestConsecutive(TreeNode root) {
//         return (root==null)?0:Math.max(dfs(root.left, 1, root.val), dfs(root.right, 1, root.val));
//     }
    
//     public int dfs(TreeNode root, int count, int val){
//         if(root==null) return count;
//         count = (root.val - val == 1)?count+1:1;
//         int left = dfs(root.left, count, root.val);
//         int right = dfs(root.right, count, root.val);
//         return Math.max(Math.max(left, right), count);
//     }
// }
// 全局变量
public class Solution {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0, root.val);
        return max;
    }
    
    public void helper(TreeNode root, int cur, int target){
        if(root == null) return;
        if(root.val == target) cur++;
        else cur = 1;
        max = Math.max(cur, max);
        //因为在这一层，cur一样，target value 也一样
        //pre order
        helper(root.left, cur, root.val + 1);
        helper(root.right, cur, root.val + 1);
    }
}
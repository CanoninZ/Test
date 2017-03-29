/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
Here's my ideas:

A path from start to end, goes up on the tree for 0 or more steps, then goes down for 0 or more steps.
Once it goes down, it can't go up. Each path has a highest node, which is 
also the lowest common ancestor of all other nodes on the path.
A recursive method maxPathDown(TreeNode node) (1) computes the maximum path sum with highest node is the input node,
update maximum if necessary (2) returns the maximum sum of the path that can be extended to input node's parent.
*/
// O(n)
// 其实 是 bottom-up的方法，因为是post-dfs 且返回上层时，是返回max value的“return Math.max(left, right) + node.val;” 贪心算法
// 但是 又有 from top to bottom 的感觉，原因就是在于使用全局变量, r如果没有全局变量我们无法得知 global minimum value
// public class Solution {
//     int maxValue;
    
//     public int maxPathSum(TreeNode root) {
//         maxValue = Integer.MIN_VALUE;
//         maxPathDown(root);
//         return maxValue;
//     }
    
//     private int maxPathDown(TreeNode node) {
//         if (node == null) return 0;
//         int left = Math.max(0, maxPathDown(node.left));
//         int right = Math.max(0, maxPathDown(node.right));
//         maxValue = Math.max(maxValue, left + right + node.val);
//         return Math.max(left, right) + node.val;
//     }
// }
//将全局变量包装一下 wrap up
public class Solution {
    class maxValue{
        int  maxVal = Integer.MIN_VALUE;
    }
    
    public int maxPathSum(TreeNode root) {
        maxValue maxV = new maxValue();
        maxPathDown(root,maxV);
        return maxV.maxVal;
    }
    
    private int maxPathDown(TreeNode node,maxValue v) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left,v));
        int right = Math.max(0, maxPathDown(node.right,v));
        v.maxVal = Math.max(v.maxVal, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
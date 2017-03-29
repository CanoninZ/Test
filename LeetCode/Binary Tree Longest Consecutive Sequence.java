/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// method 1
// 这个方法很好，就是不太直观，对于每一个节点，它有三个值，一个就是从根到此节点的最长序列数，一个就是他的左子树的最大序列数，第三个就是他的右子树的最大序列数
    2
      3  counter = 2, left = 3, right = 2
     4   counter = 3, left = 2, right = 3
    3    counter = 1, left = 1, right = 2
      4  counter = 2, left = 1, right = 1
     // public class Solution {
//     public int longestConsecutive(TreeNode root) {
//         return (root==null)?0:Math.max(dfs(root.left, 1, root.val), dfs(root.right, 1, root.val));
//     }
    
//     public int dfs(TreeNode root, int count, int val){
//         if(root==null) return count;
//         count = (root.val - val == 1)? count+1:1;
//         int left = dfs(root.left, count, root.val);
//         int right = dfs(root.right, count, root.val);
//         return Math.max(Math.max(left, right), count);
//     }
// }
// method 2
// 自上而下的
// 唯一有点不好的就是有全局变量
public class Solution {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0, root.val);
        return max;
    }
    
    public void helper(TreeNode root, int cur, int target){
        if(root == null) return;
        if(root.val == target) 
        cur++;
        else 
        cur = 1;
        max = Math.max(cur, max);
        helper(root.left, cur, root.val + 1);
        helper(root.right, cur, root.val + 1);
    }
}
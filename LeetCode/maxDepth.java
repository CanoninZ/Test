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
    //RECUISION
    // public int maxDepth(TreeNode root) {
    //     if(root == null) return 0;
    //     if((root.left == null && root.right == null) ) return 1;
    //     return max(maxDepth(root.left), maxDepth(root.right)) + 1;
    // }

    // public int max(int x, int y){
    //     return (x>y)? x:y;
    // }
    //BFS
    //QUEUE
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);
        int size;
        int counter = 0;
        while(!q.isEmpty()){
            size = q.size();
            
            while(size-->0){
                TreeNode t = q.poll();
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
            counter++;
        }
        return counter;
    }
}
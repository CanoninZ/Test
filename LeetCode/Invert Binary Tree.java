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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode tmp = q.poll();
                if(tmp.left != null) q.offer(tmp.left);
                if(tmp.right != null) q.offer(tmp.right);
                TreeNode tmp_left = tmp.left;
                tmp.left = tmp.right;
                tmp.right = tmp_left;

            }
        }
        return root;
    }
}

// dfs pretty smart
// public class Solution {
//     public TreeNode invertTree(TreeNode root) {
        
//         if (root == null) {
//             return null;
//         }
// 这一步十分的重要，因为如果没有这一步暂时保存了root原始的左节点和右节点，那么之后的迭代就会出现问题。
//         final TreeNode left = root.left, right = root.right;

//         root.left = invertTree(right);
//         root.right = invertTree(left);
//         return root;
//     }
// }

//iteratively for dfs
// public class Solution {
//     public TreeNode invertTree(TreeNode root) {
        
//         if (root == null) {
//             return null;
//         }

//         final Deque<TreeNode> stack = new LinkedList<>();
//         stack.push(root);
        
//         while(!stack.isEmpty()) {
//             final TreeNode node = stack.pop();
//             final TreeNode left = node.left;
//             node.left = node.right;
//             node.right = left;
            
//             if(node.left != null) {
//                 stack.push(node.left);
//             }
//             if(node.right != null) {
//                 stack.push(node.right);
//             }
//         }
//         return root;
//     }
// }

// bfs pretty much the same as the first method
// public class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         if (root == null) {
//             return null;
//         }

//         final Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         while(!queue.isEmpty()) {
//             final TreeNode node = queue.poll();
//             final TreeNode left = node.left;
//             node.left = node.right;
//             node.right = left;

//             if(node.left != null) {
//                 queue.offer(node.left);
//             }
//             if(node.right != null) {
//                 queue.offer(node.right);
//             }
//         }
//         return root;
//     }
// }
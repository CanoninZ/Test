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
    
    //trivial, but still worth a try
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     ArrayList<Integer> list = new ArrayList<Integer>();
    //     if(root == null) return list; 
    //     inorderTra(root,list);
    //     return list;
    // }
    // public void inorderTra(TreeNode root, ArrayList list){
    //     if(root.left != null) inorderTra(root.left, list);
    //     list.add(root.val);
    //     if(root.right != null)inorderTra(root.right, list);

    // }
     
    //iteratively
    //自己写的
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<Integer>();
    //     Stack<TreeNode> sta = new Stack<TreeNode>();
    //     if(root != null) sta.push(root);
    //     else return list;
    //     while(!sta.isEmpty()){
    //          看看top element 是否有左节点
    //         TreeNode tmp = sta.peek();
    //         while(tmp.left != null) {
    //             sta.push(tmp.left);
    //             tmp = sta.peek();
    //         }
    //          in order
    //         tmp = sta.pop();
    //         list.add(tmp.val);
    //          看一看刚刚处理过的节点是否有右节点
    //         while(true){
    //         if(tmp.right !=null){
    //          若有右节点 将其推入就好，然后退出while（1）循环
    //          sta.push(tmp.right);  
    //          break;
    //         }else{
    //              若没有右节点，表明以该节点为根的子树已经处理完毕，pop 出 sta 里面的top element
    //              所以在这里很重要的要检查： sta 是否还有元素
    //          if(!sta.isEmpty()){
    //                tmp = sta.pop();
    //                list.add(tmp.val);
    //             }else
                        // break;
    //         }
            
    //         }
    //     }
    //     return list;
    // }
    
    
    
    
    
    public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;

    Stack<TreeNode> stack = new Stack<>();
    pushAllLeft(root, stack);
    while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();
        res.add(cur.val);
        pushAllLeft(cur.right, stack);
    }
    return res;
    }

    public void pushAllLeft(TreeNode node, Stack stack){
      while (node != null) {
        stack.add(node);
        node = node.left;
     }
    }




// public List<Integer> inorderTraversal(TreeNode root) {
//     List<Integer> list = new ArrayList<Integer>();

//     Stack<TreeNode> stack = new Stack<TreeNode>();
//     TreeNode cur = root;

//     while(cur != null || !stack.empty()){
//         while(cur!=null){
//             stack.add(cur);
//             cur = cur.left;
//         }
//         cur = stack.pop();
//         list.add(cur.val);
//         cur = cur.right;
//     }

//     return list;
// }





    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return list;
        while(root != null) {
            // 标准是 其左子树 不为空
            while(root.left != null) {
                stack.push(root);
                root = root.left;
            }
            // 若当前节点左子树为空，那么我们直接处理当前节点
            list.add(root.val);
            // 当前节点右子树， 若为空，则以该节点为根的子树已经处理完毕
            while(root.right == null) {
                if(!stack.isEmpty()) {
                    root = stack.pop();
                    list.add(root.val);
                } else {
                    break;
                }
            }
            // 如果当前节点的右子树不为空，我们先研究其右子树节点
            if(root.right != null) {
                root = root.right;
            } else if(stack.isEmpty()) {
                break;
            }
        }
        return list;
    }
}
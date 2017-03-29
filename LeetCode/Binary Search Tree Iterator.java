/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//这是我自己的办法但是没有达到题目的要求，因为这是一次性遍历了BST，所以，不是O(h)space
//time complexity is O(1)， but space complexity is O（n）；

public class BSTIterator {
    Queue<Integer> ls = new ArrayDeque<Integer>();
    boolean flag = false;
    public BSTIterator(TreeNode root) {
        helper(root);
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!ls.isEmpty() ) return true;
        else return false;
    }

    /** @return the next smallest number */
    public int next() {
        if(!ls.isEmpty() ) return ls.poll();
        else return -1;
    }
    private void helper(TreeNode root){
        if(root == null )return ;
        helper(root.left);
        ls.offer(root.val);
        helper(root.right);
    }
}



// 最佳方法： 使用 stack 和 pushall方法
/**
I use Stack to store directed left children from root.
When next() be called, I just pop one element and process its right child as new root.
The code is pretty straightforward.

So this can satisfy O(h) memory, hasNext() in O(1) time,
As the next function can be called n times at most, 
and the number of right nodes in self.pushAll(tmpNode.right) function is 
maximal n in a tree which has n nodes, 
so the amortized time complexity is O(1).
*/
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */




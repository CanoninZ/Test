//method 1
//TIME complexity is O(nlogn)
class solution {
public:
    int depth (TreeNode *root) {
        if (root == NULL) return 0;
        return max (depth(root -> left), depth (root -> right)) + 1;
    }

    bool isBalanced (TreeNode *root) {
        if (root == NULL) return true;
        
        int left=depth(root->left);
        int right=depth(root->right);
        
        return abs(left - right) <= 1 && isBalanced(root->left) && isBalanced(root->right);
    }
};
//method2
//自己写得，觉得还不错，最佳答案也是这个思路
//O(n) for time complexity.
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = getHight(root.left);
        int right = getHight(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) return false;
        else return true;
    }
    private int getHight(TreeNode root) {
        if(root == null) return 0;
        int left,right;
        left = getHight(root.left);
        right = getHight(root.right);
        if(left == -1|| right == -1||Math.abs(left - right) > 1) {
           return -1;
        }else{
            return (left>right)? left+1:right+1;
        }  
    }
}
//  以下是思路最清晰的
// 同养的思路但是这个running time less，思路也更清晰
public boolean isBalanced(TreeNode root) {
    if(root==null){
        return true;
    }
    return height(root)!=-1;
    
}
public int height(TreeNode node){
    if(node==null){
        return 0;
    }
    int lH=height(node.left);
    if(lH==-1){
        return -1;
    }
    int rH=height(node.right);
    if(rH==-1){
        return -1;
    }
    if(lH-rH<-1 || lH-rH>1){
        return -1;
    }
    return Math.max(lH,rH)+1;
}
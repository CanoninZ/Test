    

// method 1 O（n^2）
// 十分的对称，优雅，除了要进行字符串链接没有什么缺点，因为字符串concatenating is to create a new string thencopy the original string over to the new string
    // then append the new extra string. 
    public List<String> binaryTreePaths(TreeNode root) {
    List<String> answer = new ArrayList<String>();
    if (root != null) searchBT(root, "", answer);
    return answer;
    }
    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }


    // 使用 StringBuilder
/**
When using StringBuilder, We can just keep track of the length of the StringBuilder before we append anything to it 
before recursion and afterwards set the length back. Another trick is when to append the "->", 
since we don't need the last arrow at the end of the string, we only append it before recurse to the next level of the tree.
*/
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
    }
    
    private void helper(List<String> res, TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }
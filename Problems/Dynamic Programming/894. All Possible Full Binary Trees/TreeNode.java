/*
 * Given an integer n, return a list of all possible full binary 
 * trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. 
You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.

Example 1:

Input: n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
Example 2:

Input: n = 3
Output: [[0,0,0]]
 */
import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { 
        this.val = val; 
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Possible{
    private List<TreeNode> memo[];

    public List<TreeNode> allPossibleFBT(int n){
        memo = new List[n+1];
        return buildTrees(n);
    }

    public List<TreeNode> buildTrees(int n){
        if(memo[n] != null) return memo[n];
        
        if(n == 1){
            return List.of(new TreeNode(0));
        }

        List<TreeNode> result = new ArrayList<>();

        for(int i = 0; i < n - 1; i++){
            int j = n - 1 - i;

            for(TreeNode leftSubTree : buildTrees(i)){
                for(TreeNode rightSubTree : buildTrees(j)){
                    result.add(new TreeNode(0, leftSubTree, rightSubTree));
                }
            }
        }

        return memo[n] = result;
    }
    public void display(TreeNode ans){
        if(ans.left != null){
            display(ans.left);
        }
        System.out.print(ans.val + " , ");
        if(ans.right != null){
            display(ans.right);
        }
    }
    public static void main(String[] args) {
        Possible obj = new Possible();
        int n = 7;
        List<TreeNode> result = obj.allPossibleFBT(n);
        for(TreeNode ans : result){
            obj.display(ans);
            System.out.println();
        }
        
    }
}
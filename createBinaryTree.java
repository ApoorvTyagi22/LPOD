/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length; 
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] curr : descriptions){
            int parent = curr[0];
            int child = curr[1];
            if(!map.containsKey(parent)){
                TreeNode par = new TreeNode(parent);
                map.put(parent, par);
            } 
            if(!map.containsKey(child)){
                TreeNode ch = new TreeNode(child);
                map.put(child, ch);
            }
            if(curr[2] == 1){
                map.get(parent).left = map.get(child);
            } else {
                map.get(parent).right = map.get(child);
            }

            set.add(child);
        }
        TreeNode temp = new TreeNode();
        for(int[] curr : descriptions){
            if(!set.contains(curr[0])){
                temp = map.get(curr[0]);
                break; 
            }
        }

        return temp; 
    }
}
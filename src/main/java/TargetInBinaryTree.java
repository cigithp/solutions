import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a complete binary tree such that the nodes are filled in a level-wise manner starting from 0 to n. Given a number find if it exists in the tree.
 *
 *      0
 *     / \
 *    1   2
 *   / \ / \
 *   3 4 5 6
 *  /
 * 7
 *
 * find(7)
 * find(8)
 * find(4)
 *
 * ans:: do a traversal using any of the orders(pre, in, post) -> then find the number in the list
 * or use BFS to -> fastest way to search the number -> more efficient
 *
 *
 *
 *
 */



public class TargetInBinaryTree {
    static class TreeNode {
        TreeNode left, right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean findNumber(TreeNode root, int target) {
        if(root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if(target == currNode.val)
                    return true;
                if(currNode.left != null)
                    queue.offer(currNode.left);
                if(currNode.right != null)
                    queue.offer(currNode.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(0);
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(6);
        input.add(7);
        input.add(8);
        //for(Integer n : input)





    }
}

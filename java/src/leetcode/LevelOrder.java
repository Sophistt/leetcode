package leetcode;

// 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

import java.util.ArrayList;
import java.util.Queue;
import java.util.List;
import tree.TreeNode;
import java.util.LinkedList;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (!tmp.isEmpty()) result.add(tmp);
            else {
                break;
            }
            result.add(tmp);
        }
        return result;
    }
}

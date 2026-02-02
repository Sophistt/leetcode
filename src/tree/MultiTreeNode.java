package tree;

import java.util.ArrayList;
import java.util.List;

public class MultiTreeNode {
    int val;
    List<MultiTreeNode> children;

    public MultiTreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<MultiTreeNode>();
    }
}

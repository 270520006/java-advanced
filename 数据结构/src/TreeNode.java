public class TreeNode {
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;
    private String value;
    public TreeNode(String value) {
        this.value = value;
    }

    public void setLeftTreeNode(TreeNode leftTreeNode) {
        this.leftTreeNode = leftTreeNode;
    }

    public void setRightTreeNode(TreeNode rightTreeNode) {
        this.rightTreeNode = rightTreeNode;
    }

    public TreeNode getLeftTreeNode() {
        return leftTreeNode;
    }

    public TreeNode getRightTreeNode() {
        return rightTreeNode;
    }

    public String getValue() {
        return value;
    }
}

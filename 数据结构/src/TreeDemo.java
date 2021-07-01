public class TreeDemo {
    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        A.setLeftTreeNode(B);B.setRightTreeNode(D);D.setLeftTreeNode(F);
        A.setRightTreeNode(C);C.setRightTreeNode(E);E.setLeftTreeNode(G);
        G.setLeftTreeNode(H);G.setRightTreeNode(I);
        LRD(A);
        System.out.println("author:zsp");
    }
    public static void LRD(TreeNode rootTreeNode){
        if (rootTreeNode!=null){
            LRD(rootTreeNode.getLeftTreeNode());
            LRD(rootTreeNode.getRightTreeNode());
            System.out.print(rootTreeNode.getValue()+"--");
        }
    }
}

import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.List;

public class TreeDemo {
    public static void main(String[] args) {
//        TreeNode A = new TreeNode(1);
//        TreeNode B = new TreeNode(2);
//        TreeNode C = new TreeNode(3);
//        TreeNode D = new TreeNode(4);
//        TreeNode E = new TreeNode(5);
//        TreeNode F = new TreeNode(6);
//        TreeNode G = new TreeNode(7);
//        TreeNode H = new TreeNode(8);
//        TreeNode I = new TreeNode(9);
//        A.setLeftTreeNode(B);B.setRightTreeNode(D);D.setLeftTreeNode(F);
//        A.setRightTreeNode(C);C.setRightTreeNode(E);E.setLeftTreeNode(G);
//        G.setLeftTreeNode(H);G.setRightTreeNode(I);
//        LRD(A);
        List<Integer> list = new ArrayList<>(5);
        list.add(2); list.add(1);list.add(4); list.add(3); list.add(5);
        TreeRoot treeRoot = new TreeRoot();
        for (Integer one : list) {
            CreateTree(treeRoot,one);
        }
        System.out.println("中序遍历的结果是：");
        LDR(treeRoot.getTreeRoot());
        System.out.println("author:zsp");

    }
    public static void LDR(TreeNode rootTreeNode){
        if (rootTreeNode!=null){
            LDR(rootTreeNode.getLeftTreeNode());
            System.out.print(rootTreeNode.getValue()+"--");
            LDR(rootTreeNode.getRightTreeNode());

        }
    }
    public static void LRD(TreeNode rootTreeNode){
        if (rootTreeNode!=null){
            LRD(rootTreeNode.getLeftTreeNode());
            LRD(rootTreeNode.getRightTreeNode());
            System.out.print(rootTreeNode.getValue()+"--");
        }
    }

    public static void CreateTree(TreeRoot treeRoot,int  value){
        if (treeRoot.getTreeRoot()==null){ //如果传过来的树根为空，说明是第一个元素
            TreeNode treeNode = new TreeNode(value); //创建树结点，成为第根节点
            treeRoot.setTreeRoot(treeNode);
        }
        else{ //否则，说明是第二个元素
            TreeNode temRoot = treeRoot.getTreeRoot();//创建临时结点，防止出现树下有孩子
            while(treeRoot!=null){ //无限遍历，一直找到叶子结点的下位，就不找了
                if (value>temRoot.getValue()){ //大于放右边
                    if (temRoot.getRightTreeNode()==null){//查看结点是否为叶子结点
                        temRoot.setRightTreeNode(new TreeNode(value));
                        return;
                    }
                    else //有值，说明下面还有结点
                    {
                        temRoot=temRoot.getRightTreeNode();
                    }
                }else //小于放左边
                {
                    if (temRoot.getLeftTreeNode()==null){
                        temRoot.setLeftTreeNode(new TreeNode(value));
                        return;
                    }else{
                        temRoot=temRoot.getLeftTreeNode();
                    }
                }
            }
        }
    }
}

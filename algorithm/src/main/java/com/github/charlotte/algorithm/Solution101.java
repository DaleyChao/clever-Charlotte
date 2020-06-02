package com.github.charlotte.algorithm;

import java.util.ArrayList;

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<TreeNode> list = new ArrayList();
        ArrayList<TreeNode> listRight = new ArrayList();
        list.add(root);
        int size;
        while ((size = list.size())!=0){
            for (int i = 0; i < size; i++) {

                TreeNode node = list.get(0);
                TreeNode nodeRight = listRight.get(0);
                if (node.val !=nodeRight.val) {
                    return false;
                }
                if (node == null||nodeRight==null) {
                    continue;
                }
                list.add(node.left);
                list.add(node.right);
                listRight.add(nodeRight.right);
                listRight.add(nodeRight.left);

                list.remove(0);
                listRight.remove(0);
            }
        }
        return true;
    }
//
//    private boolean compare(TreeNode left, TreeNode right) {
//
//
//    }

//    private boolean compare(TreeNode left, TreeNode right) {
//        if (left == null && right == null) {
//            return true;
//        }
//        if (left == null || right == null || left.val != right.val) {
//            return false;
//        }
//        return compare(left.left, right.right) && compare(left.right, right.left);
//    }
}
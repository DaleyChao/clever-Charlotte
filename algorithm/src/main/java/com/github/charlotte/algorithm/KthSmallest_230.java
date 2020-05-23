package com.github.charlotte.algorithm;

public class KthSmallest_230 {


    public static void main(String[] args) {

    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int n = 0;
    public int kthSmallest(TreeNode root, int k) {
        read(root,k);
        return value;
    }

    int value = 0;
    public void read(TreeNode root,int k){
        if(root.left!=null){
            read(root.left,k);
        }
        n++;
        if(n==k){
            value = root.val;
        }
        if(root.right!=null){
            read(root.right,k);
        }
    }
}

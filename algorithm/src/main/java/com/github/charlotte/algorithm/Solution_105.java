package com.github.charlotte.algorithm;
//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> preMap = new HashMap(16);
        Map<Integer, Integer> inMap = new HashMap(16);
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder,0,inorder,preMap,inMap);
    }

    public TreeNode build(int[] preorder,int preIndex, int[] inorder,Map<Integer,Integer> preMap,Map<Integer,Integer> inMap){
        if(preMap.containsKey(preIndex) || preIndex>=preorder.length){
            return null;
        }
        preMap.put(preorder[preIndex],preIndex);
        int inIndex = inMap.get(preorder[preIndex] );

//        if(preIndex<=inIndex){
            TreeNode treeNode = new TreeNode(preorder[preIndex]);
            int x = inorder[inIndex-1];
            if(!preMap.containsKey(x)||preIndex==preorder[preIndex +1]){
                treeNode.left = build(preorder,preIndex +1,inorder,preMap,inMap);
            }
            treeNode.right = build(preorder,preIndex +2,inorder,preMap,inMap);
            return treeNode;
//        }
//        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

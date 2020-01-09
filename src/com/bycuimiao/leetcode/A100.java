package com.bycuimiao.leetcode;

/**
 * @Description TODO
 * @Date 2020/1/8 11:29 下午
 * @Author bycuimiao
 **/
public class A100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }
}

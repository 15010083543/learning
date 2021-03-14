package com.leetcode.leetcode.editor.cn;
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1161 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution39 {
    public static void main(String[] args) {
        Solution39 solution = new Solution39();
        List<List<Integer>> lists = solution.combinationSum(new int[]{2,3,5,7}, 7);
        System.out.println(lists);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len  = candidates.length;
        List<List<Integer>> sum = new ArrayList<>();
        if (0 == len) {
            return sum;
        }
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> deque = new ArrayDeque();
        dfs(candidates, 0, len, target, deque, sum);
        return sum;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (target-candidates[i] < 0) {
                break;
            }
             path.addLast(candidates[i]);
            dfs(candidates, i, len, target-candidates[i], path, res);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

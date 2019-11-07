package com.bycuimiao.leetcode;

/**
 * @Description
 * 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
 *
 * +----+--------+
 * | Id | Salary |
 * +----+--------+
 * | 1  | 100    |
 * | 2  | 200    |
 * | 3  | 300    |
 * +----+--------+
 * 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
 *
 * +---------------------+
 * | SecondHighestSalary |
 * +---------------------+
 * | 200                 |
 * +---------------------+
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-highest-salary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2019/11/6 10:14 下午
 * @Author bycuimiao
 **/
public class Q176 {
    /**
     * SELECT
     *     IFNULL(
     *       (SELECT DISTINCT Salary
     *        FROM Employee
     *        ORDER BY Salary DESC
     *         LIMIT 1 OFFSET 1),
     *     NULL) AS SecondHighestSalary
     */
}
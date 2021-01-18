//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 581 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;  // 矩阵的行数
        int col = matrix[0].length;  // 矩阵的列数
        int count = (Math.min(row, col) + 1) / 2;  // 矩阵的层数,它是由行列中的较小值决定的,并且单行或单列也能作为一层
        int i = 0; // 当前遍历的层数
        //从外部向内部遍历，逐层打印数据
        while (i < count) {
            // 打印第i层元素时,一共分为以下四步:
            // 1.从左至右,按列数递增
            for (int j = i; j < col - i; j++) {
                list.add(matrix[i][j]);
            }
            // 2.从上至下,按行数递增
            for (int j = i + 1; j < row - i; j++) {
                list.add(matrix[j][(col - 1) - i]);
            }
            // 3.从右至左,按列数递减
            // 当某一层只有一行时,不需要执行这一步,第1步已经打印了
            for (int j = (col - 1) - (i + 1); j >= i && (row - 1 - i != i); j--) {
                list.add(matrix[(row - 1) - i][j]);
            }
            // 4.从下至上,按行数递减
            // 当某一层只有一列时,不需要执行这一步,第2步已经打印了
            for (int j = (row - 1) - (i + 1); j >= i + 1 && (col - 1 - i) != i; j--) {
                list.add(matrix[j][i]);
            }
            i++;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

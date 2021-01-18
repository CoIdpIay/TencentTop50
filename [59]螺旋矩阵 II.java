//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组 
// 👍 285 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int count = n-1; // 螺旋数组的层数
        int i = 0; // 当前的层数
        int [][] matrix = new int[n][n];
        int num = 1; // 填入到矩阵中的数值;
        if(n == 1 ){
            matrix[0][0] = 1;
            return matrix;
        }
        while(i < count){
            // 当填充第i层的时候
            // 1.从左向右填充,按列数递增方向
            // 特别的如果是最中间的那一层,只有唯一一个数,是由第1步执行填充的
            for(int j = i;j < n -i;j++){
                matrix[i][j] = num;
                num++;
            }
            // 2.从上向下填充,按行数递增方向
            for(int j  = i+1;j< n - i;j++){
                matrix[j][n-1-i] = num;
                num++;
            }
            // 3.从右向左填充,按列数递减方向
            for(int j = (n-1)-i-1;j >= i;j--){
                matrix[n-1-i][j] = num;
                num++;
            }
            // 4. 从下往上填充,按行数递减方向
            for(int j = (n-1)-i-1;j>=i+1;j--){
                matrix[j][i] = num;
                num++;
            }
            i++;
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 484 👎 0


import javax.sound.midi.Soundbank;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 3*3矩阵:
     * 2,0->0,0->0,2->2,2
     * 2,1->1,0->0,1->1,2
     * =>> n-rotate[i][j]=[j][n-i]
     * 不使用额外空间思路: 利用递归,将当前要旋转的值保存作为临时变量,先将要被覆盖的值旋转(递归)
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int [][] hasRotate=new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                rotateSingle(matrix, i, j, i, j, matrix[i][j], hasRotate);
                System.out.println("\n");
            }
        }
    }

    /**
     * 通过递归,将要被旋转赋值的元素,先旋转赋值到下一个元素
     * 示例:
     * 一个3阶矩阵,此时要旋转[2,0]->[0,0]. 此时[0,0]会被覆盖.
     * 因此先将[0,0]->[0,2] 同理[0,2]->[2,0]
     * @param matrix  矩阵
     * @param originI 原始要旋转的i
     * @param originJ 原始要旋转的j
     * @param ii      当前要旋转的i
     * @param jj      当前要旋转的j
     * @param value   matrix[i][j]的值
     * @param hasRotate 标记哪些被旋转过
     */
    private void rotateSingle(int[][] matrix, int originI, int originJ, int ii, int jj, int value, int[][] hasRotate) {
        //先计算旋转后的坐标
        int rotateI = jj, rotateJ = matrix.length - 1 - ii;
        //跳出条件
        if (hasRotate[originI][originJ] == 1) {
            return;
        }
        //获取要被旋转后要被覆盖的值
        int originValue = matrix[rotateI][rotateJ];
        //System.out.println(String.format("[%d,%d]%d->[%d,%d]%d", ii, jj, value, rotateI, rotateJ, originValue));
        //再将自身的值赋值给要被旋转覆盖的元素
        matrix[rotateI][rotateJ] = value;
        hasRotate[rotateI][rotateJ] = 1;

        //将要被旋转覆盖的值先赋值给下一位
        rotateSingle(matrix, originI, originJ, rotateI, rotateJ, originValue, hasRotate);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

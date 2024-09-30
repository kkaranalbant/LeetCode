/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rotateimage;

/**
 *
 * @author kaan
 */
/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

 

Constraints:

    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000


 */
public class RotateImage {

    public static void main(String[] args) {

        rotateMatrix(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {16, 7, 10, 11}}, 5, 4, 0, 0, 1);

    }

    private static void rotateMatrix(int[][] matrix, int value, int n, int i, int j, int rotateCounter) {
        if (n <= 1) {
            return;
        }
        int boundIndex = (matrix.length - 1) - ((matrix.length - n) / 2);
        if (rotateCounter > 4) {
            if (i < boundIndex - 1 && j < boundIndex - 1) {
                j++;
            } else {
                n -= 2;
                boundIndex = (matrix.length - 1) - ((matrix.length - n) / 2);
                i = boundIndex - n + 1;
                j = boundIndex - n + 1;
            }
            rotateCounter = 1;
            rotateMatrix(matrix, matrix[i][j], n, i, j, rotateCounter);
            return;
        }
        int rotateAmount = n - 1;
        for (int k = 0; k < rotateAmount; k++) {
            if (j < boundIndex && i == boundIndex - rotateAmount) {
                j++;
            } else if (i < boundIndex && j == boundIndex) {
                i++;
            } else if (j == boundIndex && i == boundIndex) {
                j--;
            } else if (i == boundIndex && j < boundIndex && j > (boundIndex - rotateAmount)) {
                j--;
            } else if (i <= boundIndex && j == (boundIndex - rotateAmount)) {
                i--;
            }

        }
        int tmp = matrix[i][j];
        matrix[i][j] = value;
        rotateCounter++;
        rotateMatrix(matrix, tmp, n, i, j, rotateCounter);
    }

}

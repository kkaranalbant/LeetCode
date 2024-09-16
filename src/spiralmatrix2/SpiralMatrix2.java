/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spiralmatrix2;

/**
 *
 * @author kaan
 */

/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:

Input: n = 1
Output: [[1]]

 

Constraints:

    1 <= n <= 20


 */
public class SpiralMatrix2 {

    public static void main(String[] args) {

        int[][] matrix = generateMatrix(6);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startIndex = 0;
        int firstElementValue = 1;
        while (n >= 1) {
            addSpiralValuesToEdges(matrix, firstElementValue, n, startIndex);
            firstElementValue += 4 * n - 4;
            n -= 2;
            startIndex++;
        }
        return matrix;
    }

    private static void addSpiralValuesToEdges(int[][] matrix, int firstElementValue, int n, int startIndex) {
        matrix[startIndex][startIndex] = firstElementValue;
        if (n == 1) {
            return;
        }
        int leftRowCounter = 0;
        for (int i = startIndex + 1; i <= startIndex + 1 + n - 2; i++) {
            matrix[i][startIndex] = 4 * n - 5 - leftRowCounter + firstElementValue;
            leftRowCounter++;
        }
        int upColumnCounter = 0;
        for (int i = startIndex + n - 1; i >= startIndex + 1; i--) {
            matrix[startIndex][i] = firstElementValue + n - 1 - upColumnCounter;
            upColumnCounter++;
        }
        int rightRowCounter = 0;
        for (int i = startIndex + n - 1; i >= startIndex + 1; i--) {
            matrix[i][startIndex + n - 1] = 2 * n - 2 - rightRowCounter + firstElementValue;
            rightRowCounter++;
        }
        int downColumnCounter = 0;
        for (int i = startIndex + 1; i < startIndex + 1 + n - 2; i++) {
            matrix[startIndex + n - 1][i] = firstElementValue + 3 * n - 4 - downColumnCounter;
            downColumnCounter++;
        }
    }

}

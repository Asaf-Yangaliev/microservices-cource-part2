package uz.yangaliev.functions.calculator;

import org.springframework.stereotype.Component;

@Component
public class MatrixCalculator {

    public int determinant(int[][] matrix) {
        if (!isSquareMatrix(matrix))
            throw new IllegalArgumentException("Matrix must be square");
        if (matrix.length == 1)
            return matrix[0][0];
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            sum += minusOnePow(i) * matrix[0][i] * determinant(getSubMatrix(matrix, 0, i));
        }
        return sum;
    }

    private int[][] getSubMatrix(int[][] matrix, int n, int m) {
        int[][] result = new int[matrix.length - 1][matrix[0].length - 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, result[i], 0, m);
            System.arraycopy(matrix[i], m + 1, result[i], m, matrix[i].length - m - 1);
        }
        for (int i = n + 1; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, result[i - 1], 0, m);
            System.arraycopy(matrix[i], m + 1, result[i - 1], m, matrix[i].length - m - 1);
        }
        return result;
    }

    private boolean isSquareMatrix(int[][] matrix) {
        if (matrix == null)
            throw new IllegalArgumentException("Matrix must not be null");
        for (int[] row : matrix) {
            if (row.length != matrix.length)
                return false;
        }
        return true;
    }

    private int minusOnePow(int n) {
        return n % 2 == 0 ? 1 : -1;
    }
}

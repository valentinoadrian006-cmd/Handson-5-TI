import java.util.Arrays;
import java.util.Random;

public class ArraysDeepDivePractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Arrays Deep Dive
         */

        // ===== ARRAY MULTIDIMENSI DASAR =====
        System.out.println("=== ARRAY MULTIDIMENSI DASAR ===");

        // Latihan 1
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        displayMatrix(matrix);

        // Latihan 2
        String[][] board = {
                {".", ".", "."},
                {".", ".", "."},
                {".", ".", "."}
        };
        board[0][0] = "X"; board[1][1] = "X"; board[2][2] = "X";
        board[0][2] = "O"; board[1][0] = "O"; board[2][1] = "O";

        System.out.println("Papan TicTacToe:");
        for (String[] row : board) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        // ===== ARRAY JAGGED =====
        System.out.println("\n=== ARRAY JAGGED (IRREGULAR) ===");
        int[][] jagged = new int[4][];
        jagged[0] = new int[2];
        jagged[1] = new int[4];
        jagged[2] = new int[3];
        jagged[3] = new int[5];

        int counter = 1;
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                jagged[i][j] = counter++;
            }
        }
        for (int i = 0; i < jagged.length; i++) {
            System.out.println("Row " + i + " (" + jagged[i].length + "): " + Arrays.toString(jagged[i]));
        }

        // ===== OPERASI LANJUTAN =====
        System.out.println("\n=== OPERASI LANJUTAN PADA ARRAY ===");
        int[][] m1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] m2 = {{6, 5, 4}, {3, 2, 1}};
        int[][] sum = addMatrices(m1, m2);
        int[][] scaled = multiplyByScalar(m1, 2);
        System.out.println("M1 + M2:");
        displayMatrix(sum);
        System.out.println("M1 * 2:");
        displayMatrix(scaled);

        // ===== PARAMETER & RETURN =====
        System.out.println("\n=== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE ===");
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original: " + Arrays.toString(numbers));
        int[] sorted = sortArray(numbers.clone());
        System.out.println("Sorted: " + Arrays.toString(sorted));
        int[] reversed = reverseArray(sorted);
        System.out.println("Reversed: " + Arrays.toString(reversed));
        int[] minMax = findMinMax(numbers);
        System.out.println("Min = " + minMax[0] + ", Max = " + minMax[1]);

        // ===== ARRAYS UTILITY =====
        System.out.println("\n=== UTILITY METHODS JAVA.UTIL.ARRAYS ===");
        int[] data = {5, 2, 8, 1, 9, 3};
        System.out.println("Original: " + Arrays.toString(data));
        Arrays.sort(data);
        System.out.println("Sorted: " + Arrays.toString(data));
        int pos = Arrays.binarySearch(data, 8);
        System.out.println("Index of 8: " + pos);
        Arrays.fill(data, 7);
        System.out.println("Filled with 7: " + Arrays.toString(data));
        int[] copy = Arrays.copyOf(data, 10);
        System.out.println("Copy (size 10): " + Arrays.toString(copy));

        // ===== ARRAY 3D =====
        System.out.println("\n=== ARRAY 3D DAN KOMPLEKS ===");
        int[][][] arr3D = new int[2][3][4];
        counter = 1;
        for (int i = 0; i < arr3D.length; i++) {
            for (int j = 0; j < arr3D[i].length; j++) {
                for (int k = 0; k < arr3D[i][j].length; k++) {
                    arr3D[i][j][k] = counter++;
                }
            }
        }
        for (int i = 0; i < arr3D.length; i++) {
            System.out.println("Matrix " + i + ":");
            displayMatrix(arr3D[i]);
        }

        // ===== SKENARIO NYATA =====
        System.out.println("\n=== SKENARIO APLIKASI NYATA ===");
        String[] namaMahasiswa = {"Alice", "Bob", "Charlie", "Diana", "Eva"};
        String[] mataKuliah = {"Math", "Physics", "Chemistry", "Biology"};
        int[][] grades = new int[namaMahasiswa.length][mataKuliah.length];
        fillRandomGrades(grades, 60, 100);

        System.out.print("Nama\t");
        for (String mk : mataKuliah) {
            System.out.print(mk + "\t");
        }
        System.out.println("Rata-rata");

        double highest = 0;
        String topStudent = "";
        for (int i = 0; i < namaMahasiswa.length; i++) {
            System.out.print(namaMahasiswa[i] + "\t");
            double avg = calculateAverage(grades[i]);
            for (int j = 0; j < mataKuliah.length; j++) {
                System.out.print(grades[i][j] + "\t");
            }
            System.out.println(avg);
            if (avg > highest) {
                highest = avg;
                topStudent = namaMahasiswa[i];
            }
        }
        System.out.println("Mahasiswa terbaik: " + topStudent + " (" + highest + ")");
    }

    // ===== IMPLEMENTASI METHODS =====
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyByScalar(int[][] matrix, int scalar) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }
        return result;
    }

    public static int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static int[] reverseArray(int[] arr) {
        int n = arr.length;
        int[] rev = new int[n];
        for (int i = 0; i < n; i++) {
            rev[i] = arr[n - 1 - i];
        }
        return rev;
    }

    public static int[] findMinMax(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int n : arr) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        return new int[]{min, max};
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
    }

    public static void fillRandomGrades(int[][] grades, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
                grades[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }
    }

    public static double calculateAverage(int[] values) {
        int sum = 0;
        for (int v : values) sum += v;
        return (double) sum / values.length;
    }
}

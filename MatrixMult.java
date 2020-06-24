import java.util.Scanner;

class MatrixMult {
    public static void main(String[] args) {
        System.out.println("Enter matrix A");
        System.out.println("Enter n for nxm A matrix");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter m for nxm A matrix");
        int m = sc.nextInt();
        int[][] A = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.out.println("Row " + (i + 1));
            for (int l = 0; l < m; l++) {
                System.out.println("Element " + (l + 1));
                A[i][l] = sc.nextInt();
            }
        }
        System.out.println("Enter matrix B");
        System.out.println("Enter n for nxm B matrix");

        int t = sc.nextInt();
        System.out.println("Enter m for nxm B matrix");
        int q = sc.nextInt();
        int[][] B = new int[t][q];
        for (int i = 0; i < t; i++) {
            System.out.println("Row " + (i + 1));
            for (int l = 0; l < q; l++) {
                System.out.println("Element " + (l + 1));
                A[i][l] = sc.nextInt();
            }
        }
        if (m != t || n != q) {
            System.out.println("These matrices can't be multiplies");
        } else {

        }
    }
}
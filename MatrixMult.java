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
        int[][] B = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.out.println("Row " + (i + 1));
            for (int l = 0; l < n; l++) {
                System.out.println("Element " + (l + 1));
                B[i][l] = sc.nextInt();
            }
        }
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0;
                for (int x = 0; x < m; x++) {
                    C[i][j] = C[i][j] + A[i][x] * B[x][j];
                }
                System.out.print(C[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
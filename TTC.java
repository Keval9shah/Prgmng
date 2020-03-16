import java.util.Scanner;
import java.util.Arrays;

public class TTC {
    public static void main(String[] args) {
        int input = 12, t1 = 90, t2 = 90;// Random values
        char k = '?', m = '~';
        Boolean mad = true;
        char[][] xy = new char[3][3];
        int[] occupied = new int[9];
        Arrays.fill(occupied, 0);
        String p1 = "Motu", p2 = "Patlu";
        xy[0][0] = '1';
        xy[0][1] = '2';
        xy[0][2] = '3';
        xy[1][0] = '4';
        xy[1][1] = '5';
        xy[1][2] = '6';
        xy[2][0] = '7';
        xy[2][1] = '8';
        xy[2][2] = '9';
        Scanner r = new Scanner(System.in);
        System.out.println("Want to play with Computer(y/n)??");
        char comp = 'n', frst = 'n';
        comp = r.next().charAt(0);
        // Computer Choice
        if (comp == 'y') {
            System.out.println("Want Computer to play first(y/n)??");
            frst = r.next().charAt(0);
            System.out.println("Enter name for player");
            if (frst == 'y') {
                p1 = "Computer";
                p2 = r.next();
            } else {
                p1 = r.next();
                p2 = "Computer";
                frst = 'n';
            }
        } else {
            System.out.println("Enter name for player 1");
            p1 = r.next();
            System.out.println("Enter name for player 2");
            p2 = r.next();
            comp = 'n';
        }
        if (comp == 'y' && frst == 'y') {
            System.out.println("for " + p2 + " X or O ??");
        } else {
            System.out.println("for " + p1 + " X or O ??");
        }
        char XorO = r.next().charAt(0);
        if (comp == 'y' && frst == 'y') {
            if (XorO == 'o' || XorO == 'O') {
                m = 'O';
                k = 'X';
            } else if (XorO == 'x' || XorO == 'X') {
                m = 'X';
                k = 'O';
            }
        } else if (XorO == 'o' || XorO == 'O') {
            k = 'O';
            m = 'X';
        } else if (XorO == 'x' || XorO == 'X') {
            k = 'X';
            m = 'O';
        }
        Put p = new Put();
        System.out.println("Enter position according to this layout\n1   2   3\n4   5   6\n7   8   9");
        String s;
        for (int l = 1; l <= 9; l++) {
            // Input
            if (l % 2 == 1) {
                if (frst == 'y') {
                    s = p1;
                    input = p.put(occupied, frst);
                    mad = false;
                    System.out.println("Time for Computer to Enter\n");
                    occupied[input - 1] = 1;
                } else {
                    s = p1;
                    System.out.println(s + " Enter your position");
                }
            } else {
                if (comp == 'y' && frst == 'n') {
                    s = p2;
                    input = p.put(occupied, frst);
                    mad = false;
                    System.out.println("Time for Computer to Enter\n");
                    occupied[input - 1] = 2;
                } else {
                    s = p2;
                    System.out.println(s + " Enter your position");
                }
            }
            while (mad) {
                input = r.nextInt();
                if (input < 1 || input > 9) {
                    System.out.println(s + " beta masti nai\nEnter input again\n");
                    mad = true;
                } else {
                    if (occupied[input - 1] != 0) {
                        System.out.println(s + " betaaa masti naii\nEnter input again\n");
                        mad = true;
                    } else {
                        if (l % 2 == 1) {
                            occupied[input - 1] = 1;
                        } else {
                            occupied[input - 1] = 2;
                        }
                        mad = false;
                    }
                }
            }
            mad = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("  ");
                    if ((i) * 3 + j + 1 == input) {
                        t1 = i;
                        t2 = j;
                        if (l % 2 == 1) {
                            xy[i][j] = k;
                        } else {
                            xy[i][j] = m;
                        }
                    }
                    System.out.print(xy[i][j]);
                    if (j != 2) {
                        System.out.print("  |");
                    }
                }
                if (i != 2) {
                    System.out.print("\n-----|-----|-----\n");
                } else {
                    System.out.print("\n");
                }
            }
            if (check(t1, t2, xy) && s != "Computer") {
                System.out.println("\n\n" + s + " won!!\nCongratulations");
                break;
            } else if (check(t1, t2, xy)) {
                System.out.println("\n\n" + s + " won!!\n");
                break;
            } else if (l == 9) {
                System.out.println("\n---Draw!\n");
            }
        }
        r.close();
    }

    static boolean check(int a, int b, char[][] xy) {

        // Horizontal
        if (xy[a][0] == xy[a][1] && xy[a][1] == xy[a][2]) {
            return true;
        }
        // Vertical
        else if (xy[0][b] == xy[1][b] && xy[1][b] == xy[2][b]) {
            return true;
        }
        // Cross
        else if (xy[0][0] == xy[1][1] && xy[1][1] == xy[2][2]) {
            return true;
        } else if (xy[0][2] == xy[1][1] && xy[1][1] == xy[2][0]) {
            return true;
        }
        return false;
    }
}

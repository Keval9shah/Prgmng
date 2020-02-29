import java.util.Scanner;

public class TTC {
    public static void main(String[] args) {
        int input = -1, t1 = 90, t2 = 90, t = 0;// Random values
        int[] occupied = new int[9];
        char k = '?', m = '~';
        boolean mad = true;
        char[][] xy = new char[3][3];
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
        System.out.println("Do you want to play with Computer(y/n)?");
        char ans = r.next().charAt(0);
        String p1, p2;
        if (ans == 'y' || ans == 'Y') {
            System.out.println("What is player's name?");
            p1 = r.next();
            p2 = "Computerji";
        } else {
            System.out.println("Enter name for player 1");
            p1 = r.next();
            System.out.println("Enter name for player 2");
            p2 = r.next();
        }
        System.out.println("for " + p1 + " X or O ??");
        char rw = r.next().charAt(0);

        if (rw == 'o' || rw == 'O') {
            k = 'O';
            m = 'X';
        } else if (rw == 'x' || rw == 'X') {
            k = 'X';
            m = 'O';
        }

        System.out.println("Enter position according to this layout\n1   2   3\n4   5   6\n7   8   9");
        String s;

        for (int l = 1; l <= 9; l++) {

            if (l % 2 == 1) {
                s = p1;
                System.out.println(s + " Enter your position");
            } else {
                s = p2;
                System.out.println(s + " Enter your position");
            }
            while (mad) {
                input = r.nextInt();

                if (input > 9 || input < 1) {
                    System.out.println("Invalid Input\nEnter again");
                    mad = true;
                } else {
                    if (occupied[input - 1] == 1 || occupied[input - 1] == 2) {
                        System.out.println("\n" + s + " beta masti nai!\n\nEnter again");
                        mad = true;
                    } else {
                        occupied[input - 1] = (2 - l % 2);
                        mad = false;
                    }
                }
            }
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
            if (check(t1, t2, xy)) {
                System.out.println("\n\n" + s + " won!!\nCongratulations");
                break;
            }
            mad = true;
        }
        r.close();
    }

    static boolean check(int a, int b, char[][] xy) {
        if (xy[a][0] == xy[a][1] && xy[a][1] == xy[a][2]) {
            return true;
        }
        if (xy[0][b] == xy[1][b] && xy[1][b] == xy[2][b]) {
            return true;
        }
        if (a == b) {
            return xy[0][0] == xy[1][1] && xy[1][1] == xy[2][2];
        }
        if (a + b == 2) {
            return xy[0][2] == xy[1][1] && xy[1][1] == xy[2][0];
        }
        return false;
    }

    // static int put(char[][] xy) {
    //     
    // }
}

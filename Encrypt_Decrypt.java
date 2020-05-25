import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Encrypt_Decrypt {

    public static void main(String[] args) throws IOException {
        Scanner n = new Scanner(System.in);
        while (true) {
            System.out.println("Encrypt  -->  1\t\tOR\nDecrypt  -->  2\t\tOR\nExit  -->  3");
            String y = n.nextLine();
            if (y.length() != 0) {
                Encrypt_Decrypt eod = new Encrypt_Decrypt();
                String x1 = "";
                if (y.charAt(0) == '1' && y.length() == 1) {
                    System.out.println("Enter a String");
                    x1 = n.nextLine();
                    eod.StoreData(x1);
                    String Enc = eod.e(x1);
                    System.out.println("Encrypted Text:\n\n" + Enc + "\n");
                } else if (y.charAt(0) == '2' && y.length() == 1) {
                    System.out.println("Enter a String");
                    x1 = n.nextLine();
                    String Dec = eod.d(x1);
                    eod.StoreData(Dec);
                    System.out.println("Decrypted Text:\n\n" + Dec + "\n");
                } else if (y.charAt(0) == '3' && y.length() == 1) {
                    break;
                } else {
                    System.out.println("What??");
                }
            }
        }
        n.close();
    }

    String e(String x) {
        int len = x.length();
        int count = 0;
        int len1 = (int) Math.sqrt(len);
        if (len > (len1 * len1)) {
            len1++;
        }
        char[][] new_st = new char[len1][len1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len1; j++) {
                if (count < len) {
                    if (count % 2 == 0) {
                        new_st[i][j] = (char) ((int) x.charAt(count) + 1);
                    } else {
                        new_st[i][j] = (char) ((int) x.charAt(count) + 2);
                    }
                    count++;
                } else {
                    new_st[i][j] = '\0';
                }
            }
        }
        String new_str = "";
        for (int i = 0; i < len1; i++) {
            for (int j = len1 - 1; j >= 0; j--) {
                if (new_st[j][i] != '\0') {
                    new_str += new_st[j][i];
                }
            }
        }
        return new_str;
    }

    String d(String x) {
        int len = x.length();
        int count = 0;
        int len1 = (int) Math.sqrt(len);
        if (len > (len1 * len1)) {
            len1++;
        }
        char[][] new_st = new char[len1][len1];
        for (int i = 0; i < len1; i++) {
            for (int j = len1 - 1; j >= 0; j--) {
                if ((j * len1 + i + 1) > len) {
                    new_st[j][i] = '\0';
                } else {
                    new_st[j][i] = x.charAt(count);
                    count++;
                }
            }
        }
        String new_str = "";
        count = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len1; j++) {
                if (new_st[i][j] != '\0') {
                    if (count % 2 == 0) {
                        new_str += (char) ((int) new_st[i][j] - 1);
                    } else {
                        new_str += (char) ((int) new_st[i][j] - 2);
                    }
                    count++;
                }
            }
        }
        return new_str;
    }

    void StoreData(String txt) throws IOException {
        File f = new File("C:\\Made_by_Keval/data.txt");

        File dir = new File("C:\\Made_by_Keval");
        dir.mkdir();
        Path path = FileSystems.getDefault().getPath("C:\\Made_by_Keval");
        Files.setAttribute(path, "dos:hidden", true);
        try {
            FileWriter wrtr = new FileWriter(f, true);
            wrtr.append(txt);
            wrtr.append('\n');
            wrtr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
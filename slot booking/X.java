import java.io.IOException;
import java.util.Scanner;

/**
 * X
 */
public class X {

    public static void main(String[] args) throws IOException {
        System.out.println("\nLibrary slot booking\n");

        boolean cont = true;

        Scanner sc = new Scanner(System.in);

        while (cont) {

            System.out.println("Enter your name");

            String name = sc.nextLine();

            System.out.println("Enter date in dd/mm/yyyy format");
            String date = sc.nextLine();

            System.out.println("Enter time in 24 hr format");
            int time = sc.nextInt();

            D d = new D();
            int intmdt = d.Checkdate(name, date, time);
            if (intmdt == 2) {
                System.out.println("Do you have Time Machine?");
                System.out.println("Bcuz You wanna book slot in past");
            } else if (intmdt == 1) {
                System.out.println("Done!!\nOn " + date + " at " + time + " o'clock");
            } else if (intmdt == 3) {
                System.out.println("Date format incorrect");
            } else if (intmdt == 4) {
                System.out.println("Sorry!  Library is occupied by another user at the same time\nPick other time");
            } else {
                System.out.println("Sorry\nNo slot available on that day & that time");
            }
            System.out.println("\n\nEnter 1 to continue or anything else to exit");
            int contn = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            if (contn == 1) {
                cont = true;
            } else {
                cont = false;
            }
        }

        sc.close();
    }
}
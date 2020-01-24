import java.util.Scanner;
public class alpha {
    public static void main(String[] args) {
        System.out.println("Enter a string");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.toUpperCase();
        for(int i=0;i<s.length();i++){
            if((int)s.charAt(i)>64 && (int)s.charAt(i)<91) {
                System.out.print((int) s.charAt(i) - 64 + " ");
            }
        }
    }
}

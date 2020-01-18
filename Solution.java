import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Scanner bc = new Scanner(System.in);
        int a = sc.nextInt();
        String[] stgs= new String[a];
        for(int i=0;i<a;i++){
            stgs[i]=bc.next();
        }
        int b = sc.nextInt();
        String[] qris = new String[b];
        for(int i=0;i<b;i++){
            qris[i]=bc.next();
        }
        int k;
        for(int i=0;i<b;i++){
            k=0;
            for(int l=0;l<a;l++){
                if(qris[i].equals(stgs[l])){
                    k++;
                }
            }
            System.out.println(k);
        }
    }
}

/**
 * Put
 */
public class Put {

    int put(int[] o) {
        for (int i = 0; i < 9; i++) {
            if (o[i] == 1) {
                System.out.println("Put.put()"+i);
                //Horizontal
                if (i+1<9 && o[i+1]==1 && o[i+2]==0){
                    System.out.println(i+2);
                    return i+3;
                }
                //Vertical
                else if (i+3<9 && o[i+3]==1){
                    if(i+6<9 && o[i+6]==0){
                        System.out.println(i+6);
                        return i+7;
                    }
                    else if(i-3>0 && o[i-3]==0){
                        System.out.println(i-2);
                        return i-2;
                    }
                }
            }
        }
        for(int i=0;i<9;i++){
            if(o[i]==0){
                return i+1;
            }
        }
        return 0;
    }
}
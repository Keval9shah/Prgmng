/**
 * Put
 */
public class Put {

    int put(int[] o){
        for(int i=0;i<o.length;i++){
            if(o[i]==1){
                return  i+2;
            }
        }
        return 0;
    }
}
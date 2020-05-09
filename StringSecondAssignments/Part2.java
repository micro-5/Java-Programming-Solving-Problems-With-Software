
/**
 * Write a description of Part2 here.
 * 
 * @author (micro-5) 
 * @version (09 May 2020)
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int index = stringb.indexOf(stringa);
        int len = stringa.length();
        int count = 0;
        while(index != -1){
            count++;
            index = stringb.indexOf(stringa, index+len);
        }
        return count;
    }
    
    public void testHowMany(){
        String a = "GAA";
        String b = "ATGAACGAATTGAATC";
        System.out.println(howMany(a,b));
    }
}


/**
 * Write a description of Part3 here.
 * 
 * @author (micro-5) 
 * @version (08 May 2020)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int first = stringb.indexOf(stringa);
        if(first != -1){
            int second = stringb.indexOf(stringa, first+stringa.length() - 1);
            if(second != -1){
                return true;
            }
            return false;
        }
        return false;
    }
    
    public void testing(){
        String a = "zoo";
        String b = "forest";
        
        System.out.println(twoOccurrences(a, b));
        System.out.println(lastPart(a, b));
    }
    
    public String lastPart(String stringa, String stringb){
        int first = stringb.indexOf(stringa);
        if(first != -1){
            return stringb.substring(first + stringa.length());
        }
        return stringb;
    }

}

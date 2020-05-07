
/**
 * Write a description of Part2 here.
 * 
 * @author (micro-5) 
 * @version (08 May 2020)
 */
public class Part2 {
    public String findSimpleGene(String str, String startCodon, String stopCodon){//str == dna
        if(Character.isUpperCase(str.charAt(0))){
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        }
        else
        {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        
        int startIndex = str.indexOf(startCodon);
        if(startIndex == -1){
            return "";
        }
        int stopIndex = str.indexOf(stopCodon, startIndex);
        if(stopIndex == -1){
            return "";
        }
        
        if((stopIndex - startIndex)%3 != 0){
            return "";
        }
        
        return str.substring(startIndex, stopIndex+3);
        
    }
    
    public void testSimpleGene(){
        String dna1 = "ATGTAA";
        System.out.println(findSimpleGene(dna1, "ATG", "TAA"));
        
        String dna2 = "ATTTTAGTAA";//no ATG
        System.out.println(findSimpleGene(dna2, "ATG", "TAA"));
        
        String dna3 = "atgatagtataa";//no TAA
        System.out.println(findSimpleGene(dna3, "ATG", "TAA"));
        
        String dna4 = "ATGGTATAA";
        System.out.println(findSimpleGene(dna4, "atg", "taa"));
        
        String dna5 = "CCAGCATGCCAGTAGCTAACAG";
        System.out.println(findSimpleGene(dna5, "ATG", "TAA"));
        
        
    }

}


/**
 * Write a description of Part1 here.
 * 
 * @author (micro-5) 
 * @version (08 May 2020)
 */
public class Part1 {
    public String findSimpleGene(String str){
        int startIndex = str.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        int stopIndex = str.indexOf("TAA", startIndex);
        if(stopIndex == -1){
            return "";
        }
        
        if((stopIndex - startIndex)%3 != 0){
            return "";
        }
        
        return str.substring(startIndex, stopIndex+3);
        
    }
    
    public void testSimpleGene(){
        String dna1 = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println(findSimpleGene(dna1));
        
        String dna2 = "ATTTTAGTAA";//no ATG
        System.out.println(findSimpleGene(dna2));
        
        String dna3 = "ATGTAGGTA";//no TAA
        System.out.println(findSimpleGene(dna3));
        
        String dna4 = "ATGGTATAA";
        System.out.println(findSimpleGene(dna4) + "");
        
        String dna5 = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println(findSimpleGene(dna5));
        
        
    }

}

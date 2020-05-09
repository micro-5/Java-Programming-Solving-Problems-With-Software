
/**
 * Write a description of Part1 here.
 * 
 * @author (micro-5) 
 * @version (09 May 2020)
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currStop = dna.indexOf(stopCodon, startIndex);
        while(currStop != -1){
            int diff = currStop - startIndex;
            if(diff % 3 == 0)
            {
                return currStop;
            }
            else
            {
                currStop = dna.indexOf(stopCodon, currStop + startIndex + 1);
            }
        }
        return dna.length();
    }
    
    public void testFindStopCodon(){
        String dna = "ATGTGATATTAA";
        int startIndex = 0;
        String stopCodon = "TAA";
        System.out.println(findStopCodon(dna, startIndex, stopCodon));
    }
    
    public String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int stopIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        
        if(stopIndex == dna.length()){
            return "";
        }
        return dna.substring(startIndex, stopIndex+3);
    }
    
    public void testFindGene(){
        String dna = "AATGCTAACTAGCTGACTAAT";
        System.out.println(findGene(dna));
    }
    
    public void printAllGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
                System.out.println("");
                return;
            }
        
        //int no = 1;
            
        while(true){
            if(startIndex == -1){
                //System.out.println("");
                return;
            }
            //System.out.println("check point0 no = " + no +" startIndex = " + startIndex);
            
            int taaIndex = findStopCodon(dna, startIndex, "TAA");
            int tagIndex = findStopCodon(dna, startIndex, "TAG");
            int tgaIndex = findStopCodon(dna, startIndex, "TGA");
            
            int stopIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
            //System.out.println("check point0A no = " + no +" stopIndex = " + stopIndex);
            if(stopIndex == dna.length()){
                break;
            }
            //System.out.println("check point1 no = "+no + " startIndex = " + startIndex);
            System.out.println(dna.substring(startIndex, stopIndex+3));
            //System.out.println("check point1A no = "+no + " startIndex = " + startIndex);
            startIndex = dna.indexOf("ATG", stopIndex);
            //System.out.println("check point2 no = "+no + " startIndex = " + startIndex);
            //no++;
        }
        
        return;
    }
    
    public void testPrintAllGene(){
        String dna = "ATGTAAGATGCCCTAGT";
        printAllGene(dna);
    }
}

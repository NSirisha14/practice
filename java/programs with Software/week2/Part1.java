import edu.duke.*;
/**
 * Write a description of class Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Part1
     */
    public Part1()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int findStopCodon(String dna,int startIndex,String stopCodon)
    {
        // put your code here
        int stopIndex=dna.indexOf(stopCodon,startIndex+3);
        
        if((stopIndex-startIndex)%3==0 && stopIndex!=-1)
        {
        return stopIndex;
        }
        else
        {
            return dna.length();
        }
    }
    
        public void testFindStopCodon()
    {
        String dna="TCHATGAAATAATAGAAABHJTGA";
         int startIndex=dna.indexOf("ATG");
       
        if(startIndex!=-1)
        {   
            int minIndex=findMinIndex(dna,startIndex);
            if(minIndex ==dna.length())
            {
           System.out.println("dna length "+minIndex);    
            }
            else
            {
             System.out.println("minIndex length "+minIndex+" String is "+dna.substring(startIndex,(minIndex+3)));    
            }
        }          
    }
    
     public int findMinIndex(String dna,int startIndex)
    {
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
 int minIndex=(tagIndex<taaIndex)?((tagIndex<tgaIndex)?tagIndex:tgaIndex):((taaIndex<tgaIndex)?taaIndex:tgaIndex);
      return minIndex;
    }
    
    public String findGene(String dna)
    {
        int startIndex=dna.indexOf("ATG");
       if(startIndex!= -1)
       {
           int stopIndex=findMinIndex(dna,startIndex);
           if(stopIndex!=dna.length())
           {
               return dna.substring(startIndex,stopIndex+3);
           }
            else
            {
                return "";
            }
        }
        return "";
    } 
    
    public void testFindGene()
    {
        String dna="AHYTAATAGAAAGGGCC";
        System.out.println("NO ATG "+findGene(dna));
        printAllGenes(dna);
        String dna1="ATGAAATAACCCATGAAATAGATGTGA";
        System.out.println("has ATG & taa"+findGene(dna1));
        printAllGenes(dna1);
        String dna2="ATGAAATGAAAATAACCCTAG";
        System.out.println("HAS ALL "+findGene(dna2));
        printAllGenes(dna2);
        String dna3="ATGAAACCCATG";
        System.out.println("NO stopCodon "+findGene(dna3));
        printAllGenes(dna3);
    }
    
    public void printAllGenes(String dna)
    {
         while(true)
        {
            String gene = findGene(dna);
            if(gene.equals(""))
            {
                break;
            }
            else
            {
                System.out.println("gene "+gene);
                dna = dna.substring(dna.indexOf(gene)+gene.length()-1);
               
               
            }
        }
    }
    
    public StorageResource getAllGenes(String dna)
    {
        StorageResource sr=new StorageResource();
         while(true)
        {
            String gene = findGene(dna);
            if(gene.equals(""))
            {
                break;
            }
            else
            {
                sr.add(gene);
               // System.out.println("gene "+gene);
                dna = dna.substring(dna.indexOf(gene)+gene.length()-1);
               
               
            }
        }
        return sr;
    }
     
    public void testOn()
    {
        StorageResource sr=getAllGenes("ATGAAACTGTAGCCCATGTAAACTATGTGA");
        for(String s:sr.data())
        {
            System.out.println("From getallgene method "+s);
        }
    }
}

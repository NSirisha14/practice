import edu.duke.*;
/**
 * Write a description of class Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Part1
     */
    public Part3()
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
        while(stopIndex!=-1)
        {
        if((stopIndex-startIndex)%3==0 )
        {
        return stopIndex;
        }
        else
        {
           stopIndex=dna.indexOf(stopCodon,stopIndex+1);
        }
      }
      return dna.length();
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
        int tagIndex =0,taaIndex=0,tgaIndex=0;
        if(Character.isUpperCase(dna.charAt(0)))
        {
         tagIndex = findStopCodon(dna,startIndex,"TAG");
         taaIndex = findStopCodon(dna,startIndex,"TAA");
         tgaIndex = findStopCodon(dna,startIndex,"TGA");
        }
        else
        {
         tagIndex = findStopCodon(dna,startIndex,"tag");
         taaIndex = findStopCodon(dna,startIndex,"taa");
         tgaIndex = findStopCodon(dna,startIndex,"tga");
        }
 int minIndex=(tagIndex<taaIndex)?((tagIndex<tgaIndex)?tagIndex:tgaIndex):((taaIndex<tgaIndex)?taaIndex:tgaIndex);
      return minIndex;
    }
    
    public String findGene(String dna)
    {
        int startIndex=0;
        if(Character.isLowerCase(dna.charAt(0)))
        {
            startIndex=dna.indexOf("atg");
        }
        else
        {
         startIndex=dna.indexOf("ATG");
        }
        
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
    
    public void processGenes(StorageResource sr)
    {
        
         int count=0;
        int larGene=0;
        for(String s:sr.data())
        {
            if(s.length()>0)
            {
                count++;
                larGene=Math.max(larGene,s.length());
             System.out.println("dna length >=60 "+s);
            }
          
        }
       System.out.println("Count and larGene "+count+" "+larGene);
    }
     
    public float cgRatio(String dna)
    {
        // put your code here
        char c,g;
        if(Character.isUpperCase(dna.charAt(0)))
        {
        c='C';
        g='G';
        }
        else
        {
            c='c';
            g='g';
        }
        int index=dna.indexOf(c);
        int index1=dna.indexOf(g);
        int count=0;
        while(true)
        {
            
            if(index == -1 && index1 ==-1)
            {
                break;
            }
            if(index !=-1)
            {
                 count++;
                index=dna.indexOf("C",index+1);
               
            }
             if(index1 !=-1)
            {
                index1=dna.indexOf("G",index1+1);
                count++;
            }
        }
       
        float CG= ((float)count)/dna.length();
       return CG;
       // System.out.println("cg ratio "+CG);
       
    }
    
    public void testOn()
    {
        //String dna="ATGAAATAGCTGATGACTACCTGAATGTAA";
        FileResource fr = new FileResource();
        String dna = fr.asString();
        System.out.println("dna "+dna);
        //String dna="atgaaaccctaa";
       int cgcount=0;
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
             double cg=Math.round(cgRatio(gene));
             System.out.println("cgratio "+cg);
             if(cg>=0.35)
             {
               System.out.println("cg string "+gene);
               cgcount++;
              }
               // System.out.println("gene "+gene);
                dna = dna.substring(dna.indexOf(gene)+gene.length()-1);   
            }
        }
        System.out.println("cgcount strings "+cgcount);
        processGenes(sr);
        
        
    }
}

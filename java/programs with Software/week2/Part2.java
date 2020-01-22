
/**
 * Write a description of class Part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Part2
     */
    public Part2()
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
    public void cgRatio(String dna)
    {
        // put your code here
        int index=dna.indexOf("C");
        int index1=dna.indexOf("G");
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
        System.out.println(count+"count "+dna.length());
        float CG= ((float)count)/dna.length();
        System.out.println(CG);
    }
}

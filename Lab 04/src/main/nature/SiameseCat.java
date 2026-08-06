package nature;

/**
 * 
 * @author Frederick Adongo
 * @version 6th February, 2024
 * 
 */
public class SiameseCat extends HouseCat 
{
    /**
     * One-arg constructor
     * @param name
     */
    public SiameseCat(String name)
    {
        super(name);
    }    

    /**
     * 
     */
    public void makeNoise()
    {
        System.out.println("mrrooowwww ...");
    }

    /**
     * 
     */
    public void play()
    {
        System.out.println("zoom zoom zoom ...");
    }
}

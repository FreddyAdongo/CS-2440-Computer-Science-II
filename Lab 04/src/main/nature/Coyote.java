package nature;

/**
 * 
 * @author Frederick Adongo
 * @version 6th February, 2024
 * 
 */
public class Coyote extends Canine
{
    /**
     * One-arg constructor
     * @param name
     */
    public Coyote(String name)
    {
        super(name);
    }

    /**
     * 
     */
    public void eat()
    {
        System.out.println("gnaws ...");
        hungerLevel -= 2;
    }

    /**
     * 
     */
    public void makeNoise()
    {
        System.out.println("howl ...");
    }
}

package nature;

/**
 * 
 * @author Frederick Adongo
 * @version 6th February, 2024
 * 
 */
public class Wolf extends Canine
{
    /**
     * One-arg constructor
     * @param name
     */
    public Wolf(String name)
    {
        super(name);
    }

    /**
     * 
     */
    public void eat()
    {
        System.out.println("rip with teeth ...");
        hungerLevel -= 2;
    }

    /**
     * 
     */
    public void makeNoise()
    {
        System.out.println("growl ...");
    }
}

package nature;

/**
 * 
 * @author Frederick Adongo
 * @version 6th February, 2024
 * 
 */
public class Ocelot extends Feline
{
    /**
     * One-arg constructor
     * @param name
     */
    public Ocelot(String name)
    {
        super(name);
    }

    /**
     * 
     */
    public void eat()
    {
        System.out.println("pick ...");
        hungerLevel -= 3;
    }
}

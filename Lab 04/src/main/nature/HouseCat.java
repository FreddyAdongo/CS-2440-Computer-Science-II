package nature;

/**
 * 
 * @author Frederick Adongo
 * @version 6th February, 2024
 * 
 */
public class HouseCat extends Feline implements Pet
{
    /**
     * One-arg constructor
     * @param name
     */
    public HouseCat(String name)
    {
        super(name);
    }

    /**
     * 
     */
    public void eat()
    {
        System.out.println("crunch crunch ...");
        hungerLevel -= 3;
    }

    /**
     * 
     */
    public void beFriendly()
    {
        System.out.println("purr ...");
    }

    /**
     * 
     */
    public void play()
    {
        System.out.println("frolic ...");
    }

}

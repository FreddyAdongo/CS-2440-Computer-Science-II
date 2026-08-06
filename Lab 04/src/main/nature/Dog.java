package nature;

/**
 * 
 * @author Frederick Adongo
 * @version 6th February, 2024
 * 
 */
public class Dog extends Canine implements  Pet 
{
 
    /**
     * One-arg constructor
     * @param name
     */
    public Dog(String name)
    {
        super(name);
    }

    /**
     * 
     */
    public void eat()
    {
        System.out.println("slop ...");
        hungerLevel -= 3;
    }

    /**
     * 
     */
    public void makeNoise()
    {
        System.out.println("bark ...");
    }

    /**
     * 
     */
    public void beFriendly()
    {
        System.out.println("nuzzles ...");
    }

    /**
     * 
     */
    public void play()
    {
        System.out.println("runs ...");
    }
}

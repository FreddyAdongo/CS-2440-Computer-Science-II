package nature;

/**
 * 
 * @author Frederick Adongo
 * @version 6th February, 2024
 * 
 */
public abstract class Feline extends Animal
{
    /**
     * One-arg constructor
     * @param name
     */
    public Feline(String name)
    {
        super(name);
    }

    /**
     * 
     */
    public void roam()
    {
        System.out.println("felines like to roam alone ...");
        hungerLevel++;
    }

    /**
     * 
     */
    public void sleep()
    {
        setHungerLevel(10);
        System.out.println("taking a cat nap ...");
    }

    /**
     * 
     */
    public void makeNoise()
    {
        System.out.println("meow ...");
    }
}
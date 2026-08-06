package nature;

/**
 * 
 * @author Frederick Adongo
 * @version 6th February, 2024
 * 
 */
public class Hippo extends Animal
{
    /**
     * One-arg constructor
     * @param name
     */
    public Hippo(String name)
    {
        super(name);
    }

    public void eat()
    {
        System.out.println("slurp ...");
        hungerLevel--;
    }

    public void makeNoise()
    {
        System.out.println("blub ...");
    }
}

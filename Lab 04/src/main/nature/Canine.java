package nature;

/**
 * 
 * @author Frederick Adongo
 * @version 6th February, 2024
 * 
 */
public abstract class Canine extends Animal
{
    /**
     * One-arg constructor
     * @param name
     */
    public Canine(String name)
    {
        super(name);
    }

    /**
     * 
     */
    public void roam()
    {
        System.out.println("like canines roam in packs ...");
        hungerLevel++;
    }
}

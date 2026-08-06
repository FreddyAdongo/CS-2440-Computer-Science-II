package nature;

/**
 * 
 * @author Frederick Adongo
 * @version 6th February, 2024
 * 
 */
public class Lion extends Feline
{

    /**
     * One-arg constructor
     * @param name
     */
    public Lion(String name)
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
        System.out.println("roar ...");
    }   
}

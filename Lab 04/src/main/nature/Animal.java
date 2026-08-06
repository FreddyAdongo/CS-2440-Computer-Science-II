package nature;

/**
 * 
 * @author Frederick Adongo
 * @version 6th February, 2024
 * 
 */
public abstract class Animal
{
    protected String name;
    protected int hungerLevel;

    /**
     * One-arg constructor
     * @param name
     */
    public Animal(String name)
    {
        this.name = name;
    }

    /**
     * 
     * @return int
     */
    public int getHungerLevel()
    {
        return hungerLevel;
    }

    /**
     * 
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * 
     * @param hungerLevel
     */
    public void setHungerLevel(int hungerLevel)
    {

        if (hungerLevel < 0)
        {
            this.hungerLevel = 0;
        }
        else if (hungerLevel > 10)
        {
            this.hungerLevel = 10;
        }
        else
        {
            this.hungerLevel = hungerLevel;
        }
        

    }

    /**
     * 
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * 
     */
    public void sleep()
    {
        setHungerLevel(10);
        System.out.println("sleeping ...");
    }

    /**
     * 
     */
    public void roam()
    {
        hungerLevel++;
        System.out.println("moving around ...");
    }

    /**
     * 
     */
    public abstract void eat(); 
  
    

    /**
     * 
     */
    public abstract void makeNoise(); 
    
}
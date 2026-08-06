package nature;
import java.util.ArrayList;


/**
 * 
 * @author Frederick Adongo
 * @version 6th February, 2024
 * 
 */
public class Habitat
{
    private String name;
    private double latitude;
    private double longitude;
    private ArrayList<Animal> animals;

    /**
     * three-arg constructor
     * @param name
     * @param lat
     * @param lon
     */
    public Habitat(String name, double lat, double lon)
    {
        this.name = name;
        this.latitude = lat;
        this.longitude = lon;

        animals = new ArrayList<Animal>();
    }

    /**
     * 
     * @return latitude
     */
    public double getLatitude()
    {
        return latitude;
    }

    /**
     * 
     * @return latitude
     */
    public double getLongitude()
    {
        return longitude;
    }

    /**
     * 
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * 
     * @param lat
     */
    public void setLatitude(double lat)
    {
        this.latitude = lat;
    }

    /**
     * 
     * @param lon
     */
    public void setLongitude(double lon)
    {
        this.longitude = lon;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    public int getNumOfAnimals()
    {
        return animals.size();
    }

    /**
     * 
     * @param animal
     */
    public void addAnimal(Animal animal)
    {
        animals.add(animal);
    }

    /**
     * 
     */
    public void testAnimals()
    {
        System.out.println(name);
        System.out.println(latitude);
        System.out.println(longitude);
        System.out.println(animals.size());
        
        for(Animal a : animals)
        {
            a.sleep();
            a.makeNoise();
            a.eat();
            a.roam();
            
            if(a instanceof Pet)
            {
                Pet pet = (Pet)a;
                pet.play();
                pet.beFriendly();
            }
        }
    }
}
package storage;
/**
 * 
 * @author Frederick Adongo
 * @version 20th February, 2025
 * 
 */
public class DoubleArraySeq implements Cloneable
{
    public static final int DEFAULT_CAPACITY = 10;
    private double[] data;
    private int manyItems;
    private int currentIndex;

    /**
     * 
     */
    public DoubleArraySeq()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 
     * @param initialCapacity
     */
    public DoubleArraySeq(int initialCapacity)
    {
        data = new double[initialCapacity];
        manyItems = 0;
        currentIndex = 0;
    }

    /**
     * 
     * @param element
     */
    public void addAfter(double element)
    {
        if (data.length == manyItems)
        {
            ensureCapacity(manyItems * 2 + 1);
        }

        if (isCurrent() == true)
        {
            for (int i = manyItems; i > (currentIndex + 1); i--)
            {
                data[i] = data[i - 1];
            }

            currentIndex++;
            data[currentIndex] = element;
            manyItems++;
        }
        else
        {
            currentIndex = manyItems;
            data[currentIndex] = element;
            manyItems++;
        }

    }

    /**
     * 
     * @param element
     */
    public void addBefore(double element)
    {
        if (data.length == manyItems)
        {
            ensureCapacity(manyItems * 2 + 1);
        }

        if (isCurrent() == true)
        {
            for (int i = manyItems; i > currentIndex; i--)
            {
                data[i] = data[i - 1];
            }
            data[currentIndex] = element;
            manyItems++;
        }
        else
        {
            for (int i = manyItems; i > 0; i--)
            {
                data[i] = data[i - 1];
            }
            currentIndex = 0;
            data[currentIndex] = element;
            manyItems++;
        }
    }

    /**
     * 
     * @param addend
     */
    public void addAll(DoubleArraySeq addend)
    {
        ensureCapacity(manyItems + addend.manyItems);

        System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems);
        manyItems += addend.manyItems;
    }

    /**
     * 
     */
    public void trimToSize()
    {
        double[] trim;
        if (data.length != manyItems)
        {
            trim = new double[manyItems];
            System.arraycopy(data, 0, trim, 0, manyItems);
            data = trim;
        }
    }

    /**
     * 
     * @param minimumCapacity
     */
    public void ensureCapacity(int minimumCapacity)
    {
        double[] largerArray;

        if (data.length < minimumCapacity)
        {
            largerArray = new double[minimumCapacity];
            System.arraycopy(data, 0, largerArray, 0, manyItems);
            data = largerArray;
        }
    }

    /**
     * 
     */
    public void start()
    {
        if (data[0] != 0)
        {
            currentIndex = 0;
        }
    }

    /**
     * 
     */
    public void advance()
    {
        // if current exists, move current forward
        if (isCurrent() == true)
        {
            currentIndex++;
        }
        else
        {
            throw new IllegalStateException("Current element does not exist.");
        }
    }

    /**
     * 
     * @return
     */
    public double getCurrent()
    {
        if (isCurrent() == true)
        {
            return data[currentIndex];
        }
        else
        {
            throw new IllegalStateException("Current element does not exist.");
        }
    }

    /**
     * 
     */
    public void removeCurrent()
    {
        if (isCurrent() == true)
        {
            for (int i = currentIndex; i < manyItems; i++)
            {
                data[i] = data[i + 1];
            } 
            manyItems--;
        }
        else
        {
            throw new IllegalStateException("Current element does not exist.");
        }
    }

    /**
     * 
     * @return
     */
    public boolean isCurrent()
    {
        //return data[currentIndex] == 0;

        if (data[currentIndex] == 0)
        {
            return false;
        }
        else if (data[currentIndex] == 0)
        {
            return true;
        }

        return true;
    }

    public int getCapacity()
    {
        return data.length;
    }

    /**
     * 
     * @return
     */
    public int size()
    {
        return manyItems;
    }

    /**
     * @return 
     */
    public DoubleArraySeq clone()
    {
        DoubleArraySeq answer;

        try 
        {
            answer = (DoubleArraySeq) super.clone();
        } 
        catch (CloneNotSupportedException e) 
        {
            throw new RuntimeException("This class does not implement Cloneable.");
        }
        answer.data = data.clone();
        return answer;
    }

    /**
     * @return 
     */
    public String toString()
    {
        String sequence = "<";

        for (int i = 0; i < manyItems; i++)
        {
            if (i == currentIndex)
            {
                sequence += "[";
            }

            sequence += data[i];

            if (i == currentIndex)
            {
                sequence += "]";
            }

            if (i != manyItems - 1)
            {
                sequence += ", ";
            }            
        }

        sequence += ">";
        return sequence;
    }

    /**
     * @param other
     * return 
     */
    public boolean equals(Object other)
    {
        boolean check = false;

        if (other instanceof DoubleArraySeq)
        {
            DoubleArraySeq obj = (DoubleArraySeq) other;
            check = obj.toString().equals(toString());
        }

        return check;
    }

    /**
     * 
     * @param s1
     * @param s2
     * @return
     */
    public static DoubleArraySeq concatenation(DoubleArraySeq s1, DoubleArraySeq s2)
    {
        DoubleArraySeq seq = new DoubleArraySeq(s1.getCapacity() + s2.getCapacity());

        System.arraycopy(s1.data, 0, seq.data, 0, s1.manyItems);
        System.arraycopy(s2.data, 0, seq.data, s1.manyItems, s2.manyItems);
        seq.manyItems = s1.manyItems + s2.manyItems;
        seq.currentIndex = seq.manyItems; // no current index

        return seq;
    }

}
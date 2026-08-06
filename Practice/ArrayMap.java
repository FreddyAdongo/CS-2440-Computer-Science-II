import java.util.Map;

public class ArrayMap<K, V> {
    private K[] keys;
    private V[] values;
    int size;

    public ArrayMap()
    {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    /**
     * Find key index and returns it
     * @param key
     * @return
     */
    private int keyIndex(K key)
    {
        for (int i = 0; i < size; i ++)
        {
            if (keys[i].equals(key))
            {
                return i;
            }
        }

        return -1;
    }

    public boolean containsKey(K key)
    {
        int index = keyIndex(key);
        return index > -1;
    }

    public void put(K key, V value)
    {
        int index = keyIndex(key);
        if (index == -1)
        {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        values[index] = value;
    }

    public V get(K key)
    {
        int index = keyIndex(key);
        return values[index];
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void putAll(Map<? extends K, ? extends V> pMap)
    {
        
    }

    public void clear()
    {
        int mapSize = values.length;
        values = (Entry<K,V>[] new Entry[mapSize];
    }
 
    // return keys in the map
    public List<K> keys()
    {
        List<K> keylist = new ArrayList<K>();
        for (int i = 0; i < size; i++)
        {
            keylist.add(Keys[i]);
        }

        return keylist;
    }
}
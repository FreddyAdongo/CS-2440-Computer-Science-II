import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.validation.Validator;
import org.w3c.dom.Node;

public class ListMap<K, V> implements Map<K, V>{
    List<Map.Node<K,V>> list;

    public ListMap()
    {
        list = new ArrayList<Map.Node<K, V>>();
    }

    public boolean containsKey(Object key)
    {
        for (Map.Node<K , V> node: list)
        {
            if (node.getKey().equals(key))
            {
                return true;
            }
        }

        return false;
    }

    public boolean containsValue(Object value)
    {
        if (value == null)
        {
            return false;
        }

        for (Map.Node<K, V> node: list)
        {
            if (node.getValue().equals(value))
            {
                return true;
            }
        }

        return false;
    }


    public boolean isEmpty()
    {
        return size() == 0;
    }

    public V get(Object key)
    {
        for (Map.Node<K, V> node : list)
        {
            if (node.getKey().equals(key))
            {
                return node.getValue();
            }
        }

        return null;
    }

    public V put(K key, V value)
    {
        if (containsKey(key))
        {
            for (Map.Node<K, V> node : list)
            {
                if (node.getKey().equals(key))
                {
                    V val = node.getValue();
                    node.setValue(value);
                    return val;
                }
            }
        }

        Map.Node<K< V> n = new Map.Node<K, V>(key, value);
        list.add(n);
        return null;
    }

    public V remove(Object key)
    {
        for (Map.Node<K, V> node : list)
        {
            if (node.getKey().equals(key))
            {
                V n = Node.getValue();
                list.remove(node);
                return n;
            }
        }

        return null;
    }

    public List<V> values()
    {
        List<V> ret = new ArrayList<V>();
        for (Map.Node<K, V> node : list)
        {
            ret.add(Node.getValue());
        }

        return ret;
    }

    public set<K> keySet()
    {
        Set<K> set = new ListSet<K>();
        for (Map.Node<K, V> node : list)
        {
            set.add(Node.getKey());
        }

        return set;
    }

}

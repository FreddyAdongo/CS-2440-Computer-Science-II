public class SortedLinkedList {
    private Node<T> head;
    private int manyNodes;

    public SortedLinkedList()
    {
        this.head = null;
        this.manyNodes = 0;
    }

    public void add(T entry)
    {
        Node<T> newNode = new Node<T>(entry);

        if (head == null || entry.compareTo(head.getData()) <= 0)
        {
            newNode.setLink(head);
            head = newNode;
        }
        else
        {
            Node<T> prev = getPrevious(entry);
            newNode.setLink(prev.getLink());
            prev.setLink(newNode);
        }

        manyNodes++;
    }

    public T remove(int position)
    {
        if (position < 0 || position >= manyNodes)
        {
            return null;
        }
        else if (position == 0)
        {
            T a = head.getData();
            head = head.getLink();
            manyNodes--;
            return a;
        }

        return null;
    }

    public T getEntry(int position)
    {
        if (position < 0 || position >= manyNodes)
        {
            return null;
        }

        Node<T> current = head;
        int index = 0;

        while(index < position)
        {
            current = current.getLink();
            index++;
        }

        return current.getData();
    }


}

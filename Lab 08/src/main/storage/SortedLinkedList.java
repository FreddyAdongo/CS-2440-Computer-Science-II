package storage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SortedLinkedList.
 * 
 * @author Frederick Adongo
 * @version 20th March, 2025
 * 
 */
public class SortedLinkedList<T extends Comparable<? super T>> implements Iterable<T>
{
    // reference to the first item in the list
    private Node<T> head;
    // number of elements in the list
    private int length;

    /**
     * Task: Default constructor for the SortedLinkedList.
     */
    public SortedLinkedList()
    {
        head = null;
        length = 0;
    }

    /**
     * Task: Adds a new entry in its sorted position in the list. Entries
     * currently in the list are unaffected. The lists size is increased by 1.
     * 
     * @param newEntry
     *            the object to be added as a new entry
     * @return true if the addition is successful, or false if the list is full
     */
    public void add(T entry)
    {

        Node<T> newNode = new Node<>(entry);
        //Node<T> addHere = getPrevious(entry);

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

        length++;
        //return true;
    }

    /**
     * Task: Removes the entry at the given index in the list. Entries
     * originally at positions higher than the given position are at the next
     * lower position within the list, and the lists size is decreased by 1.
     * 
     * @param position
     *            an integer that indicates the position of the entry to be
     *            removed
     * @return a the node's data, or returns a sentinel value if either the list is
     *         empty, givenPosition < 0, or givenPosition > getLength()-1
	 *         (hint: when making generic, return the data or null)
     */
    public T remove(int position)
    {
        if (position < 0 || position > length - 1)
        {
            return null;
        }

        Node<T> remove;

        if (position == 0)
        {
            remove = head;
            head = head.getLink();
        }
        else
        {
            Node<T> previous = head;
            for (int i = 0; i < position - 1; i++)
            {
                previous = previous.getLink();
            }

            remove = previous.getLink();
            previous.setLink(remove.getLink());
        }

        length--;
        return remove.getData();
    }

    /**
     * Task: Removes all entries from the list. The length of the sequence
     * should be zero, and there will be no currentItem
     */
    public void clear()
    {
        head = null;
        length = 0;
    }

    /**
     * Task: Retrieves the entry at a given position in the list.
     * 
     * @param givenPosition
     *            an integer that indicates the position of the desired entry
     * @return a the node's data, or returns a sentinel value if either the list is
     *         empty, givenPosition < 0, or givenPosition > getLength()-1
	 *         (hint: when making generic, return the data or null)
     */
    public T getEntry(int position)
    {
        if (position < 0 || position >= length)
        {
            return null;
        }
        Node<T> traverse = head;
        for (int i = 0; i < position; i++)
        {
            traverse = traverse.getLink();
        }
        return traverse.getData();
    }

    /**
     * Task: Finds the index of the first occurrence of the entry in the list.
     * 
     * @param anEntry
     *            The object to find in the list.
     * @return the index of the first occurrence of this element, throws
     *         IllegalArgumentException if the element is not in the list
     */
    public int getPosition(T entry)
    {
        int pos = 0;
        Node<T> node = head;

        while (node != null && entry.compareTo(node.getData()) > 0)
        {
            node = node.getLink();
            pos++;
        }

        if (node == null || !entry.equals(node.getData())) 
        {
            throw new IllegalArgumentException("Element not in list");    
        }

        return pos;
    }

    /**
     * Task: Sees whether the list contains a given entry.
     * 
     * @param anEntry
     *            the object that is the desired entry
     * @return true if the list contains anEntry, or false if not
     */
    public boolean contains(T entry)
    {
        Node<T> traverse = head;
        while(traverse != null)
        {
            if (entry.equals(traverse.getData()))
            {
                return true;
            }

            traverse = traverse.getLink();
        }
        return false;
    }

    /**
     * Task: Gets the length of the list.
     * 
     * @return the integer number of entries currently in the list
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Task: Sees whether the list is empty.
     * 
     * @return true if the list is empty, or false if not
     */
    public boolean isEmpty()
    {
        return length == 0;
    }

    /**
     * Task: Displays all entries that are in the list, one per line, in the
     * order in which they occur in the list.
     */
    public void display()
    {        
        Node<T> current = head;

        while(current != null) 
        {
            System.out.print(current.getData() + " ");
            current = current.getLink();
        }
        System.out.print("\n");

    }

    public Iterator<T> iterator()
    {
        return new SLLIterator(head);
    }

    /**
     * 
     * @param entry
     *            an entry in the sequence
     * @return a reference to the node before where the entry would fit in the
     *         sequence or null if the entry would be first
     */
    private Node<T> getPrevious(T entry)
    {
        Node<T> previous = null;
        Node<T> traverse = head;
        while (traverse != null)
        {
            if (entry.compareTo(traverse.getData()) > 0)
            {
                previous = traverse;
                traverse = traverse.getLink();
            }
            else
            {
                return previous;
            }
        }
        return previous;
    }

    private class SLLIterator implements Iterator<T>
    {
       private boolean calledNext;
       private Node<T> prevNode;
       private Node<T> currNode;
       private Node<T> nextNode; 

       public SLLIterator(Node<T> firstNode)
       {
            //this.prevNode = null;
            //this.currNode = firstNode;
            this.nextNode = firstNode;
       }

       public boolean hasNext()
       {
            //return currNode != null;
            return nextNode != null;
       }

       public T next()
       {
            if (!hasNext())
            {
                throw new NoSuchElementException("No more elements.");
            }

            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.getLink();
            calledNext = true;

            return currNode.getData();

       }

       public void remove()
       {

            if (!calledNext)
            {
                throw new IllegalStateException("Remove called before next.");
            }
            if (prevNode == null)
            {
                head = nextNode;
            }
            else
            {
                prevNode.setLink(nextNode);
                currNode = prevNode;
            }
            
            length--;
            calledNext = false;

       }    
    }

} 




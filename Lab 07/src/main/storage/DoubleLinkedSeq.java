package storage;

/**
 * 
 * @author Frederick Adongo
 * @version 6th March, 2025
 * 
 */
public class DoubleLinkedSeq implements Cloneable {
    private int manyNodes;
    private DoubleNode tail;
    private DoubleNode head;
    private DoubleNode precursor;
    private DoubleNode cursor;

    /**
     * No-arg constructor
     */
    public DoubleLinkedSeq()
    {
        manyNodes = 0;
        tail = null;
        head = null;
        precursor = null;
        cursor = null;
    }

    /**
     * 
     * @return int
     */
    public int size()
    {
        return manyNodes;
    }

    /**
     * 
     * @param data
     */
    public void addAfter(double data)
    {
        // Add new element to sequence
        if (manyNodes == 0)
        {
            head = new DoubleNode(data);
            tail = head;
            cursor = head;
        }
        else if (manyNodes == 1)
        {
            DoubleNode n = new DoubleNode(data);
            head.setLink(n);
            tail = n;
            cursor = tail;
            precursor = head;
        }
        else if (cursor == head)
        {
            DoubleNode n = new DoubleNode(data, cursor.getLink());
            head.setLink(n);
            cursor = cursor.getLink();
            precursor = head;
        }
        else if (!isCurrent())
        {
            DoubleNode n = new DoubleNode(data);
            tail.setLink(n);
            precursor = tail;
            tail = tail.getLink();
            cursor = tail;
        }
        else if (cursor != head && precursor != null)
        {
            DoubleNode n = new DoubleNode(data, cursor.getLink());
            cursor.setLink(n);

            if (cursor == tail)
            {
                tail = tail.getLink();
            }
            cursor = cursor.getLink();
            precursor = precursor.getLink();
        }

        manyNodes++;
    }

    /**
     * 
     * @param data
     */
    public void addBefore(double data)
    {
        // If cursor exists, new element is after cursor
        if (head == null && tail == null)
        {
            head = new DoubleNode(data);
            tail = head;
            cursor = head;
        }
       else if (cursor == null)
       {
            head = new DoubleNode(data, head);
            cursor = head;
       }
       else if (precursor == null)
       {
            head = new DoubleNode(data, head);
            cursor = head;
       }
       else if (cursor != null && precursor != null)
       {
            DoubleNode n = new DoubleNode(data, cursor);
            precursor.setLink(n);
            cursor = n;
       }

        manyNodes++;

    }

    /**
     * 
     * @param addend
     */
    public void addAll(DoubleLinkedSeq addend) throws NullPointerException
    {
        // Take another sequence and places it at the end of current sequence
        if (addend == null)
        {
            throw new NullPointerException("addend is null.");
        }
        else
        {
            DoubleLinkedSeq n = addend.clone();
            tail.setLink(n.head);
            tail = n.tail;
            manyNodes += n.size();
        }
    }

    /**
     * 
     * @return
     */
    public boolean isCurrent()
    {
        // return true if cursor exists else false
        return cursor != null;
    }

    /**
     * 
     */
    public void start()
    {
        if (head != null)
        {
            cursor = head;
        }
        else
        {
            cursor = null;
        }

        precursor = null;
    }

    /**
     * 
     */
    public void advance() throws IllegalStateException
    {
        if (isCurrent())
        {
            if (cursor == tail)
            {
                cursor = null;
                precursor = null;
            }
            else if (cursor != tail && cursor != head)
            {
                cursor = cursor.getLink();
                precursor = precursor.getLink();
            }
            else if (cursor == head)
            {
                cursor = cursor.getLink();
                precursor = head;
            }
        }
        else
        {
            throw new IllegalStateException("cursor element does not exist");
        }
    }

    /**
     * 
     * @return
     */
    public double getCurrent() throws IllegalStateException
    {
        if (isCurrent())
        {
            return cursor.getData();
        }
        else 
        {
            throw new IllegalStateException("cursor element does not exist.");
        }
    }

    /**
     * 
     */
    public void removeCurrent() throws IllegalStateException
    {
        if (isCurrent())
        {
            if (head == tail)
            {
                head = null;
                tail = null;
                cursor = null;
                manyNodes--;
            }
            else if (cursor == head && precursor == null)
            {
                head = head.getLink();
                cursor = head;
                manyNodes--;
            }
            else if (cursor != tail && precursor != null)
            {
                cursor = cursor.getLink();
                precursor.setLink(cursor);
                manyNodes--;
            }
            else if (cursor == tail && precursor != null)
            {
                cursor = null;
                precursor.setLink(null);
                precursor = null;
                manyNodes--;
            }
        }
        else
        {
            throw new IllegalStateException("cursor element does not exist.");
        }
    }

    /**
     * 
     */
    public DoubleLinkedSeq clone() throws RuntimeException
    {
        DoubleLinkedSeq copy;
        try
        {
            copy = (DoubleLinkedSeq) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException("Class does not implement Cloneable.");
        }

        if (cursor == null)
        {
            DoubleNode[] newSeq = DoubleNode.listCopyWithTail(head);
            copy.head = newSeq[0];
            copy.tail = newSeq[1];
        }
        else if (cursor == head)
        {
            DoubleNode[] newSeq = DoubleNode.listCopyWithTail(head);
            copy.head = newSeq[0];
            copy.tail = newSeq[1];
            copy.cursor = copy.head;
            copy.precursor = null;
        }
        else if (cursor != null && precursor != null)
        {
            DoubleNode[] newSeq2 = DoubleNode.listPart(head, precursor);
            copy.head = newSeq2[0];
            copy.precursor = newSeq2[1];

            DoubleNode[] newSeq3 = DoubleNode.listPart(cursor, tail);
            copy.cursor = newSeq3[0];
            copy.tail = newSeq3[1];
            copy.precursor.setLink(copy.cursor);
        }

        return copy;
    }

    /**
     * @return String
     */
    public String toString()
    {
        String sequence = "";
        if (isCurrent() == false)
        {
            if (head == null)
            {
                sequence += "<>";   
            }
            else if (manyNodes == 1)
            {
                sequence += "<" + head.getData() + ">";
            }
            else if (manyNodes > 1)
            {
                sequence += "<";

                for(DoubleNode n = head; n != null; n = n.getLink())
                {
                    sequence += "" + n.getData();

                    if (n.getLink() != null)
                    {
                        sequence += ", ";
                    }
                }

                sequence += ">";
            }
        }
        else 
        {
            if (manyNodes == 1)
            {
                sequence += "<[" + head.getData() + "]>";
            }
            else if (manyNodes > 1)
            {
                sequence += "<";

                for(DoubleNode n = head; n != null; n = n.getLink())
                {
                   if (n == cursor)
                   {
                        sequence += "[" + n.getData() + "]";
                   }
                   else
                   {
                        sequence += "" + n.getData();
                   }

                   if (n.getLink() != null)
                   {
                        sequence += ", ";
                   }
                }

                sequence += ">";
            }

            //return sequence;
        }
        
        return sequence;
    }

    /**
     * @param other
     */
    public boolean equals(Object other)
    {
        boolean check = true;
        DoubleLinkedSeq seq = (DoubleLinkedSeq) other;

        if (manyNodes == seq.manyNodes)
        {
            DoubleNode s1 = head;
            DoubleNode s2 = seq.head;

            while (s1 != null)
            {
                if (s1.getData() != s2.getData())
                {
                    check = false;
                    break;
                }
                if (s1 == cursor && s2 != seq.cursor)
                {
                    check = false;
                    break;
                }
                if (s2 == seq.cursor && s1 != cursor)
                {
                    check = false;
                    break;
                }

                s1 = s1.getLink();
                s2 = s2.getLink();
            }
        }
        else 
        {
            check = false;
        }

        return check;
    }

    public static DoubleLinkedSeq concatenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2)
    {

        DoubleLinkedSeq seq = new DoubleLinkedSeq();

        DoubleNode seq1 = s1.head;

        while (seq1 != null)
        {
            seq.addAfter(seq1.getData());
            seq1 = seq1.getLink();
        }

        DoubleNode seq2 = s2.head;

        while (seq2 != null)
        {
            seq.addAfter(seq2.getData());
            seq2 = seq2.getLink();
        }

        seq.cursor = null;

        return seq;
    }
}

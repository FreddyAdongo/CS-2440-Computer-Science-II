package library;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import storage.SortedLinkedList;

/**
 * 
 * @author Frederick Adongo
 * @version 20th March, 2025
 * 
 */
public class BookReader 
{
    private Scanner fileIn;
    private SortedLinkedList<Book> books;

    public BookReader(String filename)
    {
        books = new SortedLinkedList<>();

        try
        {
            fileIn = new Scanner(new FileReader(filename));
            setFileIn(fileIn);
        
        }
        catch (IOException e)
        {
            System.out.println("Unable to open file");
        }
        

        // read the data
        readLines();

        // close the input file
        fileIn.close();

    }

    public void setFileIn(Scanner fileIn)
    {
        this.fileIn = fileIn;
    }

    public void readLines()
    {
        Book book;
        String[] line;
        String title;
        int numOfPages;
        String author;

        while(fileIn.hasNextLine())
        {
            line = fileIn.nextLine().split(",");
            author = line[0];
            title = (line[1]);
            numOfPages = Integer.parseInt(line[2]);
            book = new Book(author, title, numOfPages);
            books.add(book);

        }

        fileIn.close();
    }

    public SortedLinkedList<Book> getBooks()
    {
        return books;
    }

    public void printMoreThan300()
    {
        Iterator<Book> itr = books.iterator();
        
        while(itr.hasNext())
        {

            Book b = itr.next();

            if (b.getNumPages() > 300)
            {
                System.out.println(b.toString());
            }
        }
    }

    public double averagePages()
    {

        int totalPages = 0;
        int numOfBooks = 0;

        for (Book b : books)
        {
            totalPages += b.getNumPages();
            numOfBooks++;
        }

        //double avgNumPages = ;
        
        return (double) totalPages / numOfBooks; 
    }

    public void removeLessThan200()
    {

        Iterator<Book> itr = books.iterator();

        while(itr.hasNext())
        {
            Book b = itr.next();

            if (b.getNumPages() < 200)
            {
                itr.remove();
            }
        }

    }
}

package library;

/**
 * 
 * @author Frederick Adongo
 * @version 20th March, 2025
 * 
 */
public class Book implements Comparable<Book> 
{
    private String author;
    private String title;
    private int numPages;

    public Book(String author, String title, int numPages)
    {
        this.author = author;
        this.title = title;
        this.numPages = numPages;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getTitle()
    {
        return title;
    }

    public int getNumPages()
    {
        return numPages;
    }

    public boolean equals(Object other)
    {
        if (this == other) 
        {
            return true;
        }
        if (other == null || getClass() != other.getClass())
        {
            return false;
        }

        Book book = (Book) other;

        return author.equals(book.author) && title.equals(book.title);
    }

    public int compareTo(Book book)
    {
        int compare = author.compareTo(book.author);
        if (compare == 0) 
        {
            return title.compareTo(book.title);
        }
        return compare;
    }

    public String toString()
    {
        return getAuthor() + ", " + getTitle() + ", " + getNumPages();
    }
}
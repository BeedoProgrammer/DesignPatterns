package Iterator;

import java.util.*;

public class Book {
    private String title;
    private String author;
    private String genre;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }
}

class BookIterator implements Iterator<Book>{
    private ArrayList<Book> books;
    private int index = 0;

    public BookIterator(ArrayList<Book> books) {
        this.books = books;
    }
    
    @Override
    public boolean hasNext(){
        if(index < books.size())
            return true;
        return false;
    }
    
    @Override
    public Book getNext(){
        return books.get(index++);
    } 
}

class run{
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("joe", "beedo", "abdo"));
        books.add(new Book("Bloodborne", "beedo", "abdo"));
        books.add(new Book("WHYYY", "beedo", "abdo"));
        
        BookIterator bookIterator = new BookIterator(books);
        while (bookIterator.hasNext())
            System.out.println(bookIterator.getNext().getTitle());
    }
}

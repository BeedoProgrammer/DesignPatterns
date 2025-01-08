package ModelViewController;

public class Book { //Model
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author, boolean available) {
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void changeAvailability() {
        available = !available;
    }
}

class BookView{ //View
    private Book book;

    public void setBook(Book book) {
        this.book = book;
    }
    
    public void display(){
        if(book != null){
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            if(book.isAvailable())
                System.out.println("Book is available");
            else
                System.out.println("Book is not available");
        }
        else
            System.out.println("No book to display");
    }
}

class BookController{ //Controller
    private Book bookModel;
    private BookView bookView = new BookView();
    
    public void borrowBook(Book book){
        bookModel = book;
        if(bookModel.isAvailable()){
            bookModel.changeAvailability();
            System.out.println("Book " + bookModel.getTitle() + " is borrowed");
        }
        else
            System.out.println("Book " + bookModel.getTitle() + " is unavailable");
        
        System.out.println("");
        bookView.setBook(book);
        bookView.display();
    }
    
    public void returnBook(Book book){
        bookModel = book;
        if(!bookModel.isAvailable()){
            System.out.println("Book " + bookModel.getTitle() + " is returned");
        }
            bookModel.changeAvailability();
        
        System.out.println("");
        bookView.setBook(book);
        bookView.display();
    }
}

class main {
    public static void main(String[] args) {
        BookController bookController = new BookController();
        
        Book book1 = new Book("Joe", "Little", true);
        Book book2 = new Book("Beedo", "Hoe", true);
        
        bookController.borrowBook(book2);
        System.out.println("");
        bookController.borrowBook(book2);
        System.out.println("");
        bookController.borrowBook(book1);
        System.out.println("");
        bookController.returnBook(book1);
        System.out.println("");
        bookController.borrowBook(book1);
    }
}
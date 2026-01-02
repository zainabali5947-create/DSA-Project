package dsalabprjct;

public class Book extends LibraryItem {
    private String author;

    public Book(String title, String author, String isbn, int year) {
        super(title, isbn, year);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + getIsbn() + '\'' +
                ", year=" + getYear() +
                '}';
    }
}


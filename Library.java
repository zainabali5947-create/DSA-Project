package dsalabprjct;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        mergeSort(0, books.size() - 1); // keep list sorted by ISBN
    }

    public void editBook(String isbn, Book updatedBook) {
        int index = binarySearch(isbn);
        if (index != -1) {
            books.set(index, updatedBook);
            mergeSort(0, books.size() - 1);
        }
    }

    public void deleteBook(String isbn) {
        int index = binarySearch(isbn);
        if (index != -1) {
            books.remove(index);
        }
    }

    // 🔍 Binary Search (ISBN)
    public Book searchBook(String isbn) {
        int index = binarySearch(isbn);
        return (index != -1) ? books.get(index) : null;
    }

    private int binarySearch(String isbn) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = books.get(mid).getIsbn().compareTo(isbn);

            if (compare == 0)
                return mid;
            else if (compare < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // 🧩 Merge Sort (by ISBN)
    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        List<Book> temp = new ArrayList<>();
        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (books.get(i).getIsbn().compareTo(books.get(j).getIsbn()) <= 0) {
                temp.add(books.get(i++));
            } else {
                temp.add(books.get(j++));
            }
        }

        while (i <= mid) temp.add(books.get(i++));
        while (j <= right) temp.add(books.get(j++));

        for (int k = 0; k < temp.size(); k++) {
            books.set(left + k, temp.get(k));
        }
    }

    public void displayAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}


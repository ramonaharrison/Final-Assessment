package nyc.c4q;

/**
 * Created by Ramona Harrison
 * on 9/1/15.
 */
import java.util.ArrayList;

public interface BookListener {

    public void addBook(Book book);

    public ArrayList<Book> getAllBooks();

    public int getBookCount();
}
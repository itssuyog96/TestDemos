import java.util.List;

public interface BookDAO {
	void add(Book b);

	List<Book> searchByTitle(String title);

	List<Book> searchByAuthor(String author);

	List<Book> belowRs(float amt);
}

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookDAOStream implements BookDAO {

	private List<Book> bookList = new LinkedList<>();

	@Override
	public void add(Book b) {
		bookList.add(b);
	}

	@Override
	public List<Book> searchByTitle(String title) {
		return bookList.stream().filter((x) -> x.getTitle().equalsIgnoreCase(title.trim()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Book> searchByAuthor(String author) {
		return bookList.stream().filter((x) -> x.getAuthor().equalsIgnoreCase(author.trim()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Book> belowRs(float amt) {
		return bookList.stream().filter((x) -> x.getPrice() < amt).collect(Collectors.toList());
	}

	public List<Book> search(Predicate<Book> predicate) {
		return bookList.stream().filter(predicate).collect(Collectors.toList());
	}

	public Optional<Book> search() {
		return bookList.stream().findFirst();
	}

}

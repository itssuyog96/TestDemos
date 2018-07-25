import java.util.LinkedList;
import java.util.List;

public class BookDAOImpl implements BookDAO {

	List<Book> booksList;

	public BookDAOImpl(List<Book> booksList) {
		super();
		this.booksList = booksList;
	}

	@Override
	public void add(Book b) {
		if (b != null)
			this.booksList.add(b);
	}

	@Override
	public List<Book> searchByTitle(String title) {
		List<Book> temp = new LinkedList<>();
		for (Book b : booksList) {
			if (b != null && b.getTitle() == title) {
				temp.add(b);
			}
		}

		return temp;
	}

	@Override
	public List<Book> searchByAuthor(String author) {
		List<Book> temp = new LinkedList<>();
		for (Book b : booksList) {
			if (b != null && b.getAuthor().equalsIgnoreCase(author)) {
				temp.add(b);
			}
		}
		return temp;
	}

	@Override
	public List<Book> belowRs(float amt) {
		List<Book> temp = new LinkedList<>();
		for (Book b : booksList) {
			if (b != null && b.getPrice() < amt) {
				temp.add(b);
			}
		}
		return temp;
	}

}

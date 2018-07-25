
public class Book {
	private String title;
	private String author;
	private String category;
	private float price;

	public Book(String title, String author, String category, float price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getCategory() {
		return category;
	}

	public float getPrice() {
		return price;
	}

}

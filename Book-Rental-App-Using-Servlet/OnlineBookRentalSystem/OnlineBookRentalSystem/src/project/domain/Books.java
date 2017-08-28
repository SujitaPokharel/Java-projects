package project.domain;

public class Books {
	private Author author;
	private String bookName;
	private int bookId;
	private int bookCount;

	public Author getAuthor() {
		return author;
	}

	public String getBookName() {
		return bookName;
	}

	public int getBookId() {
		return bookId;
	}

	public Books(String bookName) {

		this.bookName = bookName;
	}

	public String getName() {
		return bookName;
	}

	public boolean isAvailable() {
		if (bookCount > 0)
			return true;
		return false;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Books) {
			Books book2 = (Books) obj;
			if (getName().equals(book2.getName()))
				return true;
		}
		return false;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}

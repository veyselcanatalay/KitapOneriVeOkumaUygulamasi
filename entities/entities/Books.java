package entities;

import java.sql.Date;

public class Books {
	private String isbn;
	private String book_tittle;
	private String book_author;
	private String year_of_publication;
	private String publisher;
	private String image_url_s;
	private String image_url_m;
	private String image_url_l;
	private Date datetime;

	public Books() {
		// TODO Auto-generated constructor stub
	}

	public Books(String isbn, String book_tittle, String book_author, String year_of_publication, String publisher,
			String image_url_s, String image_url_m, String image_url_l, Date datetime) {
		super();
		this.isbn = isbn;
		this.book_tittle = book_tittle;
		this.book_author = book_author;
		this.year_of_publication = year_of_publication;
		this.publisher = publisher;
		this.image_url_s = image_url_s;
		this.image_url_m = image_url_m;
		this.image_url_l = image_url_l;
		this.datetime = datetime;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBook_tittle() {
		return book_tittle;
	}

	public void setBook_tittle(String book_tittle) {
		this.book_tittle = book_tittle;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getYear_of_publication() {
		return year_of_publication;
	}

	public void setYear_of_publication(String year_of_publication) {
		this.year_of_publication = year_of_publication;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getImage_url_s() {
		return image_url_s;
	}

	public void setImage_url_s(String image_url_s) {
		this.image_url_s = image_url_s;
	}

	public String getImage_url_m() {
		return image_url_m;
	}

	public void setImage_url_m(String image_url_m) {
		this.image_url_m = image_url_m;
	}

	public String getImage_url_l() {
		return image_url_l;
	}

	public void setImage_url_l(String image_url_l) {
		this.image_url_l = image_url_l;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}

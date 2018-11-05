package interfaces;

import java.util.ArrayList;

import entities.BookRatings;

public interface IBookRatings {
	boolean BookRatingsEkleme(BookRatings entity);

	ArrayList<BookRatings> PopularBooks();

	ArrayList<BookRatings> TopRatedBooks();

}

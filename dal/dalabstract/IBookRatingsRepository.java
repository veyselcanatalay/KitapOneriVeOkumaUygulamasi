package dalabstract;

import java.util.ArrayList;

import entities.BookRatings;

public interface IBookRatingsRepository {
	boolean BookRatingsEkleme(BookRatings entity);
	
	ArrayList<BookRatings> PopularBooks();
	
	ArrayList<BookRatings> TopRatedBooks();

}

package dalabstract;

import java.util.ArrayList;

import entities.Books;

public interface IBooksRepository {
	boolean KitapEkleme(Books entity);

	boolean KitapSilme(String isbn);

	ArrayList<Books> KitapListele();
}

package interfaces;

import java.awt.print.Book;
import java.util.ArrayList;

import entities.Books;

public interface IBooks {
	boolean KitapEkleme(Books entity);

	boolean KitapSilme(String isbn);

	ArrayList<Books> KitapListele();

}

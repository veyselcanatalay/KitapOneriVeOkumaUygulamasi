package bll;

import java.util.ArrayList;

import dalabstract.IBooksRepository;
import entities.Books;
import interfaces.IBooks;

public class BooksManager implements IBooks {
	
	IBooksRepository BookRepository;

	public BooksManager(IBooksRepository BookRepository) {
		super();
		this.BookRepository = BookRepository;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean KitapEkleme(Books entity) {
		// TODO Auto-generated method stub
		return BookRepository.KitapEkleme(entity);
	}

	@Override
	public boolean KitapSilme(String isbn) {
		// TODO Auto-generated method stub
		return BookRepository.KitapSilme(isbn);
	}

	@Override
	public ArrayList<Books> KitapListele() {
		// TODO Auto-generated method stub
		return BookRepository.KitapListele();
	}

}

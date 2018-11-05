package dalconcrete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;

import java.sql.Statement;

import dalabstract.IBooksRepository;
import entities.Books;

public class BooksRepositoryMysql implements IBooksRepository {
	Connection baglanti;

	public BooksRepositoryMysql() {
		// TODO Auto-generated constructor stub
		this.baglanti = new MySqlBaglanti().Baglanti();

	}

	@Override
	public boolean KitapEkleme(Books entity) {
		// TODO Auto-generated method stub
		try {
			String KitapEkleme = "insert into yazilimlab.bx_books"
					+ "(isbn,book_title,book_author,year_of_publication,publisher,image_url_s,image_url_m,image_url_l)"
					+ "values(?,?,?,?,?,?,?,?)";
			PreparedStatement psmt = baglanti.prepareStatement(KitapEkleme);
			psmt.setString(1, entity.getIsbn());
			psmt.setString(2, entity.getBook_tittle());
			psmt.setString(3, entity.getBook_author());
			psmt.setString(4, entity.getYear_of_publication());
			psmt.setString(5, entity.getPublisher());
			psmt.setString(6, entity.getImage_url_s());
			psmt.setString(7, entity.getImage_url_m());
			psmt.setString(8, entity.getImage_url_l());

			return psmt.executeUpdate() > 0;

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Hata:" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean KitapSilme(String isbn) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from bx_books where isbn=" + isbn + "";
			Statement stmp = baglanti.createStatement();
			return stmp.executeUpdate(sql) > 0;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public ArrayList<Books> KitapListele() {
		// TODO Auto-generated method stub
		ArrayList<Books> BooksList = new ArrayList<>();
		try {
			String Listele = "select * from bx_books";
			Statement stmp = baglanti.createStatement();
			ResultSet rs = stmp.executeQuery(Listele);

			while (rs.next()) {
				Books b = new Books();
				b.setIsbn(rs.getString(1));
				b.setBook_tittle(rs.getString(2));
				b.setBook_author(rs.getString(3));
				b.setYear_of_publication(rs.getString(4));
				b.setPublisher(rs.getString(5));
				b.setImage_url_s(rs.getString(6));
				b.setImage_url_m(rs.getString(7));
				b.setImage_url_l(rs.getString(8));

				BooksList.add(b);

			}

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Listeleme hatasi! Hata:" + e);
		}
		return BooksList;
	}

}

package dalconcrete;

import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.xml.crypto.KeySelector.Purpose;

import dalabstract.IBookRatingsRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.BookRatings;
import interfaces.IBookRatings;

public class BookRatingsRepositoryMySql implements IBookRatingsRepository {
	Connection baglanti;

	public BookRatingsRepositoryMySql() {
		// TODO Auto-generated constructor stub
		this.baglanti = new MySqlBaglanti().Baglanti();
	}

	@Override
	public boolean BookRatingsEkleme(BookRatings entity) {
		// TODO Auto-generated method stub
		try {
			String BookRatingsEkleme = "insert into bx_book_ratings" + "user_id,isbn,book_rating" + "values(?,?,?)";
			PreparedStatement psmt = baglanti.prepareStatement(BookRatingsEkleme);

			psmt.setString(1, entity.getUser_id());
			psmt.setString(2, entity.getIsbn());
			psmt.setString(3, entity.getBook_rating());

			return psmt.executeUpdate() > 0;

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Hata:" + e.getMessage());
			return false;
		}
	}

	@Override
	public ArrayList<BookRatings> PopularBooks() {
		// TODO Auto-generated method stub
		ArrayList<BookRatings> Popular = new ArrayList<>();
		try {
			String PopularBooks = "SELECT isbn,count(*) FROM bx_book_ratings "
					+ "GROUP BY isbn ORDER BY count(*) DESC LIMIT 10";
			Statement stmp = baglanti.createStatement();
			ResultSet rs = stmp.executeQuery(PopularBooks);

			while (rs.next()) {
				BookRatings br = new BookRatings();
				br.setIsbn(rs.getString(1));
				br.setCount(rs.getInt(2));

				Popular.add(br);

			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Listeleme hatasi! Hata:" + e);
		}
		return Popular;
	}

	@Override
	public ArrayList<BookRatings> TopRatedBooks() {
		// TODO Auto-generated method stub
		// select isbn,AVG(book_rating) from bx_book_ratings GROUP by isbn order by
		// AVG(book_rating) desc
		ArrayList<BookRatings> Ratings = new ArrayList<>();
		try {
			String TopRatedBooks = "SELECT isbn,avg(book_rating),count(*) FROM bx_book_ratings "
					+ "GROUP BY isbn ORDER BY avg(book_rating) DESC, count(*) DESC LIMIT 10";
			Statement stmp = baglanti.createStatement();
			ResultSet rs = stmp.executeQuery(TopRatedBooks);

			while (rs.next()) {
				BookRatings br = new BookRatings();
				br.setIsbn(rs.getString(1));
				br.setBook_rating(rs.getString(2));

				Ratings.add(br);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Listeleme hatasi! Hata:" + e);
		}

		return Ratings;
	}

}

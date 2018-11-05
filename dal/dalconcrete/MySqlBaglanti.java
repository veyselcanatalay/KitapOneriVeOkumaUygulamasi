package dalconcrete;

import java.sql.*;

import javax.swing.JOptionPane;

public class MySqlBaglanti {
	public Connection Baglanti() {
		Connection baglanti = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String baglantiURL = "jdbc:mysql://localhost:3306/yazilimlab?user=root&password=17051905";
			baglanti = DriverManager.getConnection(baglantiURL);

			// JOptionPane.showMessageDialog(null, "Baglanti basarilidir.");

		} catch (Exception e) {
			// TODO: handle exception
			// JOptionPane.showMessageDialog(null, "Baglanti basarisizdir! Hata:" + e);
		}
		return baglanti;

	}

}

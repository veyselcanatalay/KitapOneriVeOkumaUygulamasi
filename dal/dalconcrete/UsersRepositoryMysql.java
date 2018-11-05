package dalconcrete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;

import java.sql.Statement;

import dalabstract.IUsersRepository;
import entities.Users;

public class UsersRepositoryMysql implements IUsersRepository {
	Connection baglanti;

	public UsersRepositoryMysql() {
		// TODO Auto-generated constructor stub
		this.baglanti = new MySqlBaglanti().Baglanti();
	}

	@Override
	public boolean UyeSilme(int user_id) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from bx_users where user_id=" + user_id + "";
			Statement stmp = baglanti.createStatement();
			return stmp.executeUpdate(sql) > 0;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean UyeOlma(Users entity) {
		try {
			String UyeEkleme = "insert into yazilimlab.bx_users" + "(user_id,location,age,password)" + "values(?,?,?,?)";
			PreparedStatement psmt = baglanti.prepareStatement(UyeEkleme);
			psmt.setString(1, entity.getUser_id());
			psmt.setString(2, entity.getLocation());
			psmt.setString(3, entity.getAge());
			psmt.setString(4, entity.getPassword());
			return psmt.executeUpdate() > 0;

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Hata:" + e.getMessage());
			return false;
		}

	}

	@Override
	public ArrayList<Users> UyeListeleme() {
		ArrayList<Users> UsersList = new ArrayList<>();

		try {
			String KullaniciListele = "select * from bx_users";
			Statement stmp = baglanti.createStatement();
			ResultSet rs = stmp.executeQuery(KullaniciListele);

			while (rs.next()) {
				Users u = new Users();
				u.setUser_id(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setAge(rs.getString(3));
				u.setLocation(rs.getString(4));

				UsersList.add(u);
			}

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Listeleme hatasi! Hata:" + e);
		}
		return UsersList;
	}

	@Override
	public int UserID() {
		// TODO Auto-generated method stub
		int a;
		try {
			String sql="select max(user_id)+1 from bx_users";
			Statement stmp = baglanti.createStatement();
			ResultSet rs = stmp.executeQuery(sql);
			
			while (rs.next()) {
				a = rs.getInt("max(user_id)+1");
				//System.out.println(a);
				return a;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 0;
		
	}


}

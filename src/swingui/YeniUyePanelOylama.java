package swingui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bll.BookRatingsManager;
import bll.BooksManager;
import bll.UsersManager;
import dalconcrete.BookRatingsRepositoryMySql;
import dalconcrete.BooksRepositoryMysql;
import dalconcrete.UsersRepositoryMysql;
import entities.BookRatings;
import entities.Books;
import interfaces.IBookRatings;
import interfaces.IBooks;
import interfaces.IUsers;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class YeniUyePanelOylama extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtISBN;
	IBooks books = new BooksManager(new BooksRepositoryMysql());
	IUsers users = new UsersManager(new UsersRepositoryMysql());
	IBookRatings bookRatings = new BookRatingsManager(new BookRatingsRepositoryMySql());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YeniUyePanelOylama frame = new YeniUyePanelOylama();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public YeniUyePanelOylama() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 452, 378);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		txtISBN = new JTextField();
		txtISBN.setBounds(510, 120, 86, 20);
		contentPane.add(txtISBN);
		txtISBN.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboBox.setBounds(606, 120, 86, 20);
		contentPane.add(comboBox);

		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIsbn.setBounds(530, 95, 46, 14);
		contentPane.add(lblIsbn);

		JLabel lblPuan = new JLabel("PUAN");
		lblPuan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPuan.setBounds(623, 95, 46, 14);
		contentPane.add(lblPuan);

		JButton btnOyla = new JButton("OYLA");
		btnOyla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// for dongusu ekle
					BookRatings br = new BookRatings();
					// br.setUser_id();
					br.setUser_id(Integer.toString(users.UserID()));
					br.setIsbn(txtISBN.getText());
					br.setBook_rating(comboBox.getSelectedItem().toString());

					boolean sonuc = bookRatings.BookRatingsEkleme(br);
					if (sonuc) {
						JOptionPane.showMessageDialog(null, "Uye olma islemi basarilidir. Yonlendiriliyorsunuz...");
						KullaniciPaneli kullanicipaneli = new KullaniciPaneli();
						kullanicipaneli.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Uye olma islemi basarisiz.");
					}
				} catch (Exception e) {
					// TODO: handle exception

					JOptionPane.showMessageDialog(null, "Oylama islemi basarisiz. Hata:" + e.getMessage());
				}

				// br.setUser_id();
			}
		});
		btnOyla.setBounds(560, 151, 89, 23);
		contentPane.add(btnOyla);

		JButton btnKayitOl = new JButton("Kay\u0131t Ol");
		btnKayitOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnKayitOl.setBounds(560, 366, 89, 23);
		contentPane.add(btnKayitOl);

		JLabel lblUserID = new JLabel("");
		lblUserID.setBounds(586, 70, 46, 14);
		contentPane.add(lblUserID);
		KitapListele();
		lblUserID.setText(Integer.toString(users.UserID()));

		JLabel lblUserd = new JLabel("User-ID");
		lblUserd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserd.setBounds(530, 70, 46, 14);
		contentPane.add(lblUserd);
	}

	private void KitapListele() {
		// Books b = new Books();
		ArrayList<Books> KitapListele = books.KitapListele();

		Object[][] data = new Object[KitapListele.size()][];
		// Deneme amacli 10 tane dene
		for (int i = 0; i < data.length; i++) {
			data[i] = new Object[] { KitapListele.get(i).getIsbn(), KitapListele.get(i).getBook_tittle(),
					KitapListele.get(i).getBook_author() };

		}

		table.setModel(new DefaultTableModel(data, new String[] { "ISBN", "Book Title", "Book Author"

		}));
	}
}

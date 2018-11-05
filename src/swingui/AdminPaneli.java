package swingui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bll.BooksManager;
import bll.UsersManager;
import dalconcrete.BooksRepositoryMysql;
import dalconcrete.UsersRepositoryMysql;
import entities.Books;
import entities.Users;
import interfaces.IBooks;
import interfaces.IUsers;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class AdminPaneli extends JFrame {

	private JPanel contentPane;
	private JTextField txtISBN;
	private JTextField txtBookTitle;
	private JTextField txtBookAuthor;
	private JTextField txtYearOfPublication;
	private JTextField txtPublisher;
	private JTextField txtImageUrlS;
	private JTextField txtImageUrlM;
	private JTextField txtImageUrlL;
	IBooks books = new BooksManager(new BooksRepositoryMysql());
	IUsers users = new UsersManager(new UsersRepositoryMysql());
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

			// com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green",
			// Constants.LAF_ACRYL :
			// UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

			// Constants.LAF_AERO :
			// UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");

			// Constants.LAF_ALUMINIUM :
			// UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

			// Constants.LAF_BERNSTEIN :
			// UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");

			// Constants.LAF_FAST :
			// UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");

			// Constants.LAF_GRAPHITE :
			// UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");

			// Constants.LAF_HIFI :
			// UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");

			// Constants.LAF_LUNA :
			// UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");

			// Constants.LAF_MCWIN :
			// UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");

			// Constants.LAF_MINT :
			// UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

			// Constants.LAF_NOIRE :
			// UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");

			// Constants.LAF_SMART :
			// UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

			// Constants.LAF_TEXTURE :
			// UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
			
			AdminPaneli dialog = new AdminPaneli();
			dialog.setLocationRelativeTo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public AdminPaneli() {
		setTitle("Admin Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 200));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);

		JButton btnKitapEkleme = new JButton("Kitap Ekleme");
		btnKitapEkleme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Books b = new Books();
				b.setIsbn(txtISBN.getText());
				b.setBook_tittle(txtBookTitle.getText());
				b.setBook_author(txtBookAuthor.getText());
				b.setYear_of_publication(txtYearOfPublication.getText());
				b.setPublisher(txtPublisher.getText());
				b.setImage_url_s(txtImageUrlS.getText());
				b.setImage_url_m(txtImageUrlM.getText());
				b.setImage_url_l(txtImageUrlL.getText());
				// b.getDatetime();

				boolean sonuc = books.KitapEkleme(b);
				if (sonuc)
					JOptionPane.showMessageDialog(null, "Kitap basariyla eklendi.");
				else
					JOptionPane.showMessageDialog(null, "Kitap ekleme basarisiz.");

			}
		});
		btnKitapEkleme.setBounds(604, 83, 125, 23);
		panel.add(btnKitapEkleme);

		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setBounds(119, 28, 120, 14);
		panel.add(lblISBN);

		JLabel lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setBounds(119, 70, 120, 14);
		panel.add(lblBookTitle);

		JLabel lblBookAuthor = new JLabel("Book Author");
		lblBookAuthor.setBounds(119, 112, 120, 14);
		panel.add(lblBookAuthor);

		JLabel lblYearOfPublication = new JLabel("Year Of Publication");
		lblYearOfPublication.setBounds(119, 153, 120, 14);
		panel.add(lblYearOfPublication);

		txtISBN = new JTextField();
		txtISBN.setBounds(244, 25, 86, 20);
		panel.add(txtISBN);
		txtISBN.setColumns(10);

		txtBookTitle = new JTextField();
		txtBookTitle.setBounds(244, 67, 86, 20);
		panel.add(txtBookTitle);
		txtBookTitle.setColumns(10);

		txtBookAuthor = new JTextField();
		txtBookAuthor.setBounds(244, 109, 86, 20);
		panel.add(txtBookAuthor);
		txtBookAuthor.setColumns(10);

		txtYearOfPublication = new JTextField();
		txtYearOfPublication.setBounds(244, 150, 86, 20);
		panel.add(txtYearOfPublication);
		txtYearOfPublication.setColumns(10);

		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(350, 28, 120, 14);
		panel.add(lblPublisher);

		JLabel lblImageUrlS = new JLabel("Image URL S");
		lblImageUrlS.setBounds(350, 70, 120, 14);
		panel.add(lblImageUrlS);

		JLabel lblImageUrlM = new JLabel("Image URL M");
		lblImageUrlM.setBounds(350, 112, 120, 14);
		panel.add(lblImageUrlM);

		JLabel lblImageUrlL = new JLabel("Image URL L");
		lblImageUrlL.setBounds(350, 153, 120, 14);
		panel.add(lblImageUrlL);

		txtPublisher = new JTextField();
		txtPublisher.setBounds(480, 25, 86, 20);
		panel.add(txtPublisher);
		txtPublisher.setColumns(10);

		txtImageUrlS = new JTextField();
		txtImageUrlS.setBounds(480, 67, 86, 20);
		panel.add(txtImageUrlS);
		txtImageUrlS.setColumns(10);

		txtImageUrlM = new JTextField();
		txtImageUrlM.setBounds(480, 109, 86, 20);
		panel.add(txtImageUrlM);
		txtImageUrlM.setColumns(10);

		txtImageUrlL = new JTextField();
		txtImageUrlL.setBounds(480, 150, 86, 20);
		panel.add(txtImageUrlL);
		txtImageUrlL.setColumns(10);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JButton btnKitaplariListele = new JButton("Kitaplar\u0131 Listele");
		btnKitaplariListele.setIcon(new ImageIcon(this.getClass().getResource("/Filter.png")));
		btnKitaplariListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KitapListele();
			}
		});
		btnKitaplariListele.setBounds(30, 5, 165, 23);
		panel_1.add(btnKitaplariListele);

		JButton btnKullanicilariListele = new JButton("Kullan\u0131c\u0131lar\u0131 Listele");
		btnKullanicilariListele.setIcon(new ImageIcon(this.getClass().getResource("/Filter.png")));
		btnKullanicilariListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KullaniciListele();
			}
		});
		btnKullanicilariListele.setBounds(400, 5, 165, 23);
		panel_1.add(btnKullanicilariListele);

		JButton btnKitabiSil = new JButton("Kitab\u0131 Sil");
		btnKitabiSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (table.getSelectedRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Silinecek kitabi seciniz.");
						return;
					}

					int donen = JOptionPane.showConfirmDialog(null, "Emin misiniz?");

					if (donen != 0)
						return;

					String isbn = table.getValueAt(table.getSelectedRow(), 0).toString();

					if (books.KitapSilme(isbn)) {
						KitapListele();
						JOptionPane.showMessageDialog(null, "Kayit Silindi.");
					} else {
						JOptionPane.showMessageDialog(null, "Kayit Silinemedi.");
					}

				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Kayit Silinemedi.Hata:" + e.getMessage());
				}
			}
		});
		btnKitabiSil.setBounds(215, 5, 165, 23);
		panel_1.add(btnKitabiSil);

		JButton btnKullanciyiSil = new JButton("Kullan\u0131c\u0131y\u0131 Sil");
		btnKullanciyiSil.setBounds(585, 5, 165, 23);
		panel_1.add(btnKullanciyiSil);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 39, 774, 212);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		btnKullanciyiSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (table.getSelectedRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Silinecek uyeyi seciniz.");
						return;
					}

					int donen = JOptionPane.showConfirmDialog(null, "Emin misiniz?");

					if (donen != 0)
						return;

					int user_id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());

					if (users.UyeSilme(user_id)) {
						KullaniciListele();
						JOptionPane.showMessageDialog(null, "Kayit Silindi.");
					} else {
						JOptionPane.showMessageDialog(null, "Kayit Silinemedi.");
					}
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Kayit Silinemedi.Hata:" + e.getMessage());

				}
			}
		});
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}

	private void KitapListele() {
		// Books b = new Books();
		ArrayList<Books> KitapListele = books.KitapListele();

		Object[][] data = new Object[KitapListele.size()][];
		// Deneme amacli 10 tane dene
		for (int i = 0; i < data.length; i++) {
			data[i] = new Object[] { KitapListele.get(i).getIsbn(), KitapListele.get(i).getBook_tittle(),
					KitapListele.get(i).getBook_author(), KitapListele.get(i).getYear_of_publication(),
					KitapListele.get(i).getPublisher(), KitapListele.get(i).getImage_url_s(),
					KitapListele.get(i).getImage_url_m(), KitapListele.get(i).getImage_url_l() };

		}

		table.setModel(new DefaultTableModel(data, new String[] { "ISBN", "Book Title", "Book Author",
				"Year of Publication", "Publisher", "Image URL S", "Image URL M", "Image URL L"

		}));
	}

	private void KullaniciListele() {
		ArrayList<Users> KullaniciListele = users.UyeListeleme();

		Object[][] data = new Object[KullaniciListele.size()][];
		// Deneme amacli 10 tane dene
		for (int i = 0; i < data.length; i++) {
			data[i] = new Object[] { KullaniciListele.get(i).getUser_id(), KullaniciListele.get(i).getLocation(),
					KullaniciListele.get(i).getAge(), KullaniciListele.get(i).getPassword() };
		}

		table.setModel(new DefaultTableModel(data, new String[] { "User ID", "Password", "Age", "Location"

		}));

	}
}

package swingui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class KullaniciPaneli extends JFrame {

	private JPanel contentPane;
	IBooks books = new BooksManager(new BooksRepositoryMysql());
	IUsers users = new UsersManager(new UsersRepositoryMysql());
	IBookRatings bookRatings = new BookRatingsManager(new BookRatingsRepositoryMySql());
	private JTable table;
	private JTable tablePDF;
	Connection baglanti;
	private JTable tablePHOTO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KullaniciPaneli frame = new KullaniciPaneli();
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
	public KullaniciPaneli() {
		setTitle("Kullan\u0131c\u0131 Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 812);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 958, 274);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnTopRated = new JButton("Top Rated");
		btnTopRated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TopRatedBooks();
			}
		});
		btnTopRated.setBounds(51, 296, 180, 23);
		contentPane.add(btnTopRated);

		JButton btnPopular = new JButton("Popular");
		btnPopular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PopularBooks();
			}
		});
		btnPopular.setBounds(282, 296, 180, 23);
		contentPane.add(btnPopular);

		JButton btnLastDownload = new JButton("Last Download");
		btnLastDownload.setBounds(513, 296, 180, 23);
		contentPane.add(btnLastDownload);

		JButton btnNewButton = new JButton("A Collaborative Filtering");
		btnNewButton.setBounds(744, 296, 180, 23);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 350, 455, 338);
		contentPane.add(scrollPane_1);

		tablePDF = new JTable();
		scrollPane_1.setViewportView(tablePDF);

		JButton btnPDF = new JButton("PDF A\u00E7");
		btnPDF.setIcon(new ImageIcon(this.getClass().getResource("/PDF.png")));
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tablePDF.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Okumak istediginiz kitabi seciniz.");
					return;
				}
				try {
					Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "
							+ "C:\\Program Files\\Eclipse\\KitapOkumaveOneriUygulamasi\\Deneme.pdf");
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Check your file details");
				}
			}
		});
		btnPDF.setBounds(118, 699, 171, 57);
		contentPane.add(btnPDF);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(513, 350, 455, 338);
		contentPane.add(scrollPane_2);

		tablePHOTO = new JTable();
		scrollPane_2.setViewportView(tablePHOTO);

		JButton btnFotografAc = new JButton("Foto\u011Fraf A\u00E7");
		btnFotografAc.setBounds(666, 699, 171, 57);
		contentPane.add(btnFotografAc);
		KitapListele();
		KitapListele2();
	}

	private void TopRatedBooks() {
		ArrayList<BookRatings> Ratings = bookRatings.TopRatedBooks();

		Object[][] data = new Object[Ratings.size()][];

		for (int i = 0; i < data.length; i++) {
			data[i] = new Object[] { Ratings.get(i).getIsbn(), Ratings.get(i).getBook_rating() };
		}

		table.setModel(new DefaultTableModel(data, new String[] { "ISBN", "Rating" }));

	}

	private void PopularBooks() {
		ArrayList<BookRatings> Popular = bookRatings.PopularBooks();

		Object[][] data = new Object[Popular.size()][];

		for (int i = 0; i < data.length; i++) {
			data[i] = new Object[] { Popular.get(i).getIsbn(), Popular.get(i).getCount() };
		}

		table.setModel(new DefaultTableModel(data, new String[] { "ISBN", "Count" }));

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

		tablePDF.setModel(new DefaultTableModel(data, new String[] { "ISBN", "Book Title", "Book Author"

		}));
	}

	private void KitapListele2() {
		ArrayList<Books> KitapListele = books.KitapListele();

		Object[][] data = new Object[KitapListele.size()][];
		// Deneme amacli 10 tane dene
		for (int i = 0; i < data.length; i++) {
			data[i] = new Object[] { KitapListele.get(i).getIsbn(), KitapListele.get(i).getImage_url_s(),
					KitapListele.get(i).getImage_url_m(), KitapListele.get(i).getImage_url_l() };

		}

		tablePHOTO
				.setModel(new DefaultTableModel(data, new String[] { "ISBN", "Image URL S", "Image URL M", "Image URL L"

				}));
	}
}

package swingui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.UsersManager;
import dalconcrete.UsersRepositoryMysql;
import interfaces.IUsers;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Giris extends JFrame {

	private JPanel contentPane;
	private JTextField txtKullaniciAdi;
	private JPasswordField passwordField;
	IUsers users = new UsersManager(new UsersRepositoryMysql());

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

			// ekrani ortalar
			Giris dialog = new Giris();
			dialog.setLocationRelativeTo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Giris() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Kitap Okuma ve \u00D6neri Uygulamas\u0131");
		setBounds(100, 100, 333, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblGiris = new JLabel(" ");
		lblGiris.setIcon(new ImageIcon(this.getClass().getResource("/Giris.png")));
		lblGiris.setBounds(10, 11, 39, 104);
		contentPane.add(lblGiris);

		JLabel lblKullaniciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullaniciAdi.setBounds(59, 43, 72, 14);
		contentPane.add(lblKullaniciAdi);

		JLabel lblSifre = new JLabel("\u015Eifre");
		lblSifre.setBounds(59, 68, 72, 14);
		contentPane.add(lblSifre);

		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setBounds(158, 40, 95, 20);
		contentPane.add(txtKullaniciAdi);
		txtKullaniciAdi.setColumns(10);

		JButton btnGirisYap = new JButton("Giri\u015F Yap");
		btnGirisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtKullaniciAdi.getText().equals("admin") || txtKullaniciAdi.getText().equals("Admin")
						|| txtKullaniciAdi.getText().equals("ADMIN")) {
					if (passwordField.getText().equals("1234")) {
						AdminPaneli adminpaneli = new AdminPaneli();
						adminpaneli.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Sifre hatali!","UYARI",JOptionPane.WARNING_MESSAGE);
						return;
					}

				} else if (txtKullaniciAdi.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Kullanici adi bos olamaz!","UYARI",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				else {
					if (rootPaneCheckingEnabled) {
						KullaniciPaneli kullanicipaneli = new KullaniciPaneli();
						kullanicipaneli.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Sifre hatali!","UYARI",JOptionPane.WARNING_MESSAGE);
						return;
					}
					KullaniciPaneli kullanicipaneli = new KullaniciPaneli();
					kullanicipaneli.setVisible(true);
				}

			}
		});
		btnGirisYap.setBounds(158, 93, 95, 23);
		contentPane.add(btnGirisYap);

		JButton btnUyeOl = new JButton("\u00DCye Ol");
		btnUyeOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				YeniUyePaneli YeniUye = new YeniUyePaneli();
				YeniUye.setVisible(true);
			}
		});
		btnUyeOl.setBounds(59, 93, 89, 23);
		contentPane.add(btnUyeOl);

		passwordField = new JPasswordField();
		passwordField.setBounds(158, 65, 95, 20);
		contentPane.add(passwordField);
	}
}

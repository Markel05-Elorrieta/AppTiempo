package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ProvinciasView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ProvinciasView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList listProvincias = new JList();
		listProvincias.setBounds(135, 63, 444, 340);
		contentPane.add(listProvincias);
		
		JLabel lblProvincias = new JLabel("PROVINCIAS");
		lblProvincias.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblProvincias.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvincias.setBounds(272, 11, 163, 21);
		contentPane.add(lblProvincias);
		
		
	}
}

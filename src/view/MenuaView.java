package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Provincias;
import model.sql.SQL;

public class MenuaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnIncluir;
	private JButton btnSeleccionar;
	private JComboBox<Provincias> comboBoxProvincias;


	/**
	 * Create the frame.
	 */
	public MenuaView(List<Provincias> provincias) {
		setTitle("Menua");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(21, 23, 89, 23);
		contentPane.add(btnIncluir);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(282, 341, 102, 23);
		contentPane.add(btnSeleccionar);
		
		comboBoxProvincias = new JComboBox<Provincias>();
		comboBoxProvincias.setBounds(197, 170, 278, 23);
		contentPane.add(comboBoxProvincias);

		for (Provincias provincia : provincias) {
			comboBoxProvincias.addItem(provincia);
		}
	}
	
	public void añadirProvincia(Provincias provincia) {
		comboBoxProvincias.addItem(provincia);
	}
	
	public JButton getBtnIncluir() {
		return btnIncluir;
	}
	
	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}
	
	public JComboBox<Provincias> getComboBoxProvincias() {
		return comboBoxProvincias;
	}
}

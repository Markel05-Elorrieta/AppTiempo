package view;

import java.awt.Font;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Municipios;

public class MunicipiosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSeleccionar;
	private JList<Municipios> listMunicipios;

	/**
	 * Create the frame.
	 */
	public MunicipiosView(List<Municipios> municipios) {
		setTitle("Municipios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		DefaultListModel<Municipios> listModel = new DefaultListModel<>();
		for (Municipios municipio : municipios) {
			listModel.addElement(municipio);
		}

		JLabel lblProvincias = new JLabel("MUNICIPIOS");
		lblProvincias.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblProvincias.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvincias.setBounds(264, 11, 163, 21);
		contentPane.add(lblProvincias);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(296, 413, 118, 23);
		contentPane.add(btnSeleccionar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 53, 641, 337);
		contentPane.add(scrollPane);

		listMunicipios = new JList<Municipios>(listModel);
		scrollPane.setViewportView(listMunicipios);

	}

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	public JList<Municipios> getListMunicipios() {
		return listMunicipios;
	}
}

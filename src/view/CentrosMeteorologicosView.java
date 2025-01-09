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

import model.CentrosMeteorologicos;
import model.EspaciosNaturales;

public class CentrosMeteorologicosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSeleccionar;
	private JList<CentrosMeteorologicos> listCentros;
	private JList<EspaciosNaturales> listEspacios;

	/**
	 * Create the frame.
	 */
	public CentrosMeteorologicosView(List<CentrosMeteorologicos> centrosMeteorologicos, List<EspaciosNaturales> espaciosNaturales) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCentrosMeteorologicos = new JLabel("CENTROS METEOROLÓGICOS Y ESPACIOS NATURALES");
		lblCentrosMeteorologicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentrosMeteorologicos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCentrosMeteorologicos.setBounds(121, 11, 451, 21);
		contentPane.add(lblCentrosMeteorologicos);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(287, 412, 118, 23);
		contentPane.add(btnSeleccionar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 52, 316, 337);
		contentPane.add(scrollPane);
		
		DefaultListModel<CentrosMeteorologicos> listModelCentros = new DefaultListModel<>();
		for (CentrosMeteorologicos centro : centrosMeteorologicos) {
			listModelCentros.addElement(centro);
		}
		
		DefaultListModel<EspaciosNaturales> listModelEspacios = new DefaultListModel<>();
		for (EspaciosNaturales espacio : espaciosNaturales) {
			listModelEspacios.addElement(espacio);
		}
		
		listCentros = new JList<CentrosMeteorologicos>(listModelCentros);
		scrollPane.setViewportView(listCentros);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(368, 52, 316, 337);
		contentPane.add(scrollPane_1);
		
		listEspacios = new JList<EspaciosNaturales>(listModelEspacios);
		scrollPane_1.setViewportView(listEspacios);
	}
	
	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}
	
	public JList<CentrosMeteorologicos> getListCentrosMeteorologicos() {
		return listCentros;
	}
	
	public JList<EspaciosNaturales> getListEspaciosNaturales() {
		return listEspacios;
	}
}

package view;

import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.MedicionesCentroMet;
import javax.swing.JScrollPane;

public class TaulaCentrosView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblCentro;

	/**
	 * Create the frame.
	 */
	public TaulaCentrosView(List<MedicionesCentroMet> medicionesCentroMet) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCentro = new JLabel("CENTRO: ");
		lblCentro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCentro.setBounds(174, 11, 451, 21);
		contentPane.add(lblCentro);
		
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ICA");
        model.addColumn("DIR VIENTO");
        model.addColumn("H. Relativa");
        model.addColumn("P. atmosferica");
        model.addColumn("Precipitación");
        model.addColumn("Radiación solar");
        model.addColumn("Temperatura AM");
        model.addColumn("Vel. Viento");

        for (MedicionesCentroMet medicion : medicionesCentroMet) {
            model.addRow(new Object[]{
					medicion.getIca(), medicion.getDirViento(), medicion.getHRelativa(),
					medicion.getPAtmosferica(), medicion.getPrecip(), medicion.getRadSolar(),
					medicion.getTempAmbiente(), medicion.getVViento()
            });
        }
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 44, 741, 413);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
	}
	
	public void setCentro(String centro) {
		lblCentro.setText(centro);
	}
}

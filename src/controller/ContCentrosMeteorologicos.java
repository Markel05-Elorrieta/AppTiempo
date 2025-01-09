package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.CentrosMeteorologicos;
import model.EspaciosNaturales;
import model.Municipios;
import model.sql.SQL;
import view.CentrosMeteorologicosView;

public class ContCentrosMeteorologicos {
	private Municipios municipio;
	private SQL sql = new SQL();
	
	public ContCentrosMeteorologicos(Municipios municipio) {
        this.municipio = municipio;
	}
	
	public void start() {
		List<CentrosMeteorologicos> centrosMeteorologicos = sql.getCentrosMeteorologicosFromMunicipio(municipio);
		List<EspaciosNaturales> espaciosNaturales = sql.getEspaciosNaturalesFromMunicipio(municipio);
		
		CentrosMeteorologicosView centrosMeteorologicosView = new CentrosMeteorologicosView(centrosMeteorologicos, espaciosNaturales);
		centrosMeteorologicosView.setVisible(true);
		setListeners(centrosMeteorologicosView);
	}
	
	public void setListeners(CentrosMeteorologicosView centrosMeteorologicosView) {
		centrosMeteorologicosView.getBtnSeleccionar().addActionListener(e -> {
			try {
				CentrosMeteorologicos centrosMeteorologicos = new CentrosMeteorologicos();
				centrosMeteorologicos = centrosMeteorologicosView.getListCentrosMeteorologicos().getSelectedValue();
				ContTaulaCentrosView contMedicionesCentroMet = new ContTaulaCentrosView(centrosMeteorologicos);
				contMedicionesCentroMet.start();
				centrosMeteorologicosView.dispose();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Has seleccionado un espacio natural. Solo se puede seleccionar un centro meteorológico.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}

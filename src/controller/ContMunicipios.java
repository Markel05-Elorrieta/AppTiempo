package controller;

import java.util.List;

import model.Municipios;
import model.Provincias;
import model.sql.SQL;
import view.MunicipiosView;

public class ContMunicipios {
	private SQL sql = new SQL();
	private Provincias provincia;
	
	public ContMunicipios(Provincias provincia) {
		this.provincia = provincia;
	}
	
	public void start() {
		List<Municipios> municipios = sql.getMunicipiosFromProvincia(provincia);
		MunicipiosView provinciasView = new MunicipiosView(municipios);
		provinciasView.setVisible(true);
		setListeners(provinciasView);
	}
	
	public void setListeners(MunicipiosView provinciasView) {
		provinciasView.getBtnSeleccionar().addActionListener(e -> {
			Municipios municipio = new Municipios();
			municipio = provinciasView.getListMunicipios().getSelectedValue();
			ContCentrosMeteorologicos contCentrosMeteorologicos = new ContCentrosMeteorologicos(municipio);
			contCentrosMeteorologicos.start();
			provinciasView.dispose();
		});
	}
}

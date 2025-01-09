package controller;

import java.util.List;

import model.CentrosMeteorologicos;
import model.MedicionesCentroMet;
import model.sql.SQL;
import view.TaulaCentrosView;

public class ContTaulaCentrosView {
	private SQL sql = new SQL();
	private CentrosMeteorologicos centrosMeteorologicos;
	private TaulaCentrosView taulaCentrosView;
	
	public ContTaulaCentrosView(CentrosMeteorologicos centrosMeteorologicos) {
		this.centrosMeteorologicos = centrosMeteorologicos;
	}
	
	public void start() {
		List<MedicionesCentroMet> medicionesCentroMet = sql.getMedicionesFromCentro(centrosMeteorologicos);
		taulaCentrosView = new TaulaCentrosView(medicionesCentroMet);
		taulaCentrosView.setVisible(true);
		setListeners();
	}
	
	public void setListeners() {
		taulaCentrosView.setCentro(centrosMeteorologicos.getNombre());
	}
}

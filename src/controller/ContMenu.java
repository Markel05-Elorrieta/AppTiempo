package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import model.Municipios;
import model.Provincias;
import model.sql.SQL;
import view.MenuaView;

public class ContMenu {
	private SQL sql = new SQL();

	public void start() {
		List<Provincias> provincias = sql.importProvincias();
		MenuaView menua = new MenuaView(provincias);
		menua.setVisible(true);
		setListeners(menua);
	}

	private void setListeners(MenuaView menu) {
		menu.getBtnIncluir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Provincias provincia = new Provincias();
				int randomNumber = generateRandomNumber(1, 100);
				String randomProvincia = getRandomProvincia();
				String randomMunicipio = getRandomMunicipio();

				provincia.setNombre(randomProvincia);

				provincia.setIdProvincia(randomNumber);
				HashSet<Municipios> municipios = new HashSet<Municipios>();

				Municipios municipio = new Municipios();
				municipio.setNombre(randomMunicipio);
				municipio.setIdMunicipio(1);
				municipio.setProvincias(provincia);
				municipios.add(municipio);

				provincia.setMunicipioses(municipios);
				sql.insertProvincia(provincia);
				menu.añadirProvincia(provincia);
			}
		});

		menu.getBtnSeleccionar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Provincias provincia = (Provincias) menu.getComboBoxProvincias().getSelectedItem();
				ContMunicipios contMunicipios = new ContMunicipios(provincia);
				contMunicipios.start();
				menu.dispose();
			}
		});
	}

	private static final String[] PROVINCIAS = { "Navarra", "Madrid", "Barcelona", "Valencia", "Sevilla" };
	private static final String[] MUNICIPIOS = { "Pamplona", "Madrid", "Barcelona", "Valencia", "Sevilla" };

	public int generateRandomNumber(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}

	public String getRandomProvincia() {
		Random random = new Random();
		int index = random.nextInt(PROVINCIAS.length);
		return PROVINCIAS[index];
	}

	public String getRandomMunicipio() {
		Random random = new Random();
		int index = random.nextInt(MUNICIPIOS.length);
		return MUNICIPIOS[index];
	}
}

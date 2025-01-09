package model.sql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.HibernateUtil;
import model.CentrosMeteorologicos;
import model.EspaciosNaturales;
import model.MedicionesCentroMet;
import model.Municipios;
import model.Provincias;

public class SQL {

	public List<Provincias> importProvincias() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Provincias";
		List<Provincias> provincias = session.createQuery(hql).list();

		tx.commit();
		session.close();
		return provincias;
	}

	public void insertProvincia(Provincias provincia) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.save(provincia);
		tx.commit();
		session.close();
	}

	public void insertMunicipio(Municipios municipio) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.save(municipio);
		tx.commit();
		session.close();
	}

	public List<Municipios> getMunicipiosFromProvincia(Provincias provincia) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM Municipios WHERE provincias.id = :provinciaId";
		List<Municipios> municipios = session.createQuery(hql).setParameter("provinciaId", provincia.getIdProvincia())
				.list();

		tx.commit();
		session.close();
		return municipios;
	}

	public List<CentrosMeteorologicos> getCentrosMeteorologicosFromMunicipio(Municipios municipio) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM CentrosMeteorologicos WHERE municipios.id = :municipioId";
		List<CentrosMeteorologicos> centrosMeteorologicos = session.createQuery(hql)
				.setParameter("municipioId", municipio.getIdMunicipio()).list();

		tx.commit();
		session.close();
		return centrosMeteorologicos;
	}

	public List<EspaciosNaturales> getEspaciosNaturalesFromMunicipio(Municipios municipio) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "SELECT en FROM EspaciosNaturales en, MunicipiosEspaciosNat men "
				+ "WHERE en.id = men.espaciosNaturales.id AND men.municipios.id = :municipioId";
		List<EspaciosNaturales> espaciosNaturales = session.createQuery(hql)
				.setParameter("municipioId", municipio.getIdMunicipio()).list();

		tx.commit();
		session.close();
		return espaciosNaturales;
	}

	public List<MedicionesCentroMet> getMedicionesFromCentro(CentrosMeteorologicos centro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		String hql = "FROM MedicionesCentroMet WHERE centrosMeteorologicos.id = :centroId";
		List<MedicionesCentroMet> mediciones = session.createQuery(hql).setParameter("centroId", centro.getIdCentroMet())
				.list();

		tx.commit();
		session.close();
		return mediciones;
	}

}
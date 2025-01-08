package model.sql;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.HibernateUtil;
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

		String hql = "FROM Municipios WHERE idProvincia = " + provincia.getIdProvincia();
		List<Municipios> municipios = session.createQuery(hql).list();

		tx.commit();
		session.close();
		return municipios;
	}

}
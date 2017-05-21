
package com.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Clinic;
import com.model.Team;

@Repository
public class ClinicDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private String hql;
	private Query query;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addClinic(Clinic clinic) {
		getCurrentSession().save(clinic);
	}
//TODO bouw beveiling in voor als clinic niet is gevonden
//TODO change to relevant clinic attributes
	
	public void updateClinic(Clinic clinic) {
		Clinic clinicToUpdate = getClinic(clinic.getId());
		clinicToUpdate.setDatum(clinic.getDatum());
		clinicToUpdate.setTrainer(clinic.getTrainer());
		clinicToUpdate.setDeelnemers(clinic.getDeelnemers());
		getCurrentSession().update(clinicToUpdate);
	}

	public Clinic getClinic(int id) {
		hql = "from Clinic t where t.id= :id";
		query = getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		Clinic clinic = (Clinic) query.list().get(0);
		return clinic;
	}

	public void deleteClinic(int id) {
		Clinic clinic = getClinic(id);
		if (clinic != null) {
			getCurrentSession().delete(clinic);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Clinic> getClinics() {
		hql = "from Clinic";
		query = getCurrentSession().createQuery(hql);
		return (List<Clinic>) query.list();
	}

	public void storeAllClinics(List<Clinic> clinics) {
		for (Clinic clinic : clinics) {
			getCurrentSession().save(clinic);
		}
		
	}
	
	public void addTeamToClinic(int id, Team t){
		Session session=this.getCurrentSession();
		Clinic c=this.getClinic(id);
		c.addDeelnemer(t);
		session.save(c);
	}
}




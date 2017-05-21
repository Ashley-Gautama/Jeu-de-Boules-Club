package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.ClinicDAO;
import com.model.Clinic;
import com.model.Team;

@Service
@Transactional
public class ClinicService {

	@Autowired
	private ClinicDAO clinicDao;

	public ClinicService() {

	}

	public void addClinic(Clinic clinic) {
		clinicDao.addClinic(clinic);
	}
	// TODO bouw beveiling in voor als clinic niet is gevonden
	// TODO change to relevant clinic attributes

	 public void updateClinic(Clinic clinic) {
	 clinicDao.updateClinic(clinic);
	 }

	public Clinic getClinic(int id) {
		return clinicDao.getClinic(id);
	}

	public void deleteClinic(int id) {
		clinicDao.deleteClinic(id);
	}

	@SuppressWarnings("unchecked")
	public List<Clinic> getClinics() {
		return clinicDao.getClinics();
	}

	public void storeAllClinics(List<Clinic> clinics) {
		clinicDao.storeAllClinics(clinics);
	}
	
	public void addTeamToClinic(int id, Team t){
clinicDao.addTeamToClinic(id, t);
} }

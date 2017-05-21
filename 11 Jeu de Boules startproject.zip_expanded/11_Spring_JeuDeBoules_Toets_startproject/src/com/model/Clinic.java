package com.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Clinic implements Comparable<Clinic> {
	@Id
	@GeneratedValue
	private int id;

	private String datum;

	private String trainer;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Team> deelnemers;

	public Clinic() {
		super();
	}

	public Clinic(String datum, String trainer) {
		super();
		this.datum = datum;
		this.trainer = trainer;
		this.deelnemers = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "" + this.deelnemers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Team> getDeelnemers() {
		return deelnemers;
	}

	public void setDeelnemers(List<Team> deelnemers) {
		this.deelnemers = deelnemers;
	}

	public void addDeelnemer(Team t) {
		if (deelnemers.size() < 4) {
			deelnemers.add(t);
			t.setClinic(this);
		}
	}

	public void deleteDeelnemer(Team t) {
		deelnemers.remove(t);

	}

	@Override
	public int compareTo(Clinic o) {

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		Date date1;
		Date date2;
		try {
			date1 = format.parse(this.datum);
			date2 = format.parse(o.datum);
			if (date1.compareTo(date2) < 0) {
				return -1;
			}

			else if (date1.compareTo(date2) >0) {
				return 1;
			}

			else {
				return 0;
			}

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
return 100000;
	}

}

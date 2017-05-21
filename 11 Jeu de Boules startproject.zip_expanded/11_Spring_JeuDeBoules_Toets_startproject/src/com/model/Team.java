/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Team implements Comparable<Team> {

	@Id
	@GeneratedValue
	private int id;

	private String name;
	private String coach;

	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Member> members;
	
	@ManyToMany(mappedBy = "deelnemers")
	private List<Clinic> clinics;

	public Team() {
		this(null, null);
	}

	public Team(String name, String coach) {
		super();
		this.id = 0;
		this.name = name;
		this.coach = coach;
		members = new ArrayList<Member>();
		clinics=new ArrayList<Clinic>();
	}
	
	

	@Override
	public String toString() {
		return ""+id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public void addMember(Member m) {
		if (members.size() < 4) {
			members.add(m);
			m.setTeam(this);
		}
	}

	public void deleteMember(Member m) {    
		members.remove(m);
		m.setTeam(null);
	}

	public List<Clinic> getClinics() {
		return clinics;
	}

	public void setClinic(Clinic clinic) {
		this.clinics.add(clinic);
	}
	
	public void deleteClinic(Clinic clinic) {
		this.clinics.remove(clinic);
	}

	

	@Override
	public int compareTo(Team o) {
		return this.name.compareTo(o.name);
		
	}
}

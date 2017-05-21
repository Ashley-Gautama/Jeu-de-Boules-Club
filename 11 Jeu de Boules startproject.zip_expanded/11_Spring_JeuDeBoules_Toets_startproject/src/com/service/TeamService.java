/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TeamDAO;
import com.model.Team;

@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamDAO teamDAO;

	public void addTeam(Team team) {
		teamDAO.addTeam(team);
	}

	public void updateTeam(Team team) {
		teamDAO.updateTeam(team);
	}

	public Team getTeam(int id) {
		return teamDAO.getTeam(id);
	}

	public void deleteTeam(int id) {
		teamDAO.deleteTeam(id);
	}

	public List<Team> getTeams() {
		return teamDAO.getTeams();
	}

	public void storeAllTeams(List<Team> teams) {
		teamDAO.storeAllTeams(teams);
	}
}

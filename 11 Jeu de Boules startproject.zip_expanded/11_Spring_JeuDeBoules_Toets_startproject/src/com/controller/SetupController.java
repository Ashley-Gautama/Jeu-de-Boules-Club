/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Clinic;
import com.model.Member;
import com.model.Team;
import com.service.ClinicService;
import com.service.MemberService;
import com.service.TeamService;

/**
 *
 * @author Peter
 */
@Controller

public class SetupController {

    @Autowired
    private MemberService memberService;
    
    @Autowired
    private TeamService teamService;
    @Autowired
    private ClinicService clinicService;

    @RequestMapping(value = "/dbsetup")
    public ModelAndView ledenlijst() {
        ModelAndView menuView = new ModelAndView("menu");
        dbSetup();
        String message = "Database setup was successful.";
        menuView.addObject("message", message);
        return menuView;
    }

    private void dbSetup() {
        List<Member> members = new ArrayList<Member>();
        Member member = new Member("Adrie", "Aardnoot", null);	// index = 0
        members.add(member);
        member = new Member("Brutus", "Braaf", null);			// index = 1
        members.add(member);
        member = new Member("Charlotte", "Chocola", null);		// index = 2
        members.add(member);
        member = new Member("Dirk", "Draaikont", null);			// index = 3
        members.add(member);
        member = new Member("Elsbeth", "Everzwijn", null);		// index = 4
        members.add(member);
        member = new Member("Erik", "Everzwijn", null);			// index = 5
        members.add(member);
        member = new Member("Eduard", "Everzwijn", null);		// index = 6
        members.add(member);
        member = new Member("Frits", "Fabriek", null);			// index = 7
        members.add(member);
        member = new Member("Gerrit", "Grootspraak", null);		// index = 8
        members.add(member);
        member = new Member("Hans", "Hagelslag", null);			// index = 9
        members.add(member);
        member = new Member("Ineke", "Iebelsma", null);			// index = 10
        members.add(member);

        List<Team> teams = new ArrayList<Team>();
        Team team = new Team("Les champions du monde", "Charles de Gaulle");	// index = 0
        teams.add(team);
        team.addMember(members.get(0));
        team.addMember(members.get(1));
        team.addMember(members.get(2));

        team = new Team("Les champignons du monde", "Georges Pompidou");			// index = 1
        team.addMember(members.get(3));
        team.addMember(members.get(4));
        team.addMember(members.get(5));
        teams.add(team);

        team = new Team("Comme des Francais", "Francois Miterrand");			// index = 2
        team.addMember(members.get(6));
        team.addMember(members.get(7));
        teams.add(team);

        team = new Team("La Fine Fleur du Boule", "Jacques Chirac");				// index = 3
        teams.add(team);

        team = new Team("Les Professeurs", "Nicolas Sarkozy");				// index = 4
        teams.add(team);
        
        List<Clinic> clinics=new ArrayList<>();
        Clinic clinic=new Clinic("12-05-2005","Piet Jensen");
        System.out.println("teamnaam is: "+teams.get(2));
        clinics.add(clinic);
        clinic.addDeelnemer(teams.get(2));
        clinic.addDeelnemer(teams.get(4));

        
        
        
        clinic=new Clinic("12-09-2011","Harry Potter");
        clinics.add(clinic);
        clinic.addDeelnemer(teams.get(1));

        
        

        teamService.storeAllTeams(teams);
        memberService.storeAllMembers(members);
        clinicService.storeAllClinics(clinics);
    }
}

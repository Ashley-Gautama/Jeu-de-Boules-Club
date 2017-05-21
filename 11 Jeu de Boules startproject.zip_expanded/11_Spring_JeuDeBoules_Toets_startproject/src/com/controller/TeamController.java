package com.controller;

import com.model.Member;
import com.model.Team;
import com.service.TeamService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    private static String titelNieuw = "Nieuw team";
    private static String titelWijzig = "Wijzig team";

    @RequestMapping(value = "/teamlist")
    public ModelAndView ledenlijst() {
        ModelAndView teamListView = new ModelAndView("/team/list");
        List<Team> teams = teamService.getTeams();
        teamListView.addObject("teams", teams);
        return teamListView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView teamAddPage() {
        ModelAndView teamAddView = new ModelAndView("/team/add");
        teamAddView.addObject("paginaTitel", titelNieuw);
        teamAddView.addObject("team", new Team());
        return teamAddView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView teamAdd(@ModelAttribute Team team) {
        ModelAndView teamListView = new ModelAndView("/team/list");
        teamService.addTeam(team);
        List<Team> teams = teamService.getTeams();
        teamListView.addObject("teams", teams);
        String message = "Team was successfully added.";
        teamListView.addObject("message", message);
        return teamListView;
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable Integer id) {
        ModelAndView teamEditView = new ModelAndView("/team/edit");
        Team team=teamService.getTeam(id);
        teamEditView.addObject("team",team );
        teamEditView.addObject("paginaTitel", titelWijzig);
        return teamEditView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("team") Team team) {
        ModelAndView teamlistView = new ModelAndView("/team/list");
        teamService.updateTeam(team);
        List<Team> teams = teamService.getTeams();
        teamlistView.addObject("teams", teams);
        String message = "Team was successfully edited.";
        teamlistView.addObject("message", message);
        return teamlistView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteTeam(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("/team/list");
        teamService.deleteTeam(id);
        List<Team> teams = teamService.getTeams();
        modelAndView.addObject("teams", teams);
        String message = "Team was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }
    
    @RequestMapping(value = "/teamMembers/{id}", method = RequestMethod.GET)
    public ModelAndView teamMembers(@PathVariable Integer id) {
        ModelAndView teamMembersView = new ModelAndView("/team/listTeamMembers");
        Team team = teamService.getTeam(id);
        List<Member> teamMembers=team.getMembers();
        teamMembersView.addObject("team", team);
        teamMembersView.addObject("teamMembers", teamMembers);
        return teamMembersView;
    }
}

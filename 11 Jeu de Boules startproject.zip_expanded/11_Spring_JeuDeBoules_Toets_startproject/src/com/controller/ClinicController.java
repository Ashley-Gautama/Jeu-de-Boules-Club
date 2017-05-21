package com.controller;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.editor.ClinicEditor;
import com.model.Clinic;
import com.model.Team;
import com.service.ClinicService;
import com.service.TeamService;

@Controller
@RequestMapping(value = "/clinic")
public class ClinicController {

	@Autowired
	private ClinicService clinicService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private ClinicEditor clinicEditor;

	private static String titelNieuw = "Nieuw clinic";
	private static String titelWijzig = "Wijzig clinic";

	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		wdb.registerCustomEditor(List.class, this.clinicEditor);

	}

	@RequestMapping(value = "/cliniclist")
	public ModelAndView ledenlijst() {
		ModelAndView clinicListView = new ModelAndView("/clinic/list");
		List<Clinic> clinics = clinicService.getClinics();
		Collections.sort(clinics);
		clinicListView.addObject("clinics", clinics);
		return clinicListView;
	}
	
	@RequestMapping(value = "/clinicDeelnemers/{idclinic}/removeteam/{idteam}")
	public ModelAndView removeTeam(@PathVariable int idclinic, @PathVariable int idteam) {
		System.out.println("in methode remove team");
		ModelAndView clinicListView = new ModelAndView("/clinic/listClinicTeams");
		Clinic c=clinicService.getClinic(idclinic);
//		System.out.println("betreffende c "+c.getDeelnemers().get(0).getName()+c.getDeelnemers().get(1).getName());
		List<Team> deelnemers=c.getDeelnemers();
		System.out.println("lijst t van c "+deelnemers);

		Team t=teamService.getTeam(idteam);
		System.out.println("t delete "+t.getName()+t.getId());

		for (int i = 0; i < deelnemers.size(); i++) {
			if(deelnemers.get(i).getId()==idteam){
				deelnemers.remove(i);
			}
			
		}
//		System.out.println("is verwijderd "+ deelnemers.get(0).getName()+ deelnemers.get(1).getName());
		c.setDeelnemers(deelnemers);
		System.out.println(" nieuwe lijst t van c "+deelnemers);

		clinicService.updateClinic(c);
		Clinic clinic = clinicService.getClinic(idclinic);
		List<Team> clinicDeelnemers = clinic.getDeelnemers();
		List<Team> teams = teamService.getTeams();
		Collections.sort(clinicDeelnemers);
		clinicListView.addObject("teams", teams);	
		clinicListView.addObject("clinic", clinic);
		clinicListView.addObject("clinicDeelnemers", clinicDeelnemers);
		
		
		return clinicListView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView clinicAddPage() {
		ModelAndView clinicAddView = new ModelAndView("/clinic/add");
		clinicAddView.addObject("teams",teamService.getTeams());
		clinicAddView.addObject("paginaTitel", titelNieuw);
		clinicAddView.addObject("clinic", new Clinic());
		return clinicAddView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView clinicAdd(@ModelAttribute Clinic clinic) {
		ModelAndView clinicListView = new ModelAndView("/clinic/list");
		clinicService.addClinic(clinic);
		List<Clinic> clinics = clinicService.getClinics();
		clinicListView.addObject("clinics", clinics);
		String message = "Clinic was successfully added.";
		clinicListView.addObject("message", message);
		return clinicListView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Integer id) {
		System.out.println("in edit page");
		ModelAndView clinicEditView = new ModelAndView("/clinic/edit");
		Clinic clinic = clinicService.getClinic(id);
		boolean checked=false;
		clinicEditView.addObject("checked",checked);
		
		clinicEditView.addObject("clinic", clinic);
		clinicEditView.addObject("paginaTitel", titelWijzig);
		List<Team> teams = teamService.getTeams();
		clinicEditView.addObject("teams", teams);
		return clinicEditView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("clinic") Clinic clinic) {
		ModelAndView cliniclistView = new ModelAndView("/clinic/list");
		clinicService.updateClinic(clinic);
		List<Clinic> clinics = clinicService.getClinics();
		Collections.sort(clinics);
		cliniclistView.addObject("clinics", clinics);
		String message = "Clinic was successfully edited.";
		cliniclistView.addObject("message", message);
		return cliniclistView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteClinic(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/clinic/list");
		clinicService.deleteClinic(id);
		List<Clinic> clinics = clinicService.getClinics();
		modelAndView.addObject("clinics", clinics);
		String message = "Clinic was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/clinicDeelnemers/{id}", method = RequestMethod.GET)
	public ModelAndView clinicDeelnemers(@PathVariable Integer id) {
		ModelAndView clinicDeelnemersView = new ModelAndView("/clinic/listClinicTeams");
		Clinic clinic = clinicService.getClinic(id);
		List<Team> clinicDeelnemers = clinic.getDeelnemers();
		Collections.sort(clinicDeelnemers);
		List<Team> teams = teamService.getTeams();
		clinicDeelnemersView.addObject("teams", teams);	
		clinicDeelnemersView.addObject("clinic", clinic);
		clinicDeelnemersView.addObject("clinicDeelnemers", clinicDeelnemers);
		return clinicDeelnemersView;
	}
	
	@RequestMapping(value = "/clinicDeelnemers/{id}/editTeams", method = RequestMethod.POST)
	public ModelAndView editTeams(@ModelAttribute("clinic") Clinic clinic,@PathVariable Integer id) {
		System.out.println("in post editteams");
		ModelAndView cliniclistView = new ModelAndView("/clinic/listClinicTeams");
		clinicService.updateClinic(clinic);
		clinic = clinicService.getClinic(id);
		System.out.println(clinic.getDeelnemers());
		List<Team> clinicDeelnemers = clinic.getDeelnemers();
		List<Team> teams = teamService.getTeams();
		Collections.sort(clinicDeelnemers);
		cliniclistView.addObject("teams", teams);	
		cliniclistView.addObject("clinic", clinic);
		cliniclistView.addObject("clinicDeelnemers", clinicDeelnemers);
		return cliniclistView;
	}
}

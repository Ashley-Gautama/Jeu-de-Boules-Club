package com.editor;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Clinic;
import com.model.Team;
import com.service.TeamService;

@Component
public class ClinicEditor extends PropertyEditorSupport {

	@Autowired
	private TeamService teamService;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("in cliniceditor");
		System.out.println("original value checkbox value attribute: "+text);
		List<Team> a = new ArrayList<Team>();
		Clinic clinic = new Clinic();
		text = text.replaceAll(",", "");
		text = text.replaceAll(" ", "");

		System.out.println("removed spaces and kommas: "+text);

		if (text.contains("[") && text.contains("]")) {
			System.out.println(" String text contains brackets");
			System.out.println(text);
			text = text.substring(1);
			text = text.replaceAll("]", "");
			System.out.println("removed brackets from String text");
		}

		System.out.println(text);

		for (int i = 0; i < text.length(); i++) {
			if (text.substring(i + 1) != null) {
				Team t = this.teamService.getTeam(Integer.valueOf(text.substring(i, i + 1)));
				a.add(t);

			} else {
				Team t = this.teamService.getTeam(Integer.valueOf(text.substring(i)));
				a.add(t);
			}
		}
		clinic.setDeelnemers(a);
		System.out.println(clinic.getDeelnemers().get(0).getName());
		this.setValue(clinic.getDeelnemers());
	}

}

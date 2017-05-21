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

import com.dao.MemberDAO;
import com.model.Member;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	public void addMember(Member member) {
		memberDAO.addMember(member);
	}

	public void updateMember(Member member) {
		memberDAO.updateMember(member);
	}

	public Member getMember(int id) {
		return memberDAO.getMember(id);
	}

	public void deleteMember(int id) {
		memberDAO.deleteMember(id);
	}
	public void deleteFromTeam(int id) {
		memberDAO.deleteFromTeam(id);
	}

	public List<Member> getMembers() {
		return memberDAO.getMembers();
	}

	public void storeAllMembers(List<Member> members) {
		memberDAO.storeAllMembers(members);
	}
}

package com.aithinkers.gymmvc.service;

import java.util.List;

import com.aithinkers.gymmvc.model.Member;

public interface MemberService {

	List<Member> findAll();
	
	Member findById(int theId);
	
	void save(Member theMember);
	
	void deleteById(int theId);
	
}

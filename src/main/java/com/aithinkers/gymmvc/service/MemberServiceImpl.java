package com.aithinkers.gymmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aithinkers.gymmvc.dao.MemberRepository;
import com.aithinkers.gymmvc.model.Member;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberRepository memberRepository;
	
	@Autowired
	public MemberServiceImpl(MemberRepository theMemberRepository) {
		memberRepository = theMemberRepository;
	}
	
	@Override
	public List<Member> findAll() {
		return memberRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Member findById(int theId) {
		Optional<Member> result = memberRepository.findById(theId);
		
		Member theMember = null;
		
		if (result.isPresent()) {
			theMember = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theMember;
	}

	@Override
	public void save(Member theMember) {
		memberRepository.save(theMember);
	}

	@Override
	public void deleteById(int theId) {
		memberRepository.deleteById(theId);
	}

}
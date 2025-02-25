package com.aithinkers.gymmvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aithinkers.gymmvc.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	

    // add a method to sort by last name
    public List<Member> findAllByOrderByLastNameAsc();

}

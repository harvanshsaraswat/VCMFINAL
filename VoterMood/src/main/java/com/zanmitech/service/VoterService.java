package com.zanmitech.service;

import java.util.List;

import com.zanmitech.dto.Voter;


public interface VoterService {

	Voter findVoterById(int id);

	void saveVoter(Voter voter);

	void updateVoter(Voter voter);

	void deleteVoterById(int id);

	List<Voter> findAllVoters();

	void deleteAllVoters();

	public boolean isVoterAvailable(Voter voter);
}

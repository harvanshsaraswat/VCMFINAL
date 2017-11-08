package com.zanmitech.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.zanmitech.dto.Voter;
import com.zanmitech.dto.VoterAddress;

public class VoterServiceImpl implements  VoterService{
	
	private static AtomicInteger counter = new AtomicInteger();

	private static List<Voter> voters;
	
	static {
		voters = populateVoters();
	}

	@Override
	public Voter findVoterById(int id) {
		for (Voter voter : voters) {
			if (id == voter.getVoterId()) {
				return voter;
			}
		}
		return null;
	}

	private static List<Voter> populateVoters() {
		List<Voter> voters = new ArrayList<Voter>();
		voters.add(new Voter(true,counter.incrementAndGet(), "Dinga", new VoterAddress(222222,"Pinga")));
		voters.add(new Voter(true,counter.incrementAndGet(), "Peter", new VoterAddress(111111,"Delhi")));
		voters.add(new Voter(true,counter.incrementAndGet(), "Mohni", new VoterAddress(333333,"KkrPuram")));
		voters.add(new Voter(true,counter.incrementAndGet(), "Disi", new VoterAddress(444444,"DenukaPuram")));
		return voters;
	}

	@Override
	public void saveVoter(Voter voter) {
		voter.setVoterId(counter.incrementAndGet());
		voters.add(voter);
		
	}

	@Override
	public void updateVoter(Voter voter) {
		int index = voters.indexOf(voter);
		voters.set(index, voter);
		
	}

	@Override
	public void deleteVoterById(int id) {
		Iterator<Voter> it = voters.iterator();
		while (it.hasNext()) {
			Voter voter = it.next();
			if (id == voter.getVoterId()) {
				it.remove();
			}
		}
	}

	@Override
	public List<Voter> findAllVoters() {
		return voters;
	}

	@Override
	public void deleteAllVoters() {
		voters.clear();
		
	}

	@Override
	public boolean isVoterAvailable(Voter voter) {
		return findVoterById(voter.getVoterId()) != null ;
	}

}

package com.zanmitech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.zanmitech.dto.Voter;
import com.zanmitech.service.VoterService;

public class VoterController {

	
	@Autowired
	private VoterService voterService;
	
	
	
	@RequestMapping(value = "/voters", method = RequestMethod.GET)
	public ResponseEntity<List<Voter>> getVoters() {
		List<Voter> voters = voterService.findAllVoters();
		if (voters.isEmpty()) {
			return new ResponseEntity<List<Voter>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Voter>>(voters, HttpStatus.OK);
	}

	@RequestMapping(value = "/voter", method = RequestMethod.POST)
	public ResponseEntity<Void> saveProduct(@RequestBody Voter voter, UriComponentsBuilder ucBuilder) {
		if (voter == null || voter.getName() == null || "".equals(voter.getName())) {
			throw new RuntimeException("Voter Name is required field");
		}
		if (voterService.isVoterAvailable(voter)) {
			System.out.println("A voter with name " + voter.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		voterService.saveVoter(voter);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/voter/{voterId}").buildAndExpand(voter.getVoterId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/voter", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateProduct(@RequestBody Voter voter) {
		if (voter == null || voter.getName() == null || "".equals(voter.getName()) || voter.getVoterId() <= 0) {
			throw new RuntimeException("Voter Name, Id are required fields");
		}
		Voter currentVoter = voterService.findVoterById(voter.getVoterId());
		if (currentVoter == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		voterService.updateVoter(voter);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/voter/{voterId}", method = RequestMethod.GET)
	public ResponseEntity<Voter> getProductByid(@PathVariable int voterId) {
		Voter voter = voterService.findVoterById(voterId);
		if (voter == null) {
			return new ResponseEntity<Voter>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Voter>(voter, HttpStatus.OK);
	}

	@RequestMapping(value = "/voter/{voterId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProductByid(@PathVariable int voterId) {
		Voter currentVoter = voterService.findVoterById(voterId);

		if (currentVoter == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		voterService.deleteVoterById(voterId);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/voters", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProducts() {
		voterService.deleteAllVoters();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

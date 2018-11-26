package br.com.nomads.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.nomads.model.Programmer;
import br.com.nomads.services.ProgrammerService;

@RestController
public class ProgrammerController {

	@Autowired
	ProgrammerService service;

	@PostMapping("/programmer-string")
	public void addTopic(@RequestBody Programmer programmer) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		service.setProgrammerAsString(String.valueOf(programmer.getId()),
				objectMapper.writeValueAsString(programmer));
	}

	@GetMapping("/programmer-string/{id}")
	public String readString(@PathVariable String id) {
		return service.getProgrammerAsString(id);
	}
	
	@PostMapping("/programmer-list")
	public void addToProgrammerList(@RequestBody Programmer programmer) {
		service.AddToProgrammersList(programmer);
	}
	
	@GetMapping("/programmer-list")
	public List<Programmer>getProgrammerListMembers(){
		return service.getProgrammerListMembers();
	}
	
	@GetMapping("/programmer-list/count")
	public Long getProgrammerListCount() {
		return service.getProgrammerListCount();
	}
	
	@PostMapping("/programmer-set")
	public void addProgrammerSet(@RequestBody Programmer ... programmers) {
		service.AddSetProgrammerSet(programmers);
	}
	
	@GetMapping("/programmer-set")
	public Set<Programmer>getProgrammersSet(){
		return service.getProgrammersSetMembers();
	}

	@PostMapping("/programmer-set/member")
	public Boolean isSetMember(@RequestBody Programmer programmer) {
		return service.isSetMember(programmer);
	}
	
	@PostMapping("/programmer-hash")
	public void saveProgrammerHash(@RequestBody Programmer programmer) {
		service.saveProgrammerHash(programmer);
	}
	
	@PutMapping("/programmer-hash")
	public void updateProgrammerHash(@RequestBody Programmer programmer) {
		service.updateProgrammerHash(programmer);
	}
	
	@GetMapping("/programmer-hash")
	public Map<Integer, Programmer>findAllProgrammerHash(){
		return service.findAllProgrammerHash();
	}
	
	@GetMapping("programmer-hash/{id}")
	public Programmer findProgrammerInHash(@PathVariable int id) {
		return service.findPinHash(id);
	}
	
	@DeleteMapping("programmer-hash/{id}")
	public void deleteProgrammerInHash(@PathVariable int id) {
		service.deleteProgrammerHash(id);
	}
}

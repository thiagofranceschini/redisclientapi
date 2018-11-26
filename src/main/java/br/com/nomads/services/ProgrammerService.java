package br.com.nomads.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.nomads.model.Programmer;

public interface ProgrammerService {

	void setProgrammerAsString(String idKey, String programmer);
	
	String getProgrammerAsString(String idKey);
	
	//list
	void AddToProgrammersList(Programmer programmer);
	
	List<Programmer>getProgrammerListMembers();
	
	Long getProgrammerListCount();
	
	//set
	
	void AddSetProgrammerSet(Programmer ...programmers);
	
	Set<Programmer> getProgrammersSetMembers();
	
	Boolean isSetMember(Programmer programmer);
	
	//hash
	
	void saveProgrammerHash(Programmer programmer);
	
	void updateProgrammerHash(Programmer programmer);
	
	Map<Integer, Programmer>findAllProgrammerHash();
	
	Programmer findPinHash(int id);
	
	void deleteProgrammerHash(int id);
}

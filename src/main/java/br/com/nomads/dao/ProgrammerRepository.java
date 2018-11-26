package br.com.nomads.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.nomads.model.Programmer;

public interface ProgrammerRepository {

	// String
	void setProgrammerAsString(String idKey, String programmer);

	String getProgrammerAsString(String idKey);

	// list
	void AddToProgrammerlist(Programmer programmer);

	List<Programmer> getPrgorammersListMembers();

	Long getProgrammersListCount();

	// set
	void AddToProgrammersSet(Programmer ... programmers);
	
	Set<Programmer> getProgrammersSetMembers();
	
	Boolean isSetMember(Programmer programmer);
	
	//hash
	void saveHash(Programmer programmer);
	
	void updateHash(Programmer programmer);
	
	Map<Integer, Programmer>findAllHash();
	
	Programmer findInHash(int id);
	
	void deleteHash(int id);
}

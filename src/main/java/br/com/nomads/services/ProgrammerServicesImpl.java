package br.com.nomads.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nomads.dao.ProgrammerRepository;
import br.com.nomads.model.Programmer;

@Service
public class ProgrammerServicesImpl implements ProgrammerService{

	@Autowired
	private ProgrammerRepository repository;
	
	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
		repository.setProgrammerAsString(idKey, programmer);
	}

	@Override
	public String getProgrammerAsString(String idKey) {
		return repository.getProgrammerAsString(idKey);
	}

	@Override
	public void AddToProgrammersList(Programmer programmer) {
		repository.AddToProgrammerlist(programmer);
		
	}

	@Override
	public List<Programmer> getProgrammerListMembers() {
		return repository.getPrgorammersListMembers();
	}

	@Override
	public Long getProgrammerListCount() {
		return repository.getProgrammersListCount();
	}

	@Override
	public void AddSetProgrammerSet(Programmer... programmers) {
		repository.AddToProgrammersSet(programmers);
		
	}

	@Override
	public Set<Programmer> getProgrammersSetMembers() {
		return repository.getProgrammersSetMembers();
	}

	@Override
	public Boolean isSetMember(Programmer programmer) {
		return repository.isSetMember(programmer);
	}

	@Override
	public void saveProgrammerHash(Programmer programmer) {
		repository.saveHash(programmer);
	}

	@Override
	public void updateProgrammerHash(Programmer programmer) {
		repository.updateHash(programmer);
	}

	@Override
	public Map<Integer, Programmer> findAllProgrammerHash() {
		return repository.findAllHash();
	}

	@Override
	public Programmer findPinHash(int id) {
		return repository.findInHash(id);
	}

	@Override
	public void deleteProgrammerHash(int id) {
		repository.deleteHash(id);
		
	}

}

package br.com.nomads.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import br.com.nomads.model.Programmer;

@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository {

	public static final String REDIS_LIST_KEY = "ProgrammerList";
	public static final String REDIS_SET_KEY = "ProgrammerSet";
	public static final String REDIS_HASH_KEY = "ProgrammerHash";

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	@Qualifier("listOperations")
	private ListOperations<String, Programmer> listOps;

	@Autowired
	@Qualifier("setOperations")
	private SetOperations<String, Programmer> setOps;
	
	@Autowired
	@Qualifier("hashOperations")
	private HashOperations<String, Integer, Programmer> hashOps;

	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
		redisTemplate.opsForValue().set(idKey, programmer);
		redisTemplate.expire(idKey, 10, TimeUnit.SECONDS);

	}

	@Override
	public String getProgrammerAsString(String idKey) {
		return (String) redisTemplate.opsForValue().get(idKey);
	}

	/// *******************list****************************
	@Override
	public void AddToProgrammerlist(Programmer programmer) {
		listOps.leftPush(REDIS_LIST_KEY, programmer);
	}

	@Override
	public List<Programmer> getPrgorammersListMembers() {
		return listOps.range(REDIS_LIST_KEY, 0, -1);
	}

	@Override
	public Long getProgrammersListCount() {
		return listOps.size(REDIS_LIST_KEY);
	}

	//// *******************set*************************
	@Override
	public void AddToProgrammersSet(Programmer... programmers) {
		setOps.add(REDIS_SET_KEY, programmers);

	}

	@Override
	public Set<Programmer> getProgrammersSetMembers() {
		return setOps.members(REDIS_SET_KEY);
	}

	@Override
	public Boolean isSetMember(Programmer programmer) {
		return setOps.isMember(REDIS_SET_KEY, programmer);
	}

	// ********************HASH****************************
	@Override
	public void saveHash(Programmer programmer) {
		hashOps.put(REDIS_HASH_KEY, programmer.getId(), programmer);

	}

	@Override
	public void updateHash(Programmer programmer) {
		hashOps.put(REDIS_HASH_KEY, programmer.getId(), programmer);
	}

	@Override
	public Map<Integer, Programmer> findAllHash() {
		return hashOps.entries(REDIS_HASH_KEY);
	}

	@Override
	public Programmer findInHash(int id) {
		return hashOps.get(REDIS_HASH_KEY, id);
	}

	@Override
	public void deleteHash(int id) {
		hashOps.delete(REDIS_HASH_KEY, id);
	}

}

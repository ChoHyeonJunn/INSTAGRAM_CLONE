package com.instagram.clone.model.dao.dm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.instagram.clone.model.vo.Test;

@Repository
public class MongoDmDaoImpl implements MongoDmDao {

	@Autowired
	private MongoTemplate mongo;

	public List<Test> findAll() {
		
		return mongo.findAll(Test.class, "INSTAGRAM");
	}
}

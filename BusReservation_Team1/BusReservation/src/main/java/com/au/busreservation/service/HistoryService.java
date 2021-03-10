package com.au.busreservation.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.au.busreservation.model.History;
import com.au.busreservation.repository.HistoryRepository;

@Service
public class HistoryService 
{
	@Autowired
	HistoryRepository historyrepo;

	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<History> getHistory(int userId) 
	{
		return historyrepo.findAllByUserId(userId);
	}

	public void updatinghistory(int id, String dateOfJourney ) 
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(id)) ;
		query.addCriteria(Criteria.where("dateOfJourney").is(dateOfJourney)) ;
		Update update = new Update();
		update.set("status","Cancelled");
		mongoTemplate.updateMulti(query, update, History.class);
	}

}

package com.au.busreservation.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.au.busreservation.model.History;

@Repository

public interface HistoryRepository extends MongoRepository<History, Integer>{

	List<History> findAllByUserId(int userId);

}

package com.au.busreservation.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.busreservation.model.History;
import com.au.busreservation.service.HistoryService;

@RestController
@RequestMapping("/api/History")
public class HistoryController 
{
	@Autowired
	HistoryService historyService;
	
	@GetMapping("/history")
	public List<History> getHistory(@RequestParam (name = "userId") int userId)
	{
		return historyService.getHistory(userId);
	}

}

package com.worker.service;

import java.util.List;

import com.worker.entity.worker;

public interface workerService {
 
	public String delete(int id);
	 
	public worker getbyid(int id );
	
	public String upsert(worker worker);
	
	public List<worker> getall();
	
}

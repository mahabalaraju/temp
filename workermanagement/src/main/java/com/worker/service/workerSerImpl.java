package com.worker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worker.entity.worker;
import com.worker.repository.workerRepository;
@Service
public class workerSerImpl implements workerService {
	@Autowired
	private workerRepository workrepo;

	@Override
	public String delete(int id) {
		if (workrepo.existsById(id)) {
			workrepo.deleteById(id);
			return "success";
		} else
			return "record not found";
	}

	@Override
	public worker getbyid(int id) {
		Optional<worker> getbyid = workrepo.findById(id);
		if (getbyid.isPresent()) {
			return getbyid.get();
		} else
			return null;
	}

	@Override
	public String upsert(worker worker) {
		workrepo.save(worker);
		return null;
	}

	@Override
	public List<worker> getall() {
	List<worker> getall=workrepo.findAll();	
		return getall;
	}

}

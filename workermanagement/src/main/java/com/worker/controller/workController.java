package com.worker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.worker.entity.worker;
import com.worker.entity.worker.*;
import com.worker.repository.workerRepository;
import com.worker.service.workerSerImpl;
import com.worker.service.workerService;

@Controller
public class workController {
@Autowired
private workerRepository workrepo;
	
	@Autowired
	private workerService worker;
	
//	@GetMapping("/worker")
//	public ResponseEntity<List<worker>> getall() {
//		List<worker> getall= worker.getall();
//		return new ResponseEntity<List<worker>>(getall,HttpStatus.OK);
//	}
//	
//	@GetMapping("/worker/{id}")
//	public worker getbyid(@PathVariable int id){
//		worker getbyid=worker.getbyid(id);
//		return getbyid;
//	}
//	

//	
//	@PutMapping("/worker/{id}")
//	public ResponseEntity<String> insert(@RequestBody worker work){
//		String insert=worker.upsert(work);
//		return new ResponseEntity<String>(insert, HttpStatus.OK);
//	}
//	

	
	
	@GetMapping({"/","/list","/showemployee"})
	public ModelAndView get() {
		List<worker> getal=worker.getall();
		return new ModelAndView("NewFile","user",getal);
	}
	
	@GetMapping("/addworkers")
	public ModelAndView getal() {
		worker w=new worker();
	     return new ModelAndView("NewFile1","worker",w);
	}
	
	@PostMapping("/saveworker")
	public String saveworker(@ModelAttribute worker user) {
		worker.upsert(user);
		return "redirect:/list";
	}
	
//	@PostMapping("/worker")
//	public ResponseEntity<String> update(@RequestBody worker work) {
//		String saveworker = worker.upsert(work);
//		return new ResponseEntity<String>(saveworker,HttpStatus.CREATED);
//	}
	
	@GetMapping("/showupdatedform")
	public ModelAndView showupdateform(@RequestParam int workerId) {
		ModelAndView mv=new ModelAndView();
		worker w=workrepo.findById(workerId).get();
		return new ModelAndView("NewFile1", "worker", w);
	}
	
	
//	@DeleteMapping("/deleteWorker")
//	public String deletebyid(@PathVariable int id)
//	{
//		worker .delete(id);
//		return "redirect:/list";
//	}
//	
	
	@GetMapping("/deleteWorker")
	public String deletewoer(@RequestParam int workerId) {
		workrepo.deleteById(workerId);
		return
			"redirect:/list";
	}
	
	
}

















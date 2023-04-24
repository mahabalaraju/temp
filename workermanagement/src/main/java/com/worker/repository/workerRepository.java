package com.worker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.worker.entity.worker;
@Repository
public interface workerRepository  extends JpaRepository<worker, Integer>{

}

package com.kaush.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kaush.pma.dto.ChartData;
import com.kaush.pma.entities.Project;

// using these crud repository we can add data, delete data,save etc goto this class and check
public interface ProjectRepository extends CrudRepository<Project, Long>{

	// you can create custom queries according to your object instead of predefined methods of CrudRepository
	
	// findAll method we get from extended CrudRepository interface it returns iterable  object therefore we customize it 
	// in our ProjectRepo interface.
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery= true, value="SELECT stage as label, COUNT(*) as value FROM project " + 
			"GROUP BY stage")
	public List<ChartData>  getProjectStatus();
}

package com.kaush.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kaush.pma.dto.ChartData;
import com.kaush.pma.dto.TimeLineChartData;
import com.kaush.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{

	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery= true, value="SELECT stage as label, COUNT(*) as value FROM project " + 
			"GROUP BY stage")
	public List<ChartData>  getProjectStatus();
	
	@Query(nativeQuery= true, value="SELECT name as projectName ,start_date as startDate, end_date as endDate FROM project where start_date is not null")
	public List<TimeLineChartData> getTimeData();
}

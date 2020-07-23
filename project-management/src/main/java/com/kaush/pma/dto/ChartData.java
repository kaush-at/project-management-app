package com.kaush.pma.dto;

public interface ChartData {

	public String getLabel(); 
	public long getValue();
	
	// these should exactly same as db table we fetch using query or assign table value in query
	//SELECT stage as label, COUNT(*) as value FROM project GROUP BY stage")
	 //label
	//value
}

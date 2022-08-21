package com.censusanalyzer.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensuscsv {
	
	@CsvBindByName(column="State",required=true)
	public String state;
	
	@CsvBindByName(column="Population",required=true)
	public int population;
	
	@CsvBindByName(column="AreaInSqKm",required=true)
	public int areaInSqKm;
	
	@Override
	public String toString() {
		return "IndiaCensuscsv{" +
				"state=" +state+ '\'' +
				",population=" +population+ '\''+
				",AreaInSqKm=" +areaInSqKm+ '\''+
				'}';
	}

}

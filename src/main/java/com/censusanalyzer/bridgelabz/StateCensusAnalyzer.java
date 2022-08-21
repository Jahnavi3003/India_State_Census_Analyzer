package com.censusanalyzer.bridgelabz;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyzer {
	public int loadIndiaCensusdata(String CSVFilePath) throws CensusAnalyzerException{
		try(Reader reader=Files.newBufferedReader(Paths.get(CSVFilePath));){
			CsvToBeanBuilder<IndiaCensuscsv> csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaCensuscsv.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaCensuscsv> csvToBean=csvToBeanBuilder.build();
			final Iterator<IndiaCensuscsv> censuscsvIterator=csvToBean.iterator();
			Iterable<IndiaCensuscsv> csvIterable=new Iterable<IndiaCensuscsv>() {
				@Override
				public Iterator<IndiaCensuscsv> iterator() {
					return censuscsvIterator;
				}
			};
			int numOfEnteries=(int) StreamSupport.stream(csvIterable.spliterator(), false).count();
			return numOfEnteries;
		}catch(IOException e) {
			throw new CensusAnalyzerException();
		}catch(RuntimeException e) {
			throw new CensusAnalyzerException();
		}
}

}

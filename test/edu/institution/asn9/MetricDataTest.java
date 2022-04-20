package edu.institution.asn9;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MetricDataTest {
	
	String PATH = System.getProperty("user.home") + File.separator + "Java2" + File.separator;
	String FILE_NAME = "asn9-numbers.txt";
	String fullPath = PATH + FILE_NAME;
	SortAlgorithmMetrics metrics = new SortAlgorithmMetrics();
	List<MetricData> data = metrics.retrieveMetrics(fullPath);
	
	@Test
	void testMetricDataExecutionTime() {
		
		assertNotEquals(0, data.get(0).getExecutionTime());
	}
	
	@Test 
	void testMetricDataContainsAlgorithm() {
		
		boolean containsAlgorithm = false;
		
		for (MetricData metricData : data) {
			if(metricData.getSortAlgorithm().equals(SortAlgorithm.BUBBLE_SORT)) {
				containsAlgorithm = true;
			}
		}
		
		assertEquals(true,containsAlgorithm );
	}
	
	@Test 
	void testMetricDataGetsTimeComplexity(){
		assertNotNull(data.get(0).getTimeComplexity());
	}
	

}

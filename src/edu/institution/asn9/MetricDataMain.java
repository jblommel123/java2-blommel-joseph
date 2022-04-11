package edu.institution.asn9;

import java.io.File;
import java.util.List;

public class MetricDataMain {

	public static void main(String[] args) {
		String PATH = System.getProperty("user.home") + File.separator + "Java2" + File.separator;
		String FILE_NAME = "asn9-numbers.txt";
		String fullPath = PATH + FILE_NAME;
		SortAlgorithmMetrics metrics = new SortAlgorithmMetrics();
		List<MetricData> metricData = metrics.retrieveMetrics(fullPath);
		
		for (MetricData data : metricData) {
			System.out.println(data.toString());
		}
		
	}

}

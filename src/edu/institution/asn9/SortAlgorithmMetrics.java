package edu.institution.asn9;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SortAlgorithmMetrics  {
	public List<MetricData> retrieveMetrics(String filePath) {
		List<MetricData> listOfResults = new ArrayList<MetricData>();
		File integerFile = new File(filePath);
		List<Integer> numbers = null; // assume this contains the list of 80000 Integers.
		Integer[] template = {}; // tells toArray what type of Array to generate
		Integer[] list = numbers.toArray(template);
		MetricData insertionSortData = new MetricData(SortAlgorithm.INSERTION_SORT);
		MetricData bubbleSortData = new MetricData(SortAlgorithm.BUBBLE_SORT);
		MetricData heapSortData = new MetricData(SortAlgorithm.HEAP_SORT);
		MetricData mergeSortData = new MetricData(SortAlgorithm.MERGE_SORT);
		MetricData quickSortData = new MetricData(SortAlgorithm.QUICK_SORT);
		
		LocalTime startTime = LocalTime.now();
		
		LocalTime endTime = LocalTime.now();
		return listOfResults;
	 }
}

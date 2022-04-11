package edu.institution.asn9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortAlgorithmMetrics  {
	public List<MetricData> retrieveMetrics(String filePath) {
		List<MetricData> listOfResults = new ArrayList<MetricData>();
		File integerFile = new File(filePath);
		List<Integer> numbers = new ArrayList<Integer>();
		try {
			try (Scanner scanner = new Scanner(integerFile)) {
				while (scanner.hasNextInt()) {
					numbers.add(scanner.nextInt());
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		// assume this contains the list of 80000 Integers.
		
		// tells toArray what type of Array to generate
		Integer[] template = {}; 
		Integer[] bubbleSortlist = numbers.toArray(template);
		Integer[] insertionSortList = numbers.toArray(template);
		Integer[] heapSortList = numbers.toArray(template);
		Integer[] mergeSortList = numbers.toArray(template);
		Integer[] quickSortList = numbers.toArray(template); 
		
		//Create each data object
		MetricData insertionSortData = new MetricData(SortAlgorithm.INSERTION_SORT);
		MetricData bubbleSortData = new MetricData(SortAlgorithm.BUBBLE_SORT);
		MetricData heapSortData = new MetricData(SortAlgorithm.HEAP_SORT);
		MetricData mergeSortData = new MetricData(SortAlgorithm.MERGE_SORT);
		MetricData quickSortData = new MetricData(SortAlgorithm.QUICK_SORT);
		
		//time sort 
		LocalTime startTimeInsertionSort = LocalTime.now();
		InsertionSort.insertionSort(insertionSortList);
		LocalTime endTimeInsertionSort = LocalTime.now();
		long elapsedMilliseconds = Duration.between(startTimeInsertionSort,endTimeInsertionSort).toMillis();
		insertionSortData.setExecutionTime(elapsedMilliseconds);
		insertionSortData.setTimeComplexity(TimeComplexity.QUADRATIC);
		
		
		//bubble sort
		LocalTime startTimeBubbleSort = LocalTime.now();
		BubbleSort.bubbleSort(bubbleSortlist);
		LocalTime endTimeBubbleSort = LocalTime.now();
		
		elapsedMilliseconds = Duration.between(startTimeBubbleSort,endTimeBubbleSort).toMillis();
		bubbleSortData.setExecutionTime(elapsedMilliseconds);
		bubbleSortData.setTimeComplexity(TimeComplexity.QUADRATIC);
		
		//heap sort
		LocalTime startTimeHeapSort = LocalTime.now();
		HeapSort.heapSort(heapSortList);
		LocalTime endTimeHeapSort = LocalTime.now();
		
		elapsedMilliseconds = Duration.between(startTimeHeapSort, endTimeHeapSort).toMillis();
		heapSortData.setExecutionTime(elapsedMilliseconds);
		heapSortData.setTimeComplexity(TimeComplexity.LOGARITHMIC);
		
		//merge sort
		LocalTime startTimeMergeSort= LocalTime.now();
		MergeSort.mergeSort(mergeSortList);
		LocalTime endTimeMergeSort = LocalTime.now();
		elapsedMilliseconds = Duration.between(startTimeMergeSort, endTimeMergeSort).toMillis();
		mergeSortData.setExecutionTime(elapsedMilliseconds);
		mergeSortData.setTimeComplexity(TimeComplexity.LOGARITHMIC);
		
		//quick sort
		LocalTime startTimeQuickSort = LocalTime.now();
		QuickSort.quickSort(quickSortList);
		LocalTime endTimeQuickSort = LocalTime.now();
		elapsedMilliseconds = Duration.between(startTimeQuickSort, endTimeQuickSort).toMillis();
		quickSortData.setExecutionTime(elapsedMilliseconds);
		quickSortData.setTimeComplexity(TimeComplexity.LOGARITHMIC);
		
		
		//populate list of results
		listOfResults.add(insertionSortData);
		listOfResults.add(mergeSortData);
		listOfResults.add(heapSortData);
		listOfResults.add(quickSortData);
		listOfResults.add(bubbleSortData);
		
		Collections.sort(listOfResults);
		//return the list
		return listOfResults;
	 }
}

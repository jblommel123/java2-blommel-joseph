package edu.institution.asn9;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SortAlgorithmMetrics  {
	public List<MetricData> retrieveMetrics(String filePath) {
		List<MetricData> listOfResults = new ArrayList<MetricData>();
		File integerFile = new File(filePath);
		
		
		List<Integer> numbers = null; // assume this contains the list of 80000 Integers.
		if(integerFile.exists()) {
			try(FileInputStream fis = new FileInputStream(integerFile);
					ObjectInputStream ois = new ObjectInputStream(fis)){
					numbers = (List<Integer>)ois.readObject();
			} catch (Exception e) {
				e.toString();
			}
		}
		Integer[] template = {}; // tells toArray what type of Array to generate
		Integer[] bubbleSortlist = numbers.toArray(template);
		Integer[] insertionSortList = numbers.toArray(template);
		Integer[] heapSortList = numbers.toArray(template);
		Integer[] mergeSortList = numbers.toArray(template);
		Integer[] quickSortList = numbers.toArray(template); 
		
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
		insertionSortData.setTimeComplexity(TimeComplexity.QUADRATIC);
		
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
		quickSortData.setTimeComplexity(TimeComplexity.QUADRATIC);
		
		
		//populate list of results
		listOfResults.add(insertionSortData);
		listOfResults.add(mergeSortData);
		listOfResults.add(heapSortData);
		listOfResults.add(quickSortData);
		listOfResults.add(bubbleSortData);
		
		//return the list
		return listOfResults;
	 }
}

package edu.institution.asn9;

import java.util.Objects;

public class MetricData implements Comparable<MetricData> {
		//The sort algorithm for the data
		private SortAlgorithm sortAlgorithm;
		//the time complexity for the sort algorithm
		private TimeComplexity timeComplexity;
		//The time the algorithm took1yt
		private long executionTime;
		
		
		public MetricData(SortAlgorithm sortAlgorithm) {
			super();
			this.sortAlgorithm = sortAlgorithm;
		}
		@Override
		public int hashCode() {
			return Objects.hash(sortAlgorithm);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MetricData other = (MetricData) obj;
			return sortAlgorithm == other.sortAlgorithm;
		}
		public SortAlgorithm getSortAlgorithm() {
			return sortAlgorithm;
		}
		public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
			this.sortAlgorithm = sortAlgorithm;
		}
		public TimeComplexity getTimeComplexity() {
			return timeComplexity;
		}
		public void setTimeComplexity(TimeComplexity timeComplexity) {
			this.timeComplexity = timeComplexity;
		}
		public long getExecutionTime() {
			return executionTime;
		}
		public void setExecutionTime(long executionTime) {
			this.executionTime = executionTime;
		}
	
	@Override
	public int compareTo(MetricData o) {
		return this.getExecutionTime() == o.getExecutionTime() ? 0: this.getExecutionTime() > o.getExecutionTime() ? 1 : -1;
	}

}

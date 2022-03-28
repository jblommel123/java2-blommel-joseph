package edu.institution.midterm;

import java.util.Objects;

public class BomEntry {
	private String partNumber;
	private int quantity;
	public BomEntry(String partNumberString, int quantity) {
		super();
		this.partNumber = partNumberString;
		this.quantity = quantity;
	}
	public String getPartNumberString() {
		return partNumber;
	}
	public void setPartNumberString(String partNumberString) {
		this.partNumber = partNumberString;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "BomEntry [partNumberString=" + partNumber + ", quantity=" + quantity + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(partNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BomEntry other = (BomEntry) obj;
		return Objects.equals(partNumber, other.partNumber);
	}
	
	
}

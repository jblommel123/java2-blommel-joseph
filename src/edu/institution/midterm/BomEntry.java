package edu.institution.midterm;

import java.util.Objects;

public class BomEntry {
	private String partNumberString;
	private int quantity;
	public String getPartNumberString() {
		return partNumberString;
	}
	public void setPartNumberString(String partNumberString) {
		this.partNumberString = partNumberString;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "BomEntry [partNumberString=" + partNumberString + ", quantity=" + quantity + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(partNumberString);
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
		return Objects.equals(partNumberString, other.partNumberString);
	}
	
	
}

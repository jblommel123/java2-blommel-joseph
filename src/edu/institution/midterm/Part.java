package edu.institution.midterm;

import java.util.List;
import java.util.Objects;

public class Part {
	private String partNumber;
	private String name;
	private String partType;
	private float price;
	private List<BomEntry> billOfMaterial;
	
	public Part(String partNumber, String name, String partType, float price, List<BomEntry> billOfMaterial) {
		super();
		this.partNumber = partNumber;
		this.name = name;
		this.partType = partType;
		this.price = price;
		this.billOfMaterial = billOfMaterial;
	}
	//getters and setters
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPartType() {
		return partType;
	}
	public void setPartType(String partType) {
		this.partType = partType;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public List<BomEntry> getBillOfMaterial() {
		return billOfMaterial;
	}
	public void setBillOfMaterial(List<BomEntry> billOfMaterial) {
		this.billOfMaterial = billOfMaterial;
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
		Part other = (Part) obj;
		return Objects.equals(partNumber, other.partNumber);
	}
	
}

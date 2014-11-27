package com.px1.horizonairways.entity;

public class AircraftLayout {

	private int FirstClassRows;
	private int BusinessClassRows;
	private int EconomyClassRows;
	
	private int[] FirstClassSeatArrangement;
	private int[] BusinessClassSeatArrangement;
	private int[] EconomyClassSeatArrangement;
	
	public AircraftLayout(int firstClassRows, int businessClassRows,
			int economyClassRows, int[] firstClassSeatArrangement,
			int[] businessClassSeatArrangement,
			int[] economyClassSeatArrangement) {
		super();
		FirstClassRows = firstClassRows;
		BusinessClassRows = businessClassRows;
		EconomyClassRows = economyClassRows;
		FirstClassSeatArrangement = firstClassSeatArrangement;
		BusinessClassSeatArrangement = businessClassSeatArrangement;
		EconomyClassSeatArrangement = economyClassSeatArrangement;
	}

	public AircraftLayout() {
	}

	public int getFirstClassRows() {
		return FirstClassRows;
	}

	public void setFirstClassRows(int firstClassRows) {
		FirstClassRows = firstClassRows;
	}

	public int getBusinessClassRows() {
		return BusinessClassRows;
	}

	public void setBusinessClassRows(int businessClassRows) {
		BusinessClassRows = businessClassRows;
	}

	public int getEconomyClassRows() {
		return EconomyClassRows;
	}

	public void setEconomyClassRows(int economyClassRows) {
		EconomyClassRows = economyClassRows;
	}

	public int[] getFirstClassSeatArrangement() {
		return FirstClassSeatArrangement;
	}

	public void setFirstClassSeatArrangement(String firstClassSeatArrangement) { 
		String[] s = firstClassSeatArrangement.split(":");
		int[] newArray = new int[s.length];
		for(int i=0;i<s.length;i++ ){
			newArray[i] = Integer.parseInt(s[i]);
		}
		this.FirstClassSeatArrangement = newArray;
	}

	public int[] getBusinessClassSeatArrangement() {
		return BusinessClassSeatArrangement;
	}

	public void setBusinessClassSeatArrangement(String businessClassSeatArrangement) {
		String[] s = businessClassSeatArrangement.split(":");
		int[] newArray = new int[s.length];
		for(int i=0;i<s.length;i++ ){
			newArray[i] = Integer.parseInt(s[i]);
		}
		this.BusinessClassSeatArrangement = newArray;
	}

	public int[] getEconomyClassSeatArrangement() {
		return EconomyClassSeatArrangement;
	}

	public void setEconomyClassSeatArrangement(String economyClassSeatArrangement) {
		String[] s = economyClassSeatArrangement.split(":");
		int[] newArray = new int[s.length];
		for(int i=0;i<s.length;i++ ){
			newArray[i] = Integer.parseInt(s[i]);
		}
		this.EconomyClassSeatArrangement = newArray;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("FirstClassRows: ").append(this.FirstClassRows).append("\n");
		str.append("BusinessClassRows: ").append(this.BusinessClassRows).append("\n");
		str.append("EconomyClassRows): ").append(this.EconomyClassRows).append("\n");
		str.append("FirstClassSeatArrangement: ").append(this.FirstClassSeatArrangement).append("\n");
		str.append("BusinessClassSeatArrangement: ").append(this.BusinessClassSeatArrangement).append("\n");
		str.append("EconomyClassSeatArrangement: ").append(this.EconomyClassSeatArrangement).append("\n");
		return str.toString();
	}
	
	
	
	
}

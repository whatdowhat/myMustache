package com.example.demo.domain.repository;

public class DataTable {

	private int iDisplayStart;
	private int iDisplayLength;
	private String sSearch="";
	
	public String getsSearch() {
		return sSearch;
	}
	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}
	public int getiDisplayStart() {
		return iDisplayStart;
	}
	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}
	public int getiDisplayLength() {
		return iDisplayLength;
	}
	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	@Override
	public String toString() {
		return "DataTable [iDisplayStart=" + iDisplayStart + ", iDisplayLength=" + iDisplayLength + ", sSearch="
				+ sSearch + "]";
	}

	
	
}

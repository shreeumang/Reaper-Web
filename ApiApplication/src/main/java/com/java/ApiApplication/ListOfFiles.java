package com.java.ApiApplication;

public class ListOfFiles {
	
	private Integer index;
	private String fname;
	private String extension;
	
	
	public ListOfFiles(Integer index, String fname, String extension) {
		super();
		this.index = index;
		this.fname = fname;
		this.extension = extension;
	}
	public ListOfFiles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	@Override
	public String toString() {
		return "ListOfFiles [index=" + index + ", fname=" + fname + ", extension=" + extension + "]";
	}

}

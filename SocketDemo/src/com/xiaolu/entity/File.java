package com.xiaolu.entity;

import java.io.Serializable;

public class File implements Serializable{
	/*
	 * 文件内容以byte形式进行传递
	 */
	private static final long serialVersionUID = 1L;
	private int fid;
	private String fname;
	private byte[] fcontent;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public byte[] getFcontent() {
		return fcontent;
	}
	public void setFcontent(byte[] fcontent) {
		this.fcontent = fcontent;
	}
	public File() {
		
	} 
	public File(String fname, byte[] fcontent) {
		this.fname = fname;
		this.fcontent = fcontent;
	}
	public File(int fid, String fname, byte[] fcontent) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fcontent = fcontent;
	}
	
}

package com.usst.domain;

public class Dvd {
	private String dname;
	private String dintroduce;
	private String dactor;
	private String durl;

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDintroduce() {
		return dintroduce;
	}

	public void setDintroduce(String dintroduce) {
		this.dintroduce = dintroduce;
	}

	public String getDactor() {
		return dactor;
	}

	public void setDactor(String dactor) {
		this.dactor = dactor;
	}

	public String getDurl() {
		return durl;
	}

	public void setDurl(String durl) {
		this.durl = durl;
	}

	public Dvd(String dname, String dintroduce, String dactor, String durl) {
		super();
		this.dname = dname;
		this.dintroduce = dintroduce;
		this.dactor = dactor;
		this.durl = durl;
	}

	@Override
	public String toString() {
		return "Dvd [dname=" + dname + ", dintroduce=" + dintroduce
				+ ", dactor=" + dactor + ", durl=" + durl + "]";
	}

	
}

package com.capgemini.xcorps.entity;

public class Theatre {

	private String theatreId;

	private String theatreName;

	private String screen;

	public Theatre(String theatreName) {
		super();
		this.theatreName = theatreName;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", screen=" + screen + "]";
	}

}

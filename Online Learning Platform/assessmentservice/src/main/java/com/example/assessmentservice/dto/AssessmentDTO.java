package com.example.assessmentservice.dto;

public class AssessmentDTO {
    private String title;
    private String description;
    private int maxMarks;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}
	@Override
	public String toString() {
		return "AssessmentDTO [title=" + title + ", description=" + description + ", maxMarks=" + maxMarks + "]";
	}

    // getters and setters
    
}

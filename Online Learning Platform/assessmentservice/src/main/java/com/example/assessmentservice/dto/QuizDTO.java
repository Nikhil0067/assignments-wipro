package com.example.assessmentservice.dto;

import java.util.List;

public class QuizDTO {
    private String title;
    private String description;
    private List<String> questions;
    private int totalMarks;
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
	public List<String> getQuestions() {
		return questions;
	}
	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Override
	public String toString() {
		return "QuizDTO [title=" + title + ", description=" + description + ", questions=" + questions + ", totalMarks="
				+ totalMarks + "]";
	}

    
}

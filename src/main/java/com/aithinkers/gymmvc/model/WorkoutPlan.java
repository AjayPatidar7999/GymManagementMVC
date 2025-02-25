package com.aithinkers.gymmvc.model;

import jakarta.persistence.*;

@Entity
@Table(name="workout_plan")
public class WorkoutPlan {

	// Define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="description")
	private String description;

	@Column(name="duration_weeks")
	private int durationWeeks;

	@Column(name="sessions_per_week")
	private int sessionsPerWeek;

	@Column(name="goal")
	private String goal; // e.g., Muscle Gain, Fat Loss, Strength

	@Column(name="difficulty_level")
	private String difficultyLevel; // Beginner, Intermediate, Advanced

	@Column(name="rest_between_sets")
	private int restBetweenSets; // Rest time in seconds

	// Default constructor
	public WorkoutPlan() {
	}

	// Parameterized constructor
	public WorkoutPlan(String firstNameame,String lastName, String description, int durationWeeks, int sessionsPerWeek, String goal, String difficultyLevel, int restBetweenSets) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.durationWeeks = durationWeeks;
		this.sessionsPerWeek = sessionsPerWeek;
		this.goal = goal;
		this.difficultyLevel = difficultyLevel;
		this.restBetweenSets = restBetweenSets;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationWeeks() {
		return durationWeeks;
	}

	public void setDurationWeeks(int durationWeeks) {
		this.durationWeeks = durationWeeks;
	}

	public int getSessionsPerWeek() {
		return sessionsPerWeek;
	}

	public void setSessionsPerWeek(int sessionsPerWeek) {
		this.sessionsPerWeek = sessionsPerWeek;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public int getRestBetweenSets() {
		return restBetweenSets;
	}

	public void setRestBetweenSets(int restBetweenSets) {
		this.restBetweenSets = restBetweenSets;
	}

	@Override
	public String toString() {
		return "WorkoutPlan [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", description="
				+ description + ", durationWeeks=" + durationWeeks + ", sessionsPerWeek=" + sessionsPerWeek + ", goal="
				+ goal + ", difficultyLevel=" + difficultyLevel + ", restBetweenSets=" + restBetweenSets + "]";
	}

	// toString method
	
}

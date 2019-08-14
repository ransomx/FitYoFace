package com.example.fityoface.model;

import java.util.List;

public class Workout {

    public String name;

    private List<WorkoutExercise> exerciseList;

    public List<WorkoutExercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<WorkoutExercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public Workout(List<WorkoutExercise> exerciseList) {
        this.exerciseList = exerciseList;
    }
}

package com.example.fityoface.model;

import java.util.Date;

public class WorkoutTime {
    private Workout workout;
    private Date workoutTime;

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Date getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(Date workoutTime) {
        this.workoutTime = workoutTime;
    }

    public WorkoutTime(Workout workout, Date workoutTime) {
        this.workout = workout;
        this.workoutTime = workoutTime;
    }
}

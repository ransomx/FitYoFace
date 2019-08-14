package com.example.fityoface;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fityoface.model.Workout;
import com.google.gson.Gson;

public class WorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        Gson gson = new Gson();
        Workout ob = gson.fromJson(getIntent().getStringExtra("CurrentWorkout"), Workout.class);
    }
}

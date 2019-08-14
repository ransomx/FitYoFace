package com.example.fityoface;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;
import androidx.fragment.app.DialogFragment;
import com.example.fityoface.model.Workout;
import com.example.fityoface.model.WorkoutExercise;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.*;

public class CalendarActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    public Map<String,Workout> workoutNameObject;

    public Map<String, Workout> getWorkoutNameObject() {
        if(workoutNameObject == null){
            workoutNameObject = new HashMap<>();
        }

        return workoutNameObject;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // Fill test data
        FillTestDate();

        // Add calendar feature
        ImageButton button = (ImageButton) findViewById(R.id.selectDate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        // Add calendar date selection event
        TextView dateView = (TextView) findViewById(R.id.textView);
        dateView.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // if date is not empty, enable visibility
                // refresh list
                LinearLayout dailyWorkouts = (LinearLayout) findViewById(R.id.calendarDailyWorkouts);
                RelativeLayout workoutManagement = (RelativeLayout) findViewById(R.id.calendarWorkoutManagement);
                TextView textView = (TextView) findViewById(R.id.textView);
                String date = textView.getText().toString();

                if(date.length() > 0) {
                    dailyWorkouts.setVisibility(View.VISIBLE);
                    workoutManagement.setVisibility(View.VISIBLE);
                }else{
                    dailyWorkouts.setVisibility(View.GONE);
                    workoutManagement.setVisibility(View.GONE);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Add workouts list listener
        final Gson gson = new Gson();
        ListView workoutsList = (ListView) findViewById(R.id.workoutsPerDay);
        workoutsList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Open workout..
                Workout selectedWorkout = (Workout)adapterView.getSelectedItem();
                Intent workoutIntent = new Intent(CalendarActivity.this, WorkoutActivity.class);
                workoutIntent.putExtra("CurrentWorkout",  gson.toJson(selectedWorkout));
                startActivity(workoutIntent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void FillTestDate(){
        // WorkoutsPerDay
        ListView workoutsList = (ListView) findViewById(R.id.workoutsPerDay);

        ArrayList<String> listItems=new ArrayList<String>();

        listItems.add("Workout 1");
        listItems.add("Workout 2");
        listItems.add("Workout 3");
        listItems.add("Workout 4");

        getWorkoutNameObject().put(listItems.get(0), new Workout(new ArrayList<WorkoutExercise>()));
        getWorkoutNameObject().put(listItems.get(1), new Workout(new ArrayList<WorkoutExercise>()));
        getWorkoutNameObject().put(listItems.get(2), new Workout(new ArrayList<WorkoutExercise>()));
        getWorkoutNameObject().put(listItems.get(3), new Workout(new ArrayList<WorkoutExercise>()));

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);
        workoutsList.setAdapter(adapter);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(currentDateString);
    }
}

package com.example.fityoface.model;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String name;
    private FitnessLevel fitnessLevel;
    private List<Achievement> achievementList;

    public Profile(String name) {
        this.name = name;
        this.achievementList = new ArrayList<>();
    }
}

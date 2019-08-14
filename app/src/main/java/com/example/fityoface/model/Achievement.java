package com.example.fityoface.model;

public class Achievement {

    private boolean unlocked = false;
    private String icon;
    private Profile profile;

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Achievement(String icon, Profile profile) {
        this.icon = icon;
        this.profile = profile;
    }
}

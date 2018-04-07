package com.amiru.shenkar2018;

/**
 * Created by amir on 4/7/18.
 */

class Homework {
    private final String title;
    private final String description;
    private final Class activity;

    public Homework(String title, String description, Class activity) {

        this.title = title;
        this.description = description;
        this.activity = activity;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Class getActivityToLaunch() {
        return activity;
    }
}

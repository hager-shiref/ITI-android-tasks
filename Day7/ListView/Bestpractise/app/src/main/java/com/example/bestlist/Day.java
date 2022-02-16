package com.example.bestlist;

import androidx.annotation.NonNull;

public class Day {
    private  String dayTitle;
    private  String dayDescription;
    private  int imageResourceId;

    public Day(String dayTitle,String dayDescription,int imageResourceId) {
        this.dayTitle = dayTitle;
        this.dayDescription=dayDescription;
        this.imageResourceId=imageResourceId;
    }

    public void setDayTitle(String dayTitle) {
        this.dayTitle = dayTitle;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getDayDescription() {
        return dayDescription;
    }

    public void setDayDescription(String dayDescription) {
        this.dayDescription = dayDescription;
    }

    public String getDayTitle() {
        return dayTitle;
    }

    @NonNull
    @Override
    public String toString() {
        return dayTitle;
    }
}

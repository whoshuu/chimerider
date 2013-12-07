package com.example.chimerider;

import java.util.ArrayList;

public class Motor {
    
    public String category;
    public String status;
    public String reminder;
    public String time;




    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public void setReminder(String reminder) {
        this.reminder = reminder;
    }
    public String getReminder() {
        return reminder;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }

    
    public Motor(String category, String time, String status, String reminder) {
        this.category = category;
        this.status = status;
        this.reminder = reminder;
        this.time = time;
    }

    public static ArrayList<Motor> motorInfoGen(){
        ArrayList<Motor> motorInfo = new ArrayList<Motor>();
        motorInfo.add(new Motor("Total Mileage","50,235","3 Months","11 hours ago"));
        motorInfo.add(new Motor("Last Tire Change Date","Sep 5, 2012","NOW!","26 minutes ago"));
        motorInfo.add(new Motor("Last Oil Change Date","Jan 18, 2013","6 Months","1 hour ago"));
        motorInfo.add(new Motor("Last Lights Check Date","May 15, 2013","5 Months","5 months ago"));
        motorInfo.add(new Motor("Last Battery Check Date","Dec 23, 2012","1 Months","1 month ago"));
        motorInfo.add(new Motor("Last Brakes Check Date","Sep 17, 2013","6 Months","1 month ago"));
        motorInfo.add(new Motor("Last Chain Check Date","Nov 30, 2013","3 Weeks","11 hours ago"));
        return motorInfo;
    }

    
}

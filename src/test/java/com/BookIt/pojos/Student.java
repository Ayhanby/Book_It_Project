package com.BookIt.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("first_name")
    @JsonProperty("property-with-dash")

    String first_name;
    String last_name;
    String password;
    String email;
    String role;
    String batch_number;
    String campus_location;
    String team_name;


    @Override
    public String toString() {
        return "Student{"+
                "first_name='"+first_name+'\''+
                ", last_name='"+last_name+'\''+
                ", password='"+password+'\''+
                ", email='"+email+'\''+
                ", role='"+role+'\''+
                ", batch_number='"+batch_number+'\''+
                ", campus_location='"+campus_location+'\''+
                ", team_name='"+team_name+'\''+
                '}';
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(String batch_number) {
        this.batch_number = batch_number;
    }

    public String getCampus_location() {
        return campus_location;
    }

    public void setCampus_location(String campus_location) {
        this.campus_location = campus_location;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }
}

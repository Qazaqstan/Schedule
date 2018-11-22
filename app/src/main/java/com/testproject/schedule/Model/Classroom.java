package com.testproject.schedule.Model;

public class Classroom {

     private String name;
     private String description;
     private String place;
     private String teacher;
     private String startTime;
     private String endTime;
     private Integer weekDay;
     private String appointment_id;
     private String service_id;
     private Boolean pay;
     private Boolean appointment;
     private Teacher_v2 teacher_v2;
     private String color;
     private Integer availability;

    public Classroom(String name, String description, String place, String teacher, String startTime, String endTime, Integer weekDay, String appointment_id, String service_id, Boolean pay, Boolean appointment, Teacher_v2 teacher_v2, String color, Integer availability) {
        this.name = name;
        this.description = description;
        this.place = place;
        this.teacher = teacher;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekDay = weekDay;
        this.appointment_id = appointment_id;
        this.service_id = service_id;
        this.pay = pay;
        this.appointment = appointment;
        this.teacher_v2 = teacher_v2;
        this.color = color;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }

    public String getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(String appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public Boolean getPay() {
        return pay;
    }

    public void setPay(Boolean pay) {
        this.pay = pay;
    }

    public Boolean getAppointment() {
        return appointment;
    }

    public void setAppointment(Boolean appointment) {
        this.appointment = appointment;
    }

    public Teacher_v2 getTeacher_v2() {
        return teacher_v2;
    }

    public void setTeacher_v2(Teacher_v2 teacher_v2) {
        this.teacher_v2 = teacher_v2;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }
}

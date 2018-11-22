package com.testproject.schedule.API;

import com.testproject.schedule.Model.Classroom;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ScheduleService {

    @GET("5bf50a573000006e007bbbab")
    Call<Classroom[]> getPhoneBook();

}

package com.testproject.schedule.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventWeekService {

    private static Retrofit instance = null;

    private static final String BASE_URL = "http://www.mocky.io/v2/";

    public static Retrofit getClient() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }

}
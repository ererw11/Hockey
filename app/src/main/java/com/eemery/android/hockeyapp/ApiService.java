package com.eemery.android.hockeyapp;

import com.eemery.android.hockeyapp.teamObjects.Team;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("teams")
    Call<Team> getTeams();
}

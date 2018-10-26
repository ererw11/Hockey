package com.eemery.android.hockeyapp.Network;

import com.eemery.android.hockeyapp.teamObjects.Team;
import com.eemery.android.hockeyapp.rosterObjects.Roster;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("teams")
    Call<Team> getTeams();

    @GET("teams/{id}/roster")
    Call<Roster> getRoster(@Path("id") String teamId);
}

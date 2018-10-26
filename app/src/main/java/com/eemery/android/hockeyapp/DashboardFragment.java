package com.eemery.android.hockeyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eemery.android.hockeyapp.teamObjects.Team;
import com.eemery.android.hockeyapp.teamObjects.Team_;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment implements TeamAdapter.TeamAdapterOnClickHandler {

    private static final String TAG = DashboardFragment.class.getSimpleName();

    private RecyclerView teamsRecyclerView;

    private ApiService apiService;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        apiService = ApiUtils.getApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        teamsRecyclerView = v.findViewById(R.id.teams_recycler_view);

        RecyclerView.LayoutManager teamsLayoutManager =
                new LinearLayoutManager(
                        getContext(),
                        RecyclerView.HORIZONTAL,
                        false);
        teamsRecyclerView.setLayoutManager(teamsLayoutManager);
        teamsRecyclerView.setHasFixedSize(true);

        loadTeams();

        return v;
    }

    private void loadTeams() {
        apiService.getTeams().enqueue(new Callback<Team>() {
            @Override
            public void onResponse(Call<Team> call, Response<Team> response) {
                Log.d(TAG, "Teams successful");
                bindTeams(Objects.requireNonNull(response.body()));
            }

            @Override
            public void onFailure(Call<Team> call, Throwable t) {
                Log.d(TAG, "Teams failed = " + t);
            }
        });
    }

    private void bindTeams(Team teamResponse) {
        List<Team_> teamList = teamResponse.getTeams();
        setUpTeamAdapter(sortTeams(teamList));
    }

    private List<Team_> sortTeams(List<Team_> teamsToSort) {
        Collections.sort(teamsToSort, new Comparator<Team_>() {
            @Override
            public int compare(Team_ t1, Team_ t2) {
                return t1.getLocationName().compareToIgnoreCase(t2.getLocationName());
            }
        });
        return teamsToSort;
    }

    private void setUpTeamAdapter(List<Team_> teamList) {
        if (isAdded()) {
            teamsRecyclerView.setAdapter(new TeamAdapter(this, teamList));
        }
    }

    @Override
    public void onClick(Team_ team) {
        Intent newIntent = RosterActivity.newRosterIntent(getContext(), team.getId());
        startActivity(newIntent);
    }
}

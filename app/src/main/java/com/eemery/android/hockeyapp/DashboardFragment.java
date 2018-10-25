package com.eemery.android.hockeyapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eemery.android.hockeyapp.team.Team_;

public class DashboardFragment extends Fragment implements TeamAdapter.TeamAdapterOnClickHandler {

    private static final String TAG = DashboardFragment.class.getSimpleName();

    private RecyclerView teamsRecyclerView;


    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        teamsRecyclerView = v.findViewById(R.id.teams_recycler_view);

        RecyclerView.LayoutManager teamsLayoutManager =
                new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        teamsRecyclerView.setLayoutManager(teamsLayoutManager);
        teamsRecyclerView.setHasFixedSize(true);

        return v;
    }


    @Override
    public void onClick(Team_ team) {
        // Create a toast to test the onClick
        Toast.makeText(getContext(), team.getTeamName(), Toast.LENGTH_SHORT).show();
    }
}

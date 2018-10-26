package com.eemery.android.hockeyapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eemery.android.hockeyapp.rosterObjects.Player;
import com.eemery.android.hockeyapp.rosterObjects.Roster;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RosterFragment extends Fragment implements RosterAdapter.RosterAdapterOnClickHandler {

    public static final String TAG = RosterFragment.class.getSimpleName();

    private static final String ARG_TEAM_ID =
            "com.android.stats.team_id";

    private RecyclerView rosterRecyclerView;

    private ApiService apiService;

    public RosterFragment() {
        // Required empty public constructor
    }

    public static RosterFragment newInstance(String teamId) {
        Bundle arg = new Bundle();
        arg.putSerializable(ARG_TEAM_ID, teamId);

        RosterFragment fragment = new RosterFragment();
        fragment.setArguments(arg);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        apiService = ApiUtils.getApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_roster, container, false);

        rosterRecyclerView = v.findViewById(R.id.roster_recycler_view);

        RecyclerView.LayoutManager rosterLayoutManager =
                new LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.VERTICAL,
                        false);
        rosterRecyclerView.setLayoutManager(rosterLayoutManager);
        rosterRecyclerView.setHasFixedSize(true);

        loadRoster("28");

        return v;
    }

    private void loadRoster(final String teamId) {
        apiService.getRoster(teamId).enqueue(new Callback<Roster>() {
            @Override
            public void onResponse(Call<Roster> call, Response<Roster> response) {
                Log.d(TAG, "Roster " + teamId + " Successful");
                bindRoster(response.body());
            }

            @Override
            public void onFailure(Call<Roster> call, Throwable t) {

            }
        });
    }

    private void bindRoster(Roster rosterResponse) {
        List<Player> rosterList = rosterResponse.getRoster();
        setUpRosterAdapter(sortRoster(rosterList));
    }

    private List<Player> sortRoster(List<Player> rosterToSort) {
        // Sort by number
        Collections.sort(rosterToSort, new Comparator<Player>() {
            @Override
            public int compare(Player r1, Player r2) {
                return r1.getJerseyNumber().compareToIgnoreCase(r2.getJerseyNumber());
            }
        });
        // Sort by position
        Collections.sort(rosterToSort, new Comparator<Player>() {
            @Override
            public int compare(Player r1, Player r2) {
                return r1.getPosition().getType().compareToIgnoreCase(r2.getPosition().getType());
            }
        });
        return rosterToSort;
    }

    private void setUpRosterAdapter(List<Player> rosterList) {
        if (isAdded()) {
            rosterRecyclerView.setAdapter(new RosterAdapter(this, rosterList));
        }
    }

    @Override
    public void onClick(Player player) {
        Toast.makeText(getContext(), player.getPerson().getFullName(), Toast.LENGTH_SHORT).show();
    }
}

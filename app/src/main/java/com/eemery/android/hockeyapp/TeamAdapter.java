package com.eemery.android.hockeyapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eemery.android.hockeyapp.team.Team_;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamHolder> {

    private final TeamAdapterOnClickHandler mClickHandler;
    private final List<Team_> teamList;


    public TeamAdapter(List<Team_> teams, TeamAdapterOnClickHandler clickHandler) {
        teamList = teams;
        mClickHandler = clickHandler;
    }

    @Override
    public TeamAdapter.TeamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view_dashboard_teams, parent, false);
        return new TeamAdapter.TeamHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamAdapter.TeamHolder holder, int position) {
        Team_ team = teamList.get(position);
        String teamLocation = team.getLocationName();
        String teamName = team.getTeamName();
        String teamDivision = team.getDivision().getName();
        holder.bindView(teamLocation, teamName, teamDivision);
    }

    @Override
    public int getItemCount() {
        if (teamList == null) {
            return 0;
        }
        return teamList.size();
    }

    public interface TeamAdapterOnClickHandler {
        void onClick(Team_ team);
    }

    public class TeamHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView teamCityTextView;
        private final TextView teamNameTextView;
        private final TextView teamConferenceTextView;

        TeamHolder(View itemView) {
            super(itemView);

            teamCityTextView = itemView.findViewById(R.id.team_city);
            teamNameTextView = itemView.findViewById(R.id.team_name);
            teamConferenceTextView = itemView.findViewById(R.id.team_division);
            itemView.setOnClickListener(this);
        }

        void bindView(String teamLocation, String teamName, String conference) {
            teamCityTextView.setText(teamLocation);
            teamNameTextView.setText(teamName);
            teamConferenceTextView.setText(conference);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            Team_ selectedTeam = teamList.get(adapterPosition);
            mClickHandler.onClick(selectedTeam);
        }
    }
}

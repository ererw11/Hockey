package com.eemery.android.hockeyapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eemery.android.hockeyapp.rosterObjects.Person;
import com.eemery.android.hockeyapp.rosterObjects.Player;
import com.eemery.android.hockeyapp.rosterObjects.Roster;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RosterAdapter extends RecyclerView.Adapter<RosterAdapter.RosterHolder> {

    private final List<Player> roster;
    RosterAdapterOnClickHandler mClickHandler;

    public RosterAdapter(RosterAdapterOnClickHandler mClickHandler, List<Player> rosterList) {
        this.roster = rosterList;
        this.mClickHandler = mClickHandler;
    }

    @NonNull
    @Override
    public RosterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_view_player_roster, viewGroup, false);
        return new RosterAdapter.RosterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RosterHolder rosterHolder, int position) {
        Player player = roster.get(position);
        String playerId = Integer.toString(player.getPerson().getId());
        String playerName = player.getPerson().getFullName();
        String playerNumber = player.getJerseyNumber();
        String playerPosition = player.getPosition().getName();
        rosterHolder.bindView(playerId, playerName, playerNumber, playerPosition);
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public interface RosterAdapterOnClickHandler {
        void onClick(Player player);
    }

    public class RosterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView playerNameTextView;
        private final TextView playerNumberTextView;
        private final TextView playerPositionTextView;
        private final ImageView playerImage;

        RosterHolder(View itemView) {
            super(itemView);
            playerNameTextView = itemView.findViewById(R.id.player_name_text_view);
            playerNumberTextView = itemView.findViewById(R.id.player_number_text_view);
            playerPositionTextView = itemView.findViewById(R.id.player_position_text_view);
            playerImage = itemView.findViewById(R.id.player_image_view);
            itemView.setOnClickListener(this);
        }

        void bindView(String id, String name, String number, String position) {
            Picasso.get()
                    .load("https://nhl.bamcontent.com/images/headshots/current/168x168/" + id + ".jpg")
                    .placeholder(R.drawable.no_skater_image)
                    .into(playerImage);
            playerNameTextView.setText(name);
            playerNumberTextView.setText(number);
            playerPositionTextView.setText(position);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            Player selectedPlayer = roster.get(adapterPosition);
            mClickHandler.onClick(selectedPlayer);
        }
    }
}

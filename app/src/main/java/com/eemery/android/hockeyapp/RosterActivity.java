package com.eemery.android.hockeyapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.eemery.android.hockeyapp.Utils.SingleFragmentActivity;

public class RosterActivity extends SingleFragmentActivity {

    private final static String EXTRA_TEAM_ID =
            "com.android.stats.team_id";

    public static Intent newRosterIntent(Context packageContext, int id) {
        Intent newIntent = new Intent(packageContext, RosterActivity.class);
        newIntent.putExtra(EXTRA_TEAM_ID, id);
        return newIntent;
    }

    @Override
    protected Fragment createFragment() {
        int teamId = (int) getIntent()
                .getSerializableExtra(EXTRA_TEAM_ID);
        return RosterFragment.newInstance(Integer.toString(teamId));
    }
}

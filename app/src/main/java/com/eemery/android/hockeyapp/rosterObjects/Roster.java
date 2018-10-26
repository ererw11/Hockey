package com.eemery.android.hockeyapp.rosterObjects;

import java.util.List;

public class Roster {

    private String copyright;
    private List<Player> roster = null;
    private String link;

    public String getCopyright() {
        return copyright;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public String getLink() {
        return link;
    }

}

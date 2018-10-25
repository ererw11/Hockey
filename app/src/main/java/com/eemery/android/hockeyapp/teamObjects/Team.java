
package com.eemery.android.hockeyapp.teamObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Team {

    private String copyright;
    private List<Team_> teams = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getCopyright() {
        return copyright;
    }

    public List<Team_> getTeams() {
        return teams;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
}

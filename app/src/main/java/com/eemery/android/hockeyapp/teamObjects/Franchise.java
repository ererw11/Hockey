
package com.eemery.android.hockeyapp.teamObjects;

import java.util.HashMap;
import java.util.Map;

public class Franchise {

    private int franchiseId;
    private String teamName;
    private String link;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public int getFranchiseId() {
        return franchiseId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getLink() {
        return link;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
}

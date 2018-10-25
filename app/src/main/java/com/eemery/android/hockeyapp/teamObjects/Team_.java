
package com.eemery.android.hockeyapp.teamObjects;

import java.util.HashMap;
import java.util.Map;

public class Team_ {

    private int id;
    private String name;
    private String link;
    private Venue venue;
    private String abbreviation;
    private String teamName;
    private String locationName;
    private String firstYearOfPlay;
    private Division division;
    private Conference conference;
    private Franchise franchise;
    private String shortName;
    private String officialSiteUrl;
    private int franchiseId;
    private boolean active;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public Venue getVenue() {
        return venue;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getFirstYearOfPlay() {
        return firstYearOfPlay;
    }

    public Division getDivision() {
        return division;
    }

    public Conference getConference() {
        return conference;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public String getShortName() {
        return shortName;
    }

    public String getOfficialSiteUrl() {
        return officialSiteUrl;
    }

    public int getFranchiseId() {
        return franchiseId;
    }

    public boolean isActive() {
        return active;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
}

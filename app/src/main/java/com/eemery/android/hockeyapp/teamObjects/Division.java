
package com.eemery.android.hockeyapp.teamObjects;

import java.util.HashMap;
import java.util.Map;

public class Division {

    private int id;
    private String name;
    private String nameShort;
    private String link;
    private String abbreviation;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNameShort() {
        return nameShort;
    }

    public String getLink() {
        return link;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
}

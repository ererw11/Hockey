
package com.eemery.android.hockeyapp.teamObjects;

import java.util.HashMap;
import java.util.Map;

public class Venue {

    private String name;
    private String link;
    private String city;
    private TimeZone timeZone;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getCity() {
        return city;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
}

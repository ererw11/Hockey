
package com.eemery.android.hockeyapp.teamObjects;

import java.util.HashMap;
import java.util.Map;

public class TimeZone {

    private String id;
    private int offset;
    private String tz;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public int getOffset() {
        return offset;
    }

    public String getTz() {
        return tz;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
}

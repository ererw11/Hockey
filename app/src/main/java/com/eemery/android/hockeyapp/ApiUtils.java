package com.eemery.android.hockeyapp;

public class ApiUtils {

    public static ApiService getApiService() {
        return RetroClient.getRetrofitInstance().create(ApiService.class);
    }
}

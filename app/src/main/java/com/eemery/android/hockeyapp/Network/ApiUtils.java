package com.eemery.android.hockeyapp.Network;

public class ApiUtils {

    public static ApiService getApiService() {
        return RetroClient.getRetrofitInstance().create(ApiService.class);
    }
}

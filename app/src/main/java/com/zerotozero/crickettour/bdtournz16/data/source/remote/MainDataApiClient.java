package com.zerotozero.crickettour.bdtournz16.data.source.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zerotozero.crickettour.bdtournz16.data.Config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Md.Saeed Sharman on 12/30/2017.
 */

public class MainDataApiClient {

    private static final String BASE_URL = Config.BASE_URL;

    private static Retrofit retrofit = null;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private MainDataApiClient(){}

    public static synchronized Retrofit GetRetrofitMainDataClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}

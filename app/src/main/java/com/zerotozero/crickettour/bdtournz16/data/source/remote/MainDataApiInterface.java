package com.zerotozero.crickettour.bdtournz16.data.source.remote;

import com.zerotozero.crickettour.bdtournz16.data.MainData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Md.Saeed Sharman on 12/30/2017.
 */

public interface MainDataApiInterface {

    @GET("gunzaramfuni.php")
    Call<List<MainData>> getSampleDataList();

}

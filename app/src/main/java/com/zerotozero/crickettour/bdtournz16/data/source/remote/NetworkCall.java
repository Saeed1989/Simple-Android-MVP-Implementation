package com.zerotozero.crickettour.bdtournz16.data.source.remote;

import com.zerotozero.crickettour.bdtournz16.data.MainData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Md.Saeed Sharman on 12/26/2017.
 */

public class NetworkCall implements RemoteApiService {

    @Override
    public void getMainDataListFromServer(final ResponseCallBack<List<MainData>> callback) {

        MainDataApiInterface mainDataApiInterface = MainDataApiClient.GetRetrofitMainDataClient()
                .create(MainDataApiInterface.class);

        Call< List<MainData> > call = mainDataApiInterface.getSampleDataList();

        call.enqueue(new Callback<List<MainData>>() {
            @Override
            public void onResponse(Call<List<MainData>> call, Response<List<MainData>> response) {
                List<MainData> mainDataJsonResponse = response.body();
                callback.onSuccess(mainDataJsonResponse);
            }

            @Override
            public void onFailure(Call<List<MainData>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

}

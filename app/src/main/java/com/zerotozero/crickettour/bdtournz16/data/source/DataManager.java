package com.zerotozero.crickettour.bdtournz16.data.source;

import android.util.Log;

import com.zerotozero.crickettour.bdtournz16.data.Config;
import com.zerotozero.crickettour.bdtournz16.data.MainData;
import com.zerotozero.crickettour.bdtournz16.data.source.local.LoacalDbHelper;
import com.zerotozero.crickettour.bdtournz16.data.source.remote.MainDataApiInterface;
import com.zerotozero.crickettour.bdtournz16.data.source.remote.NetworkCall;
import com.zerotozero.crickettour.bdtournz16.data.source.remote.RemoteApiService;
import com.zerotozero.crickettour.bdtournz16.data.source.remote.ResponseCallBack;
import com.zerotozero.crickettour.bdtournz16.ui.base.MvpPresenter;
import com.zerotozero.crickettour.bdtournz16.ui.base.MvpView;
import com.zerotozero.crickettour.bdtournz16.ui.main.MainPresenter;
import com.zerotozero.crickettour.bdtournz16.ui.main.list.ListContact;

import java.util.List;

/**
 * Created by Md.Saeed Sharman on 12/29/2017.
 */

public class DataManager {

    private static final String TAG = "my_data_manager";

    LoacalDbHelper mLocalDbHelper;

    public DataManager(LoacalDbHelper loacalDbHelper) {
        mLocalDbHelper = loacalDbHelper;
    }

    public MainData getMainData() {
        return mLocalDbHelper.getMainData();
    }

    public List<MainData> getMainDataList() {
        return mLocalDbHelper.getMainDataList();
    }

    public void setDataIndex(int indx) {
        mLocalDbHelper.setDataIndex(indx);
        mMainPresenter.itemSelected(mLocalDbHelper.getMainData(indx));
    }

    public long getSplashDelay(){
        return Config.splashDelay;
    }

    public void loadData(final MvpPresenter presenter){
        RemoteApiService myApiService = new NetworkCall();
        myApiService.getMainDataListFromServer(new ResponseCallBack<List<MainData>>() {
            @Override
            public void onSuccess(List<MainData> response) {
                if (response != null) {
                    mLocalDbHelper.setmMainDalaList(response);
                    presenter.onListLoad();
                    Log.e(TAG, "success" + response.size()+"");
                }
            }

            @Override
            public void onError(Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    public int getItemCount() {
        return mLocalDbHelper.getMainDataCount();
    }

    public Object getItem(int i) {
        return mLocalDbHelper.getMainData(i);
    }

    private MainPresenter mMainPresenter;

    public void setMainPresenter(MainPresenter mainPresenter){
        mMainPresenter = mainPresenter;
    }

}


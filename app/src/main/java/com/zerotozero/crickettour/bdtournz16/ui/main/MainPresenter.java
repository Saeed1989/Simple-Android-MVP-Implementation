package com.zerotozero.crickettour.bdtournz16.ui.main;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;

import com.zerotozero.crickettour.bdtournz16.data.MainData;
import com.zerotozero.crickettour.bdtournz16.data.source.DataManager;
import com.zerotozero.crickettour.bdtournz16.ui.base.BasePresenter;
import com.zerotozero.crickettour.bdtournz16.ui.base.MvpPresenter;
import com.zerotozero.crickettour.bdtournz16.ui.base.MvpView;

/**
 * Created by Md.Saeed Sharman on 12/29/2017.
 */

public class MainPresenter<V extends MainContact.View>  extends BasePresenter<V> implements MainContact.Presenter<V> {

    public MainPresenter(DataManager dataManager) {
        super(dataManager);
        dataManager.setMainPresenter(this);
    }

    private boolean isNetworkConnected() {
       ConnectivityManager cm = (ConnectivityManager) ((Activity)getMvpView()).getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void itemSelected(MainData mainData){
        if(mainData == null) {
            getMvpView().showErrorToast();
            return;
        }

        MainData.Type type = mainData.getType();
        switch (type){
            case HLS:
                getMvpView().openHlsFragment();
                break;
            case YOUTUBE:
                getMvpView().openYouTubeFragment();
                break;
            case WEB_VIEW:
                getMvpView().openWebViewFragment();
                break;
            case APP:
                getMvpView().openAppPlayStore(mainData.getUrl());
                break;
            case NA:
                getMvpView().showErrorToast();
                break;
            default:
                break;
        }
    }

    @Override
    public void isInternetAvailable() {
        if(isNetworkConnected()){
            getMvpView().openDataListFragment();
        }
        else {
            getMvpView().openConnectInternetDialog();
        }
    }


}

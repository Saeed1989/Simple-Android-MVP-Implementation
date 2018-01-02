package com.zerotozero.crickettour.bdtournz16.ui.base;

import com.zerotozero.crickettour.bdtournz16.data.MainData;
import com.zerotozero.crickettour.bdtournz16.data.source.DataManager;

import java.util.List;

/**
 * Created by Md.Saeed Sharman on 12/29/2017.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mMvpView;

    DataManager mDataManager;


    public BasePresenter(DataManager dataManager){
        mDataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    @Override
    public void onListLoad() {

    }
}

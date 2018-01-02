package com.zerotozero.crickettour.bdtournz16.ui.base;

import com.zerotozero.crickettour.bdtournz16.data.MainData;

import java.util.List;

/**
 * Created by Md.Saeed Sharman on 12/29/2017.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onListLoad();

}

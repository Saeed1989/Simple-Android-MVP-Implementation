package com.zerotozero.crickettour.bdtournz16.ui.main;

import com.zerotozero.crickettour.bdtournz16.data.MainData;
import com.zerotozero.crickettour.bdtournz16.ui.base.MvpPresenter;
import com.zerotozero.crickettour.bdtournz16.ui.base.MvpView;

/**
 * Created by Md.Saeed Sharman on 12/29/2017.
 */

public interface MainContact {
    interface View extends MvpView{
         void openDataListFragment();
         void openConnectInternetDialog();
         void openHlsFragment();
         void openYouTubeFragment();
         void openWebViewFragment();
         void openAppPlayStore(String appPackageName);
         void showErrorToast();
    }

   interface Presenter<V extends MainContact.View> extends MvpPresenter<V>{
         void isInternetAvailable();
         void itemSelected(MainData mainData);
    }
}

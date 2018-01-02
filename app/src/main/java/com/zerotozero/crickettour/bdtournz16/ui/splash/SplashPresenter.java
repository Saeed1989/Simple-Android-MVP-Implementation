package com.zerotozero.crickettour.bdtournz16.ui.splash;

import android.content.Intent;
import android.os.Handler;

import com.zerotozero.crickettour.bdtournz16.data.source.DataManager;
import com.zerotozero.crickettour.bdtournz16.ui.base.BasePresenter;

/**
 * Created by Md.Saeed Sharman on 12/29/2017.
 */

public class SplashPresenter<V extends SplashContact.View> extends BasePresenter<V> implements SplashContact.Presenter<V> {

    public SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public  void openMainActivityAfterDelay() {
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                getMvpView().openMainActivity();
            }
        }, getDataManager().getSplashDelay());
    }
}

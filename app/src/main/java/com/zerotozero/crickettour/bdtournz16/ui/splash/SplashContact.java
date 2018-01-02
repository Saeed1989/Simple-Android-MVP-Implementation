package com.zerotozero.crickettour.bdtournz16.ui.splash;

import com.zerotozero.crickettour.bdtournz16.ui.base.BasePresenter;
import com.zerotozero.crickettour.bdtournz16.ui.base.MvpPresenter;
import com.zerotozero.crickettour.bdtournz16.ui.base.MvpView;

/**
 * Created by Md.Saeed Sharman on 12/29/2017.
 */

public interface SplashContact extends MvpView{

    interface View extends MvpView {
        void openMainActivity();
    }

    interface Presenter<V extends SplashContact.View> extends MvpPresenter<V>{
        void openMainActivityAfterDelay();
    }
}

package com.zerotozero.crickettour.bdtournz16.ui.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zerotozero.crickettour.bdtournz16.MvpApp;
import com.zerotozero.crickettour.bdtournz16.R;
import com.zerotozero.crickettour.bdtournz16.data.source.DataManager;
import com.zerotozero.crickettour.bdtournz16.ui.base.BaseActivity;
import com.zerotozero.crickettour.bdtournz16.ui.base.MvpView;
import com.zerotozero.crickettour.bdtournz16.ui.main.MainActivity;

public class SplashActivity extends BaseActivity implements SplashContact.View{

    SplashPresenter mSplashPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        DataManager dataManager = ((MvpApp) getApplication()).getDataManager();

        mSplashPresenter = new SplashPresenter(dataManager);
        mSplashPresenter.onAttach(this);
        mSplashPresenter.openMainActivityAfterDelay();

    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }
}

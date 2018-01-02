package com.zerotozero.crickettour.bdtournz16.ui.main;

import android.app.Dialog;
import android.app.ListFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;
import android.widget.Toast;

import com.zerotozero.crickettour.bdtournz16.MvpApp;
import com.zerotozero.crickettour.bdtournz16.R;
import com.zerotozero.crickettour.bdtournz16.data.source.DataManager;
import com.zerotozero.crickettour.bdtournz16.ui.base.BaseActivity;
import com.zerotozero.crickettour.bdtournz16.ui.main.list.DataListFragment;
import com.zerotozero.crickettour.bdtournz16.util.ActivityUtils;

public class MainActivity extends BaseActivity implements MainContact.View{

    private Dialog mDialog;
    private MainPresenter mMainPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataManager dataManager = ((MvpApp) getApplication()).getDataManager();
        mMainPresenter = new MainPresenter(dataManager);
        mMainPresenter.onAttach(this);
        mMainPresenter.isInternetAvailable();

    }


    @Override
    public void openDataListFragment() {
        DataListFragment listFragment = (DataListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frame_full);
        if (listFragment  == null) {
            listFragment  = DataListFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    listFragment, R.id.frame_full);
        }
    }

    @Override
    public void openConnectInternetDialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Connect to internet and press OK");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                getString(R.string.ok),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mMainPresenter.isInternetAvailable();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    @Override
    public void openHlsFragment() {
        Toast.makeText(this,"Hls",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openYouTubeFragment() {
        Toast.makeText(this,"Youtube",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openWebViewFragment() {
        Toast.makeText(this,"WebView",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openAppPlayStore(String appPackageName) {
        Toast.makeText(this,"PlayStore",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorToast() {
        Toast.makeText(this,"Something went wrong!",Toast.LENGTH_SHORT).show();
    }
}

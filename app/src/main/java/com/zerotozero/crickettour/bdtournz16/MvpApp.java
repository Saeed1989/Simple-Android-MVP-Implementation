package com.zerotozero.crickettour.bdtournz16;

import android.app.Application;

import com.zerotozero.crickettour.bdtournz16.data.source.DataManager;
import com.zerotozero.crickettour.bdtournz16.data.source.local.LoacalDbHelper;

/**
 * Created by Md.Saeed Sharman on 12/29/2017.
 */

public class MvpApp extends Application {

    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();

        LoacalDbHelper loacalDbHelper = new LoacalDbHelper();
        dataManager = new DataManager(loacalDbHelper);

    }

    public DataManager getDataManager() {
        return dataManager;
    }

}

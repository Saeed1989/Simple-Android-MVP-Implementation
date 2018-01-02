package com.zerotozero.crickettour.bdtournz16.ui.main.list;

import com.zerotozero.crickettour.bdtournz16.data.MainData;
import com.zerotozero.crickettour.bdtournz16.data.source.DataManager;
import com.zerotozero.crickettour.bdtournz16.ui.base.BasePresenter;
import com.zerotozero.crickettour.bdtournz16.ui.base.MvpPresenter;
import com.zerotozero.crickettour.bdtournz16.ui.base.MvpView;

import java.util.List;

/**
 * Created by Md.Saeed Sharman on 12/30/2017.
 */

public class ListPresenter<V extends ListContact.View> extends BasePresenter<V> implements ListContact.Presenter<V> {

    public ListPresenter(DataManager dataManager){
        super(dataManager);
    }


    @Override
    public void loadData() {
        getDataManager().loadData(this);
    }

    @Override
    public void onListLoad() {
        super.onListLoad();
        getMvpView().populateGridView();
    }
}

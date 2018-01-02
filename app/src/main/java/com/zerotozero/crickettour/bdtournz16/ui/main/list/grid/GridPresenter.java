package com.zerotozero.crickettour.bdtournz16.ui.main.list.grid;

import com.zerotozero.crickettour.bdtournz16.data.Config;
import com.zerotozero.crickettour.bdtournz16.data.MainData;
import com.zerotozero.crickettour.bdtournz16.data.source.DataManager;
import com.zerotozero.crickettour.bdtournz16.ui.base.BasePresenter;

import java.util.List;

/**
 * Created by Md.Saeed Sharman on 12/30/2017.
 */

public class GridPresenter extends BasePresenter implements GridContact.Presenter{


    public GridPresenter(DataManager dataManager){
       super(dataManager);
    }

    @Override
    public void bindView(int position, GridContact.View view){
        MainData mainData = (MainData) getItem(position);
        view.setView(position, mainData.getName(), Config.IMAGE_BASE_URL + mainData.getmImageUrl());
    }

    @Override
    public int getItemCount() {
        return getDataManager().getItemCount();
    }

    @Override
    public Object getItem(int i) {
        return getDataManager().getItem(i);
    }

    @Override
    public void itemClicked(int position){
        getDataManager().setDataIndex(position);
    }

}

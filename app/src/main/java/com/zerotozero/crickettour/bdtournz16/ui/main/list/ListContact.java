package com.zerotozero.crickettour.bdtournz16.ui.main.list;

import com.zerotozero.crickettour.bdtournz16.ui.base.MvpPresenter;
import com.zerotozero.crickettour.bdtournz16.ui.base.MvpView;

/**
 * Created by Md.Saeed Sharman on 12/30/2017.
 */

public interface ListContact {
    interface View extends MvpView{
        public void populateGridView();
    }

    interface Presenter<V extends ListContact.View> extends MvpPresenter<V>{
        public void loadData();
    }
}

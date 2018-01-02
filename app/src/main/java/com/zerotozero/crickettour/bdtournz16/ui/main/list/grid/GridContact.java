package com.zerotozero.crickettour.bdtournz16.ui.main.list.grid;

/**
 * Created by Md.Saeed Sharman on 12/30/2017.
 */

public interface GridContact {

    interface View {
        void setView(int position, String title, String imageUri);
    }

    interface Presenter{
       void bindView(int position, GridContact.View view);
       int getItemCount();
       Object getItem(int i);
       void itemClicked(int position);
    }
}

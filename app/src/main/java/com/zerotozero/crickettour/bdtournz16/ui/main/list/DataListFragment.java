package com.zerotozero.crickettour.bdtournz16.ui.main.list;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.zerotozero.crickettour.bdtournz16.MvpApp;
import com.zerotozero.crickettour.bdtournz16.R;
import com.zerotozero.crickettour.bdtournz16.data.source.DataManager;
import com.zerotozero.crickettour.bdtournz16.ui.main.list.grid.GridPresenter;
import com.zerotozero.crickettour.bdtournz16.ui.main.list.grid.ItemGridAdapter;


public class DataListFragment extends Fragment implements ListContact.View{

    private View mProgressBar;
    private ListPresenter mListPresenter;
    GridView mItemGridView;

    public DataListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataManager dataManager = ((MvpApp) getActivity().getApplication()).getDataManager();
        mListPresenter = new ListPresenter(dataManager);
    }

    public static DataListFragment newInstance() {
        return new DataListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_data_list, container, false);
        mProgressBar = rootView.findViewById(R.id.loading_progressbar);
        mItemGridView = (GridView) rootView.findViewById(R.id.item_gridview);
        mListPresenter.onAttach(this);
        mListPresenter.loadData();
        return rootView;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void populateGridView() {
        mProgressBar.setVisibility(View.INVISIBLE);
        GridPresenter gridPresenter = new GridPresenter(((MvpApp) getActivity()
                .getApplication()).getDataManager());
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(gridPresenter);
        mItemGridView.setAdapter(itemGridAdapter);
    }
}

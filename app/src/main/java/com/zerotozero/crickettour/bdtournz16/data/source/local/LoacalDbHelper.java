package com.zerotozero.crickettour.bdtournz16.data.source.local;

import com.zerotozero.crickettour.bdtournz16.data.MainData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Md.Saeed Sharman on 12/29/2017.
 */

public class LoacalDbHelper {
    private List<MainData> mMainDalaList = new ArrayList<MainData>(10);
    private int mDataIndx = 0;

    public LoacalDbHelper(List<MainData> mainDataList){
        mMainDalaList = mainDataList;
    }

    public LoacalDbHelper(){

    }

    public void setmMainDalaList(List<MainData> mainDalaList){
        mMainDalaList = mainDalaList;
    }

    public List<MainData> getMainDataList(){
        return mMainDalaList;
    }

    public void setDataIndex( int indx){
        if(indx <0 ){
            mDataIndx = 0;
        }
        else{
            mDataIndx = indx;
        }
    }

    public MainData getMainData(){
        MainData result;
        if(mMainDalaList!=null && mMainDalaList.size() > mDataIndx){
            result = mMainDalaList.get(mDataIndx);
        }
        else{
            result = null;
        }

        return result;
    }

    public MainData getMainData(int position){
        MainData result;
        if(mMainDalaList!=null && mMainDalaList.size() > position){
            result = mMainDalaList.get(position);
        }
        else{
            result = null;
        }

        return result;
    }

    public int getMainDataCount(){
        return mMainDalaList.size();
    }
}

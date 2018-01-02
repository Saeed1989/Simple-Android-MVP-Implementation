package com.zerotozero.crickettour.bdtournz16.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Md.Saeed Sharman on 12/29/2017.
 */

public class MainData {
    @SerializedName("name")
    private String mName;

    @SerializedName("type")
    private String mTypeText;

    @SerializedName("link")
    private String mUrl;

    @SerializedName("picture1")
    private String mImageUrl;

    private Type mType = null;


    public MainData (String name, String type, String url, String imageUrl) {
        mName = name;
        mTypeText = type;
        mUrl = url;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public MainData.Type getType() {

        if(mType == null) {
            switch (mTypeText) {
                case "hls":
                    mType = Type.HLS;
                    break;
                case "youtube":
                    mType = Type.YOUTUBE;
                    break;
                case "app":
                    mType = Type.APP;
                    break;
                case "webview":
                    mType = Type.WEB_VIEW;
                    break;
                default:
                    mType = Type.NA;
                    break;
            }
        }

        return mType;
    }

    public String getUrl(){
        return mUrl;
    }

    public String getmImageUrl(){
        return mImageUrl;
    }

    public enum Type {
        HLS, YOUTUBE, APP, WEB_VIEW, NA
    }
}

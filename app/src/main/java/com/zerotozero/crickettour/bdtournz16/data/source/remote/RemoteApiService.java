package com.zerotozero.crickettour.bdtournz16.data.source.remote;

import com.zerotozero.crickettour.bdtournz16.data.MainData;

import java.util.List;

/**
 * Created by Md.Saeed Sharman on 12/26/2017.
 */

public interface RemoteApiService {
    void getMainDataListFromServer(ResponseCallBack< List<MainData> > callback);
}

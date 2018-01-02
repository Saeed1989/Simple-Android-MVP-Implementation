package com.zerotozero.crickettour.bdtournz16.data.source.remote;

/**
 * Created by Md.Saeed Sharman on 12/26/2017.
 */

public interface ResponseCallBack<T> {
    void onSuccess(T data);
    void onError(Throwable th);
}

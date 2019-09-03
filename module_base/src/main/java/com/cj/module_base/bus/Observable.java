package com.cj.module_base.bus;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/**
 * Author:chris - jason
 * Date:2019-08-23.
 * Package:com.cj.common.bus
 * 被观察者
 */
public interface Observable<T> {

    //发送消息
    void post(T value);


    //注册要一个观察者
    void observe(@NonNull LifecycleOwner owner, @NonNull Observer<T> observer);

}

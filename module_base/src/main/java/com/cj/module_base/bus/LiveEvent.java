package com.cj.module_base.bus;

import androidx.annotation.NonNull;
import androidx.lifecycle.ExternalLiveData;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Author:chris - jason
 * Date:2019-08-29.
 * Package:com.cj.common.bus
 */
public class LiveEvent<T> implements Observable<T> {

    private ExternalLiveData<T> data = new ExternalLiveData<>();

    @Override
    public void post(T value) {
        data.setValue(value);
    }

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<T> observer) {
        data.observe(owner,observer);
    }

}

package com.example.flutter_to_react_native;

import android.app.Activity;
import android.app.Application;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.jscexecutor.JSCExecutorFactory;
import com.facebook.react.shell.MainReactPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyReactInstanceManager {
    private static ReactInstanceManager reactInstanceManager;
    public static ReactInstanceManager initObj(Application application, Activity activity){
        List<ReactPackage> packages =  new ArrayList<ReactPackage>(Arrays.asList(new MainReactPackage()));
        JSCExecutorFactory jsFactory
                = new JSCExecutorFactory("", "");
        reactInstanceManager  = ReactInstanceManager.builder()
                .setApplication(application)
                .setCurrentActivity(activity)
                .setBundleAssetName("index.android.bundle")
                .setJavaScriptExecutorFactory(jsFactory)
                .setJSMainModulePath("index")
                .addPackages(packages)
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        return reactInstanceManager;
    }
    public static ReactInstanceManager getInstance(Application application, Activity activity){
        if(reactInstanceManager == null){
            List<ReactPackage> packages =  new ArrayList<ReactPackage>(Arrays.asList(new MainReactPackage()));
            JSCExecutorFactory jsFactory
                    = new JSCExecutorFactory("", "");
            reactInstanceManager  = ReactInstanceManager.builder()
                    .setApplication(application)
                    .setCurrentActivity(activity)
                    .setBundleAssetName("index.android.bundle")
                    .setJavaScriptExecutorFactory(jsFactory)
                    .setJSMainModulePath("index")
                    .addPackages(packages)
                    .setUseDeveloperSupport(BuildConfig.DEBUG)
                    .setInitialLifecycleState(LifecycleState.RESUMED)
                    .build();
        }
        return reactInstanceManager;
    }
}

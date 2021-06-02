package com.android.multiplescreens;

import android.app.Application;

import com.facebook.react.PackageList;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.common.LifecycleState;

import java.util.List;

public class MyApplication extends Application {
    private ReactInstanceManager mReactInstanceManager;
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static MyApplication getInstance() {
        return MyApplication.sInstance;
    }

    public ReactInstanceManager getReactInstanceManager() {
        if(mReactInstanceManager == null){
             List<ReactPackage> packages = new PackageList(this).getPackages();
            // Packages that cannot be autolinked yet can be added manually here, for example:
            // packages.add(new MyReactNativePackage());
            // Remember to include them in `settings.gradle` and `app/build.gradle` too.

            // Packages that cannot be autolinked yet can be added manually here, for example:
            // packages.add(new MyReactNativePackage());
            // Remember to include them in `settings.gradle` and `app/build.gradle` too.
            mReactInstanceManager = ReactInstanceManager.builder()
                    .setApplication(this)
                    .setBundleAssetName("index.android.bundle")
                    .setJSMainModulePath("index")
                    .addPackages(packages)
                    .setUseDeveloperSupport(BuildConfig.DEBUG)
                    .setInitialLifecycleState(LifecycleState.BEFORE_CREATE)
                    .build();
        }
        return mReactInstanceManager;
    }
}

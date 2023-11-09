package com.petgram;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BBDDConnectPackage implements ReactPackage {

   @NonNull
   @Override
   public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
       return Arrays.<NativeModule>asList(new BBDDConnectModule(reactContext));
   }

   @NonNull
   @Override
   public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
       return Collections.emptyList();
   }
}

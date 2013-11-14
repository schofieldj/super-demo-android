package com.schofield.android.apps.gamedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.Surface;

public class GameService extends Service {
    // ------------------------------------------------------------------------ 
    // TYPES
    // ------------------------------------------------------------------------

    public class Binder extends android.os.Binder {
        GameService getService() {
            return GameService.this;
        }
    }

    // ------------------------------------------------------------------------
    // STATIC FIELDS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // STATIC INITIALIZERS
    // ------------------------------------------------------------------------

    static {
        System.loadLibrary("game");
    }

    // ------------------------------------------------------------------------
    // STATIC METHODS
    // ------------------------------------------------------------------------

    private static native void nativeBeginGame();
    private static native void nativeEndGame();
    private static native void nativeSetSurface(Surface surface);

    // ------------------------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------------------------

    private final IBinder mBinder = new GameService.Binder();

    // ------------------------------------------------------------------------
    // INITIALIZERS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // CONSTRUCTORS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // METHODS
    // ------------------------------------------------------------------------

    @Override
    public void onCreate() {
        super.onCreate();
        nativeBeginGame();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        nativeEndGame();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public void setSurface(Surface surface) {
        nativeSetSurface(surface);
    }
}

package com.schofield.android.apps.gamedemo;

import android.os.Bundle;
import android.os.IBinder;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public class GameActivity extends Activity implements SurfaceHolder.Callback {
    // ------------------------------------------------------------------------
    // TYPES
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // STATIC FIELDS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // STATIC INITIALIZERS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // STATIC METHODS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------------------------

    private GameService mGameService;

    private ServiceConnection mGameServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder binder) {
            mGameService = ((GameService.Binder) binder).getService();

            setContentView(R.layout.activity_main);
            SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surface);
            surfaceView.getHolder().addCallback(GameActivity.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mGameService = null;
        }
    };
    
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent serviceIntent = new Intent(this, GameService.class);
        startService(serviceIntent);
        bindService(serviceIntent, mGameServiceConnection, Context.BIND_AUTO_CREATE);
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
        unbindService(mGameServiceConnection);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(new Intent(this, GameService.class));
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (mGameService != null) {
            mGameService.setSurface(holder.getSurface());
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (mGameService != null) {
            mGameService.setSurface(null);
        }
    }
}

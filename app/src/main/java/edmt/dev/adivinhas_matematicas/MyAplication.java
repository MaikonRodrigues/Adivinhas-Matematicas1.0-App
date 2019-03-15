package edmt.dev.adivinhas_matematicas;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

public class MyAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MobileAds.initialize(this, getString(R.string.admob_app_id));

    }
}

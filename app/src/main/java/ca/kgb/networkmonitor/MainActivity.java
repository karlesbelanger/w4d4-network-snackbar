package ca.kgb.networkmonitor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                Log.d(TAG, "checkInternet: " + "Connected to WIFI");
                Snackbar.make(view, "checkInternet: " + "Connected to WIFI", Snackbar.LENGTH_SHORT).show();
            }
             else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                Log.d(TAG, "checkInternet: " + "Connected to Mobile data");
            Snackbar.make(view, "checkInternet: " + "Connected to Mobile data", Snackbar.LENGTH_SHORT).show();
            }
        } else {
            Log.d(TAG, "checkInternet: " + "Not connected");
        Snackbar.make(view, "checkInternet: " + "Not connected", Snackbar.LENGTH_SHORT).show();
        }
    }
}

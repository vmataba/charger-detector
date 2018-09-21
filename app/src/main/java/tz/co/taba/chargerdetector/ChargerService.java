package tz.co.taba.chargerdetector;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.widget.Toast;

public class ChargerService extends Service {

    public ChargerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (isConnected(getBaseContext())){
            ChargerReceiver receiver = new ChargerReceiver();
            registerReceiver(receiver,new IntentFilter(Intent.ACTION_POWER_CONNECTED));
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {

        Toast.makeText(getBaseContext(),"Destroyed!",Toast.LENGTH_LONG).show();

        super.onDestroy();
    }

    public boolean isConnected(Context context) {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, filter);

        int chargeState = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

        return chargeState == BatteryManager.BATTERY_STATUS_CHARGING;
    }

}

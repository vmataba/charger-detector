package tz.co.taba.chargerdetector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.telephony.SmsManager;
import android.widget.Toast;

public class ChargerReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

            if (isConnected(context)){

                sendTextMessage("Charger has been connected!");

            }

    }

    public boolean isConnected(Context context) {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, filter);

        int chargeState = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);

        return chargeState == BatteryManager.BATTERY_STATUS_CHARGING;
    }


    private void sendTextMessage (String message){

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+255767687325", null, message, null, null);

    }
}

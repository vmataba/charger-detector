package tz.co.taba.chargerdetector;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent serviceIntent = new Intent(getBaseContext(),ChargerService.class);
        startService(serviceIntent);

        finish();

    }



    private void sendEmail(String email){

        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        emailIntent.setType("vnd.android.cursor.item/email");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {"add"});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "DEIVICE`S BATTERY STATUS");
        startActivity(Intent.createChooser(emailIntent, "Tuma email kupitia..."));

    }



}

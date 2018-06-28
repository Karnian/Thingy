package no.nordicsemi.android.nrfthingy;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.config.AWSConfiguration;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import java.util.Random;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.tech.NfcF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import no.nordicsemi.android.nrfthingy.common.AboutActivity;
import no.nordicsemi.android.nrfthingy.common.DismissNfcWarningDialogFragment;
import no.nordicsemi.android.nrfthingy.common.EnableNFCDialogFragment;
import no.nordicsemi.android.nrfthingy.common.MessageDialogFragment;
import no.nordicsemi.android.nrfthingy.common.NFCTagFoundDialogFragment;
import no.nordicsemi.android.nrfthingy.common.PermissionRationaleDialogFragment;
import no.nordicsemi.android.nrfthingy.common.ProgressDialogFragment;
import no.nordicsemi.android.nrfthingy.common.Utils;
import no.nordicsemi.android.nrfthingy.configuration.ConfigurationActivity;
import no.nordicsemi.android.nrfthingy.configuration.ConfirmThingyDeletionDialogFragment;
import no.nordicsemi.android.nrfthingy.configuration.InitialConfigurationActivity;
import no.nordicsemi.android.nrfthingy.database.DatabaseContract;
import no.nordicsemi.android.nrfthingy.database.DatabaseHelper;
import no.nordicsemi.android.nrfthingy.dfu.DfuUpdateAvailableDialogFragment;
import no.nordicsemi.android.nrfthingy.dfu.SecureDfuActivity;
import no.nordicsemi.android.nrfthingy.thingy.Thingy;
import no.nordicsemi.android.nrfthingy.thingy.ThingyAdapter;
import no.nordicsemi.android.nrfthingy.thingy.ThingyService;
import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat;
import no.nordicsemi.android.support.v18.scanner.ScanCallback;
import no.nordicsemi.android.support.v18.scanner.ScanFilter;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;
import no.nordicsemi.android.thingylib.ThingyListener;
import no.nordicsemi.android.thingylib.ThingyListenerHelper;
import no.nordicsemi.android.thingylib.ThingySdkManager;
import no.nordicsemi.android.thingylib.utils.ThingyUtils;

public class SendData extends AppCompatActivity {

    // Declare a DynamoDBMapper object
    DynamoDBMapper dynamoDBMapper;
    InitialConfigurationActivity ICA = new InitialConfigurationActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AWSMobileClient enables AWS user credentials to access your table
        AWSMobileClient.getInstance().initialize(this).execute();

        AWSCredentialsProvider credentialsProvider = AWSMobileClient.getInstance().getCredentialsProvider();
        AWSConfiguration configuration = AWSMobileClient.getInstance().getConfiguration();


        // Add code to instantiate a AmazonDynamoDBClient
        AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient(credentialsProvider);

        this.dynamoDBMapper = DynamoDBMapper.builder()
                .dynamoDBClient(dynamoDBClient)
                .awsConfiguration(configuration)
                .build();

        // other activity code ...
    }
    public void createThingy() {
        final ThinghDO TT = new ThinghDO();
        TT.setUserId(ICA.getmDevice().getAddress());
        TT.setDeviceName(ICA.getmDeviceName());
        TT.setUserName(ICA.getmUserName());
        TT.setUserAge(ICA.getmUserAge());
        TT.setUserGender(ICA.getmUserGender());
        TT.setPlaceName(ICA.getmPlaceName());

        new Thread(new Runnable() {
            @Override
            public void run() {

                // Item saved
            }
        }).start();
    }
}



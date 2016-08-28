package com.conduit.taphealthngo;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import java.nio.charset.Charset;

public class NFCActivity extends AppCompatActivity {

    private NfcAdapter mNfcAdapter;
    private static final String MIME_TEXT_PLAIN = "text/plain";

    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (mNfcAdapter == null) {
            Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        final Intent intent = new Intent(NFCActivity.this, getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        pendingIntent = PendingIntent.getActivity(
                this, 0, intent, 0);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setupForegroundDispatch(this,mNfcAdapter);
    }


    @Override
    protected void onPause() {
        stopForegroundDispatch(this,mNfcAdapter);
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void handleIntent(Intent intent) {
        String action = intent.getAction();

        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)) {
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            String[] techList = tag.getTechList();
            String searchedTech = Ndef.class.getName();

            MifareClassic mifareClassic = MifareClassic.get(tag);
            NfcA nfcA = NfcA.get(tag);
            byte[] a = nfcA.getAtqa();
            String atqa = new String(a, Charset.forName("US-ASCII"));

            for (String tech : techList) {
                //mTxtTest.setText(tech + " " + mTxtTest.getText());
                if (searchedTech.equals(tech)) {
                    //new NdefReaderTask().execute(tag);
                    break;
                }
            }

            Intent intentLoadPatientInfo = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intentLoadPatientInfo);

        }
    }

    public void setupForegroundDispatch(final Activity activity, NfcAdapter adapter) {

        IntentFilter nfcTag =  new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
        IntentFilter nfcTech =  new IntentFilter(NfcAdapter.ACTION_TECH_DISCOVERED);

        try {
            nfcTag.addDataType("*/*");
            nfcTech.addDataType("*/*");
        } catch (IntentFilter.MalformedMimeTypeException e) {
            e.printStackTrace();
        }

        IntentFilter[] filters = new IntentFilter[]{nfcTag,nfcTech};

        String[][] techList = new String[][] { new String[] { MifareUltralight.class.getName(), Ndef.class.getName(), NfcA.class.getName()},
                new String[] { MifareClassic.class.getName(), Ndef.class.getName(), NfcA.class.getName()}};


        adapter.enableForegroundDispatch(activity, pendingIntent, null, null);

    }

    public static void stopForegroundDispatch(final Activity activity, NfcAdapter adapter) {
        adapter.disableForegroundDispatch(activity);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);


    }

}

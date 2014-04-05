package com.tapinto.client.utility;


import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.Toast;

public abstract class NFCAbstractReadActivity extends ActionBarActivity {
	
	private NfcAdapter nfcAdapter;
	private IntentFilter[] ndefExchangeFilter;
	private PendingIntent pendingNfcIntent;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = getApplicationContext();
		nfcAdapter = NfcAdapter.getDefaultAdapter(context);
		pendingNfcIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP), 0);
		IntentFilter smartwhere = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
		ndefExchangeFilter = new IntentFilter[] {smartwhere};
	}
	
	@Override
	protected void onResume () {
		super.onResume();
		
		if (nfcAdapter == null) {
			Toast.makeText(context, "Sorry, no NFC available", Toast.LENGTH_SHORT).show();
			return;
		}
		
		if (!nfcAdapter.isEnabled()) {
			//<TODO> tell user to change wireless settings
			Intent setNfc = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
			startActivity(setNfc);
		}
		nfcAdapter.enableForegroundDispatch(this, pendingNfcIntent, ndefExchangeFilter, null);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		if (nfcAdapter != null) {
			nfcAdapter.disableForegroundDispatch(this);
		}
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		
		if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())) {
			NdefMessage[] messages = null;
			Parcelable[] rawMessages = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
			
			if (rawMessages != null) {
				messages = new NdefMessage[rawMessages.length];
				for (int i = 0; i < rawMessages.length; i ++) {
					messages[i] = (NdefMessage)rawMessages[i];
				}
			}
			if (messages != null && messages[0] != null) {
				StringBuilder result = new StringBuilder();
				byte[] payload = messages[0].getRecords()[0].getPayload();
				for (int i = 0; i < payload.length; i ++) {
					result.append((char)payload[i]);
				}
				onTagRead(result.toString());
			}
		}
	}
	
	protected abstract void onTagRead (String tagMessage);

}

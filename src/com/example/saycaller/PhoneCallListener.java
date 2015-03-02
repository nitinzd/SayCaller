package com.example.saycaller;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class PhoneCallListener extends PhoneStateListener {
String incomingContact;

@Override
public void onCallStateChanged(int state, String incomingNumber) {
	if (TelephonyManager.CALL_STATE_RINGING==state) {
		incomingContact = incomingNumber;
			}
	}

}

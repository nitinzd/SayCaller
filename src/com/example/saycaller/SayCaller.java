package com.example.saycaller;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;


@SuppressLint("NewApi")
public class SayCaller extends IntentService {
TextToSpeech tts;
	
	public SayCaller() {
		super("SayCaller"); 
	}
	
  @Override
  protected void onHandleIntent(Intent workIntent) {
	  AudioManager audManager;
	  audManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
	  int rMode = audManager.getRingerMode();
PhoneCallListener phoneListener = new PhoneCallListener();	  
TelephonyManager telManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
telManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
if (rMode == AudioManager.RINGER_MODE_NORMAL) {
	  	  tts = new TextToSpeech (getApplicationContext(), new TextToSpeech.OnInitListener() {
		  @Override
		  public void onInit(int status) {
			  if (status!=TextToSpeech.ERROR) {
				  tts.setLanguage(tts.getDefaultLanguage());
			  }
		  }
	  });
	  	  	  	  audManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	  	  tts.speak(phoneListener.incomingContact, TextToSpeech.QUEUE_FLUSH, null);
	  	  audManager.setRingerMode(rMode);	
//	  	audManager.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI);
//	  	audManager.adjustStreamVolume(AudioManager.STREAM_RING, iVolume/2, AudioManager.FLAG_SHOW_UI);
	  	audManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	  tts.speak(phoneListener.incomingContact, TextToSpeech.QUEUE_FLUSH, null);
	  audManager.setRingerMode(rMode);
//	  audManager.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI);
}
  }
  }
  
	


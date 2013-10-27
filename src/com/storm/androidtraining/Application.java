package com.storm.androidtraining;

import com.cst.stormdroid.app.SDBaseApplication;
import com.cst.stormdroid.utils.Config;

public class Application extends SDBaseApplication{
	
	@Override
	public void onCreate() {
		super.onCreate();
		//set in debug mode
		Config.enableDebug(true);
	}
}

package com.storm.androidtraining.C006;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.cst.stormdroid.activity.SDBaseSupportFragmentActivity;
import com.cst.stormdroid.fragment.interfaces.SDBaseCallback;
import com.storm.androidtraining.R;

public class C006Activity extends SDBaseSupportFragmentActivity implements SDBaseCallback {
	private Fragment mContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame_content);
		initFragments(savedInstanceState);
	}

	public void initFragments(Bundle savedInstanceState) {
		if (savedInstanceState == null) {
			FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
			mContent = new C00601Fragment();
			fragmentTransaction.replace(R.id.content, mContent);
			fragmentTransaction.commit();
		} else {
			mContent = (Fragment) this.getSupportFragmentManager().findFragmentById(R.id.content);
		}
	}

}

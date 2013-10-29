package com.storm.androidtraining;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.cst.stormdroid.activity.SDBaseSupportFragmentActivity;
import com.cst.stormdroid.fragment.interfaces.SDBaseCallback;
import com.cst.stormdroid.utils.toast.ToastUtil;
import com.storm.androidtraining.R;

public class ContentActivity extends SDBaseSupportFragmentActivity implements SDBaseCallback {
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

			final String packageName = getIntent().getStringExtra("package");
			final String courseId = getIntent().getStringExtra("course");
			final String sub = getIntent().getStringExtra("sub");
			
			final String fragmentName = packageName + "." + courseId + sub + "Fragment";
			
			try {
				Class fragmentClass = Class.forName(fragmentName);
				mContent = (Fragment) fragmentClass.newInstance();
				fragmentTransaction.replace(R.id.content, mContent);
				fragmentTransaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
				ToastUtil.debugToast(fragmentName + "未定义");
			}
		} else {
			mContent = (Fragment) this.getSupportFragmentManager().findFragmentById(R.id.content);
		}
	}

}

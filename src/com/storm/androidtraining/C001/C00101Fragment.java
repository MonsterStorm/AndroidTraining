package com.storm.androidtraining.C001;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.cst.stormdroid.fragment.SDBaseSupportFragment;
import com.storm.androidtraining.R;
import com.storm.androidtraining.C001.C00101ImageView.OnAnimationListener;

public class C00101Fragment extends SDBaseSupportFragment {
	private Dialog dialog;
	private C00101ImageView ivTmp1;
	private C00101ImageView ivTmp2;
	private View mContentView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		dialog = new Dialog(getActivity(), R.style.c00101dialog);
		dialog.setContentView(R.layout.dlg_c00101);
		dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

		ivTmp1 = (C00101ImageView) dialog.findViewById(R.id.tvTmp1);
		ivTmp2 = (C00101ImageView) dialog.findViewById(R.id.tvTmp2);

		dialog.setCancelable(false);
		dialog.show();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		mContentView = inflater.inflate(R.layout.fg_c00101, container, false);
		return mContentView;
	}

	@Override
	public void onResume() {
		super.onResume();

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				ivTmp2.setOnAnimationListener(new OnAnimationListener() {
					@Override
					public void onAnimationStart() {
						
						Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_in);
						animation.setFillAfter(true);
						mContentView.startAnimation(animation);
					}
					
					@Override
					public void onAnimationEnd() {
						dialog.dismiss();
					}
				});
				
				ivTmp1.scrollToTop();
				ivTmp2.scrollToBottom();
			}
		}, 1000);
	}
}

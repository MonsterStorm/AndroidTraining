package com.storm.androidtraining.C001;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.cst.stormdroid.fragment.SDBaseSupportFragment;
import com.storm.androidtraining.R;

public class C00102Fragment extends SDBaseSupportFragment {
	private ViewFlipper vfTmp;

	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fg_c00102, container, false);
		vfTmp = (ViewFlipper) view.findViewById(R.id.vfTmp);
		btn1 = (Button) view.findViewById(R.id.btn1);
		btn2 = (Button) view.findViewById(R.id.btn2);
		btn3 = (Button) view.findViewById(R.id.btn3);
		btn4 = (Button) view.findViewById(R.id.btn4);
		btn5 = (Button) view.findViewById(R.id.btn5);
		vfTmp.startFlipping();
		return view;
	}

	@Override
	protected void initData() {
		super.initData();
	}

	@Override
	protected void bindActions() {
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				vfTmp.setInAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.push_up_in));
				vfTmp.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.push_up_out));
			}
		});

		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				vfTmp.setInAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.push_left_in));
				vfTmp.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.push_left_out));
			}
		});
		
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				vfTmp.setInAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.scalefade_in));
				vfTmp.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.scalefade_out));
			}
		});
		
		btn4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				vfTmp.setInAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.scalefade_in2));
				vfTmp.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.scalefade_out2));
			}
		});
		
		btn5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				vfTmp.setInAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_in));
				vfTmp.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_out));
			}
		});
	}

}

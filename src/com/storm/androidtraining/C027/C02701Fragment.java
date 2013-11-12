package com.storm.androidtraining.C027;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cst.stormdroid.fragment.SDBaseSupportFragment;
import com.cst.stormdroid.utils.toast.ToastUtil;
import com.storm.androidtraining.R;

public class C02701Fragment extends SDBaseSupportFragment {
	private TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fg_default, container, false);
		tv = (TextView) view.findViewById(android.R.id.text1);
		return view;
	}

	@Override
	protected void initData() {
		super.initData();
		
//		tv.setMovementMethod(new ScrollingMovementMethod());//scroll
		
		try {
			InputStream is = getResources().openRawResource(R.raw.c02701);
			String s = IOUtils.toString(is);
			IOUtils.closeQuietly(is);
			tv.setText(s);
		} catch (Exception e) {
			ToastUtil.debugToast("Load Data (R.raw.c02701) error!");
			e.printStackTrace();
		}
	}
}

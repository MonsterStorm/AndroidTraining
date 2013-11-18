package com.storm.androidtraining.C000;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import com.cst.stormdroid.fragment.SDBaseSupportFragment;
import com.storm.androidtraining.R;

/**
 * ScaleType of ImageView
 * 
 * @author Storm
 * 
 */
public class C00002Fragment extends SDBaseSupportFragment {
	private ImageView ivTmp1;
	private ImageView ivTmp2;
	private ImageView ivTmp3;
	private ImageView ivTmp4;
	private Spinner spinner1;

	private String[] array1 = new String[] { "matrix", "fitXY", "fitStart", "fitCenter", "fitEnd", "center", "centerCrop", "centerInside" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fg_c00002, container, false);
		ivTmp1 = (ImageView) view.findViewById(R.id.ivTmp1);
		ivTmp2 = (ImageView) view.findViewById(R.id.ivTmp2);
		ivTmp3 = (ImageView) view.findViewById(R.id.ivTmp3);
		ivTmp4 = (ImageView) view.findViewById(R.id.ivTmp4);
		spinner1 = (Spinner) view.findViewById(R.id.spinner1);
		return view;
	}

	@Override
	protected void initData() {
		super.initData();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, array1);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter);
	}

	@Override
	protected void bindActions() {
		super.bindActions();
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				switch (position) {
				case 0:
					ivTmp1.setScaleType(ScaleType.MATRIX);
					ivTmp2.setScaleType(ScaleType.MATRIX);
					ivTmp3.setScaleType(ScaleType.MATRIX);
					ivTmp4.setScaleType(ScaleType.MATRIX);
					break;
				case 1:

					ivTmp1.setScaleType(ScaleType.FIT_XY);
					ivTmp2.setScaleType(ScaleType.FIT_XY);
					ivTmp3.setScaleType(ScaleType.FIT_XY);
					ivTmp4.setScaleType(ScaleType.FIT_XY);
					break;

				case 2:

					ivTmp1.setScaleType(ScaleType.FIT_START);
					ivTmp2.setScaleType(ScaleType.FIT_START);
					ivTmp3.setScaleType(ScaleType.FIT_START);
					ivTmp4.setScaleType(ScaleType.FIT_START);
					break;
				case 3:

					ivTmp1.setScaleType(ScaleType.FIT_CENTER);
					ivTmp2.setScaleType(ScaleType.FIT_CENTER);
					ivTmp3.setScaleType(ScaleType.FIT_CENTER);
					ivTmp4.setScaleType(ScaleType.FIT_CENTER);
					break;
				case 4:

					ivTmp1.setScaleType(ScaleType.FIT_END);
					ivTmp2.setScaleType(ScaleType.FIT_END);
					ivTmp3.setScaleType(ScaleType.FIT_END);
					ivTmp4.setScaleType(ScaleType.FIT_END);
					break;
				case 5:

					ivTmp1.setScaleType(ScaleType.CENTER);
					ivTmp2.setScaleType(ScaleType.CENTER);
					ivTmp3.setScaleType(ScaleType.CENTER);
					ivTmp4.setScaleType(ScaleType.CENTER);
					break;
				case 6:

					ivTmp1.setScaleType(ScaleType.CENTER_CROP);
					ivTmp2.setScaleType(ScaleType.CENTER_CROP);
					ivTmp3.setScaleType(ScaleType.CENTER_CROP);
					ivTmp4.setScaleType(ScaleType.CENTER_CROP);
					break;
				case 7:

					ivTmp1.setScaleType(ScaleType.CENTER_INSIDE);
					ivTmp2.setScaleType(ScaleType.CENTER_INSIDE);
					ivTmp3.setScaleType(ScaleType.CENTER_INSIDE);
					ivTmp4.setScaleType(ScaleType.CENTER_INSIDE);
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
	}

}

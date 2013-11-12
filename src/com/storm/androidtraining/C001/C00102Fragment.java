package com.storm.androidtraining.C001;

import java.util.Random;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.cst.stormdroid.fragment.SDBaseSupportFragment;
import com.storm.androidtraining.R;

public class C00102Fragment extends SDBaseSupportFragment {
	private ViewFlipper vfTmp;
	private Button btn1;

	private Spinner spinner1;
	private Spinner spinner2;
	private String[] array1 = { "push_up_in", "push_left_in", "scalefade_in", "scalefade_in2", "rotate_in" };
	private int[] anim1 = {R.anim.push_up_in, R.anim.push_left_in, R.anim.scalefade_in, R.anim.scalefade_in2, R.anim.rotate_in};
	private String[] array2 = { "push_up_out", "push_left_out", "scalefade_out", "scalefade_out2", "rotate_out" };
	private int[] anim2 = {R.anim.push_up_out, R.anim.push_left_out, R.anim.scalefade_out, R.anim.scalefade_out2, R.anim.rotate_out};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fg_c00102, container, false);

		spinner1 = (Spinner) view.findViewById(R.id.spinner1);
		spinner2 = (Spinner) view.findViewById(R.id.spinner2);

		btn1 = (Button) view.findViewById(R.id.btn1);
		vfTmp = (ViewFlipper) view.findViewById(R.id.vfTmp);
		vfTmp.startFlipping();
		return view;
	}

	@Override
	protected void initData() {
		super.initData();

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, array1);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter);

		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, array2);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(adapter2);
	}

	@Override
	protected void bindActions() {
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				vfTmp.setInAnimation(getActivity(), anim1[position]);
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});
		spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				vfTmp.setOutAnimation(getActivity(), anim2[position]);
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});
		
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				LayoutInflater inflater = LayoutInflater.from(getActivity());
				TextView tv = (TextView) inflater.inflate(R.layout.textview, null);
				tv.setGravity(Gravity.CENTER);
				String text = String.valueOf(new Random().nextInt(1000));
				tv.setText(text);
				vfTmp.addView(tv);
			}
		});
	}

}

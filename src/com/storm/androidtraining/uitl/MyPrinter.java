package com.storm.androidtraining.uitl;

import android.widget.EditText;
import android.widget.TextView;

/**
 * printer
 * 
 * @author Storm
 * 
 */
public class MyPrinter {
	public static final StringBuilder mStringBuilder = new StringBuilder();

	public static void print(CharSequence sequence) {
		mStringBuilder.append(sequence);
	}

	public static void print(CharSequence sequence, TextView tv) {
		mStringBuilder.append(sequence);
		show(tv);
	}

	public static void println(CharSequence sequence) {
		mStringBuilder.append(sequence);
		mStringBuilder.append("\n");
	}

	public static void println(CharSequence sequence, TextView tv) {
		mStringBuilder.append(sequence);
		mStringBuilder.append("\n");
		show(tv);
	}

	public static void clear() {
		mStringBuilder.delete(0, mStringBuilder.length() - 1);
	}

	public static void clear(TextView tv) {
		clear();
		show(tv);
	}

	public static void show(TextView tv) {
		if (tv != null) {
			tv.setText(mStringBuilder.toString());
		}
	}
}

package com.storm.androidtraining;

import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cst.stormdroid.activity.SDBaseListActivity;
import com.cst.stormdroid.adapter.BaseViewHolder;
import com.cst.stormdroid.adapter.SDBaseArrayAdapter;
import com.cst.stormdroid.utils.intent.IntentUtil;
import com.cst.stormdroid.utils.string.StringUtil;

public class SubActivity extends SDBaseListActivity {
	private TextView tvTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		tvTitle = (TextView) findViewById(android.R.id.text1);
		
		String title = getIntent().getStringExtra("title");
		if(StringUtil.isValid(title)){
			tvTitle.setText(title);
		}
		
		int array = getIntent().getIntExtra("array", 0);
		
		if(array != 0){
			setListAdapter(new SubAdapter(this, Arrays.asList(getResources().getStringArray(array))));
		}
	}
	
	public static void showSubListActivity(Context context, String title, int arrayId){
		IntentUtil.Builder builder = new IntentUtil.Builder(context, SubActivity.class);
		builder.add("title", title);
		builder.add("array", arrayId);
		context.startActivity(builder.toIntent());
	}
	
	private class SubAdapter extends SDBaseArrayAdapter<BaseViewHolder, String>{

		public SubAdapter(Context ctx, List<String> list) {
			super(ctx, list);
		}

		@Override
		public View createConvertView(int position) {
			return mInflator.inflate(R.layout.listitem_default, null);
		}

		@Override
		public BaseViewHolder createViewHolder(int position, View convertView) {
			MainViewHolder holder = new MainViewHolder();
			holder.tvText = (TextView) convertView.findViewById(android.R.id.text1);
			return holder;
		}

		@Override
		public void bindViewActions(int position, BaseViewHolder viewHolder) {
		}

		@Override
		public void setViewContents(int position, BaseViewHolder viewHolder) {
			MainViewHolder holder = (MainViewHolder)viewHolder;
			holder.tvText.setText(getItem(position));
		}

		private class MainViewHolder extends BaseViewHolder{
			public TextView tvText;
		}
	}

}

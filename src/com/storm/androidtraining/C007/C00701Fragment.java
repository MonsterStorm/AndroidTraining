package com.storm.androidtraining.C007;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.cst.stormdroid.fragment.SDBaseSupportFragment;
import com.storm.androidtraining.R;

public class C00701Fragment extends SDBaseSupportFragment implements LoaderManager.LoaderCallbacks<Cursor>, OnItemClickListener {
	private EditText mEdit;
	private Button mButton;
	/*
	 * Defines an array that contains column names to move from
	 * the Cursor to the ListView.
	 */
	@SuppressLint("InlinedApi")
	private final static String[] FROM_COLUMNS = { Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ? Contacts.DISPLAY_NAME_PRIMARY : Contacts.DISPLAY_NAME };
	@SuppressLint("InlinedApi")
	private static final String[] PROJECTION = { Contacts._ID, Contacts.LOOKUP_KEY, Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ? Contacts.DISPLAY_NAME_PRIMARY : Contacts.DISPLAY_NAME };
	// Defines the text expression
	@SuppressLint("InlinedApi")
	private static final String SELECTION = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ? Contacts.DISPLAY_NAME_PRIMARY + " LIKE ?" : Contacts.DISPLAY_NAME + " LIKE ?";
	// Defines a variable for the search string
	private String mSearchString;
	// Defines the array to hold values that replace the ?
	private String[] mSelectionArgs = { mSearchString };
	/*
	 * Defines an array that contains resource ids for the layout views
	 * that get the Cursor column contents. The id is pre-defined in
	 * the Android framework, so it is prefaced with "android.R.id"
	 */
	private final static int[] TO_IDS = { android.R.id.text1 };
	// Define global mutable variables
	// Define a ListView object
	private ListView mContactsList;
	// Define variables for the contact the user selects
	// The contact's _ID value
	private long mContactId;
	// The contact's LOOKUP_KEY
	private String mContactKey;
	// A content URI for the selected contact
	private Uri mContactUri;
	// An adapter that binds the result Cursor to the ListView
	private SimpleCursorAdapter mCursorAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fg_c00701, container, false);
		mContactsList = (ListView) view.findViewById(android.R.id.list);
		mEdit = (EditText) view.findViewById(android.R.id.edit);
		mButton = (Button) view.findViewById(android.R.id.button1);
		return view;
	}

	// The column index for the _ID column
	private static final int CONTACT_ID_INDEX = 0;
	// The column index for the LOOKUP_KEY column
	private static final int LOOKUP_KEY_INDEX = 1;

	@Override
	protected void initData() {
		super.initData();
		// Gets a CursorAdapter
		mCursorAdapter = new SimpleCursorAdapter(getActivity(), R.layout.textview, null, FROM_COLUMNS, TO_IDS, 0);
		// Sets the adapter for the ListView
		mContactsList.setAdapter(mCursorAdapter);

		// click listener
		mContactsList.setOnItemClickListener(this);

		getLoaderManager().initLoader(0, null, this);
	}

	@Override
	protected void bindActions() {
		// TODO Auto-generated method stub
		super.bindActions();
		mButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mSearchString = mEdit.getText().toString();
				getLoaderManager().restartLoader(0, null, (LoaderManager.LoaderCallbacks) C00701Fragment.this);
			}
		});

	}

	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		/*
		 * Makes search string into pattern and
		 * stores it in the selection array
		 */
		mSelectionArgs[0] = "%" + mSearchString + "%";
		// Starts the query
		return new CursorLoader(getActivity(), Contacts.CONTENT_URI, PROJECTION, SELECTION, mSelectionArgs, null);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
		mCursorAdapter.swapCursor(cursor);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		mCursorAdapter.swapCursor(null);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// Get the Cursor
		Cursor cursor = ((CursorAdapter) mContactsList.getAdapter()).getCursor();
		// Move to the selected contact
		cursor.moveToPosition(position);
		// Get the _ID value
		mContactId = cursor.getLong(CONTACT_ID_INDEX);
		// Get the selected LOOKUP KEY
		mContactKey = cursor.getString(LOOKUP_KEY_INDEX);
		// Create the contact's content Uri
		mContactUri = Contacts.getLookupUri(mContactId, mContactKey);
		/*
		 * You can use mContactUri as the content URI for retrieving
		 * the details for a contact.
		 */
	}
}

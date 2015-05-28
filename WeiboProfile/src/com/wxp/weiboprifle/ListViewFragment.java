package com.wxp.weiboprifle;

import java.util.ArrayList;
import java.util.List;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListViewFragment extends Fragment {

	private ListView mListView;
	private ListAdapter mAdapter;
	private int mFragmentIndex;

	public static ListViewFragment newInstance(int index) {
		ListViewFragment fragment = new ListViewFragment();
		Bundle args = new Bundle();
		args.putInt("index", index);
		fragment.setArguments(args);
		return fragment;
	}

	public ListViewFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		List<String> listArrays = new ArrayList<String>();
		Bundle bundle = getArguments();
		if (bundle != null) {
			mFragmentIndex = bundle.getInt("index", 0);
		}
		switch (mFragmentIndex) {
		case 1:
			for (int i = 0; i < 50; i++) {
				listArrays.add(" Album : " + i + " . ");
			}
			break;
		case 2:
			for (int i = 0; i < 50; i++) {
				listArrays.add(" Status : " + i + " . ");
			}
			break;

		default:

			break;
		}
		mAdapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, android.R.id.text1,
				listArrays);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.profile_fragment_list_view,
				container, false);
		mListView = (ListView) view.findViewById(android.R.id.list);
		mListView.setAdapter(mAdapter);
		mListView.setEmptyView(view.findViewById(android.R.id.empty));
		return view;
	}

}

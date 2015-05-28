package com.wxp.weiboprifle;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private FullyListView mLv = null;
	private ObservableScrollView mScrollView = null;
	private LinearLayout mTabTop = null;

	private Button mTabButton1 = null;
	private Button mTabButton2 = null;
	private Button mTabButton3 = null;
	
	private Button mTabButtonTop1 = null;
	private Button mTabButtonTop2 = null;
	private Button mTabButtonTop3 = null;
	FragmentManager fragmentManager = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        SharedPreferences sp = getSharedPreferences("data", MODE_WORLD_READABLE|MODE_WORLD_WRITEABLE);
        sp.edit().putString("wxp", "original").commit();
        
        mLv = (FullyListView) findViewById(R.id.id_listview);
        mScrollView = (ObservableScrollView) findViewById(R.id.id_scrollview);
        mTabTop = (LinearLayout) findViewById(R.id.id_tab_rl);

        mTabButton1 = (Button) findViewById(R.id.id_tab1);
        mTabButton2 = (Button) findViewById(R.id.id_tab2);
        mTabButton3 = (Button) findViewById(R.id.id_tab3);
        mTabButtonTop1 = (Button) findViewById(R.id.id_tab_top1);
        mTabButtonTop2 = (Button) findViewById(R.id.id_tab_top2);
        mTabButtonTop3 = (Button) findViewById(R.id.id_tab_top3);
        mTabButton1.setOnClickListener(this);
        mTabButton2.setOnClickListener(this);
        mTabButton3.setOnClickListener(this);
        mTabButtonTop1.setOnClickListener(this);
        mTabButtonTop2.setOnClickListener(this);
        mTabButtonTop3.setOnClickListener(this);
        
        List<String> listArrays = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
        	listArrays.add(" -- "+i+" -- ");
		}
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, listArrays);
        //mLv.setAdapter(adapter);
      
         fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.id_fragment_container, ListViewFragment.newInstance(0)).commit();
        
        
        mScrollView.setOnScrollListener(new ObservableScrollView.OnScrollChangedListener() {
			
			@Override
			public void onScrollChanged(int x, int y, int oldX, int oldY) {
				Log.e("wxpsc", " x = " +x+" y = " +y+" oldX = " +oldX+" oldY = " +oldY);
				if (y >= dpToPx(300)) {
					Log.e("wxpsc", " 达到 300dp !");
					mTabTop.setVisibility(View.VISIBLE);
				} else {
					mTabTop.setVisibility(View.GONE);
				}
			}
		});
	}

	public float pxToDp(float px){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, getResources().getDisplayMetrics());
	}
	
	public float dpToPx(float dp){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.id_tab1:

			fragmentManager.beginTransaction().replace(R.id.id_fragment_container, ListViewFragment.newInstance(3)).commit();
	        
			break;

		case R.id.id_tab2:

			fragmentManager.beginTransaction().replace(R.id.id_fragment_container, ListViewFragment.newInstance(2)).commit();
	        
			break;
		case R.id.id_tab3:

			fragmentManager.beginTransaction().replace(R.id.id_fragment_container, ListViewFragment.newInstance(1)).commit();
	        
			break;
			
		case R.id.id_tab_top1:

			fragmentManager.beginTransaction().replace(R.id.id_fragment_container, ListViewFragment.newInstance(3)).commit();
	        
			break;

		case R.id.id_tab_top2:

			fragmentManager.beginTransaction().replace(R.id.id_fragment_container, ListViewFragment.newInstance(2)).commit();
	        
			break;
		case R.id.id_tab_top3:

			fragmentManager.beginTransaction().replace(R.id.id_fragment_container, ListViewFragment.newInstance(1)).commit();
	        
			break;
		default:
			break;
		}
		
	}
}

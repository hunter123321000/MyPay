package tabhost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import frag1.frag1_listpaid;
import frag1.frag1_qucikpaid;

import tw.com.mypay.Login;
import tw.com.mypay.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class FragmentPage1 extends Fragment {
	private GridView gv_page1;
	private Button btn_title_left;
	private int[] image = { R.drawable.quickpay, R.drawable.listpaid,
			R.drawable.prepaid };
	private String[] imgText;
	View root_view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		root_view = inflater.inflate(R.layout.fragment_1, container, false);
		return root_view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setView();

		// adapter 初始化
		imgText = getResources().getStringArray(R.array.astr_page1);
		List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < image.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", image[i]);
			item.put("text", imgText[i]);
			items.add(item);
		}
		SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), items,
				R.layout.grid_item, new String[] { "image", "text" },
				new int[] { R.id.image, R.id.text });

		// GridView 設定 adapter
		gv_page1.setAdapter(adapter);
		gv_page1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// Toast.makeText(getActivity(),
				// "Your choice is " + imgText[position],
				// Toast.LENGTH_SHORT).show();
				switch (position) {
				case 0:// 快速付款
					Intent i = new Intent();
					i.setClass(getActivity(), frag1_qucikpaid.class);
					startActivity(i);
//					getActivity().finish();
					break;
				case 1:// 清單付款
					i = new Intent();
					i.setClass(getActivity(), frag1_listpaid.class);
					startActivity(i);
//					getActivity().finish();
					break;
				case 2:// 儲值扣款
					break;
				}

			}

		});
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.tab_title);
	}

	private void setView() {
		gv_page1 = (GridView) root_view.findViewById(R.id.gv_page1);
		btn_title_left = (Button) getActivity().findViewById(
				R.id.btn_title_left);
		btn_title_left.setVisibility(View.VISIBLE);
		btn_title_left.setText(getResources().getString(R.string.btn_logout));
		btn_title_left.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClass(getActivity(), Login.class);
				startActivity(i);
				getActivity().finish();
			}
		});
	}

}

package com.icode.Ui.Activity;

import android.app.*;
import android.os.*;
import com.icode.*;
import cn.bmob.v3.*;
import com.icode.Ui.Fragment.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;

public class userActivity extends BaseActivity
{

	private BmobUser bmobUser;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		init();
	}

	private void init()
	{
		bmobUser=BmobUser.getCurrentUser(this);
		if(bmobUser!=null){
			userFragment fragment_user=new userFragment();
			getFragmentManager().beginTransaction().replace(R.id.fragmentLayout,fragment_user).commit();
			initView(bmobUser.getUsername());
		}else{
			signFragment fragment_sign=new signFragment();
			getFragmentManager().beginTransaction().replace(R.id.fragmentLayout,fragment_sign).commit();
			initView("登录");
		}
		
	}
	
	
	@Override
	protected int getLayoutRes()
	{
		return R.layout.activity_user;
	}
	
	private void initView(String Title){
		toolbar.setTitle(Title);
	}
}

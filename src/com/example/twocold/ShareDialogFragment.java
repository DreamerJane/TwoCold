package com.example.twocold;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

public class ShareDialogFragment extends DialogFragment {

	String []array = {"新浪微博","QQ好友","QQ空间","微信好友","朋友圈"};
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		builder.setTitle("分享到")
			.setNegativeButton("取消", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dismiss();
				}
			})
			.setItems(array, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getActivity(), array[which], Toast.LENGTH_SHORT).show();
				}
			});
		return builder.create();
	}

}

package com.example.twocold;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;

public class ExitDialogFragment extends DialogFragment {

	@Override
public Dialog onCreateDialog(android.os.Bundle savedInstanceState) {
	
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("确认退出")
			.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					getActivity().finish();
				}
			})
			.setNegativeButton("取消", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dismiss();
				}
			})
			.setMessage("确认退出吗？");
		return builder.create();
	}

}

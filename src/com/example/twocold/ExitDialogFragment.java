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
		builder.setTitle("ȷ���˳�")
			.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					getActivity().finish();
				}
			})
			.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dismiss();
				}
			})
			.setMessage("ȷ���˳���");
		return builder.create();
	}

}

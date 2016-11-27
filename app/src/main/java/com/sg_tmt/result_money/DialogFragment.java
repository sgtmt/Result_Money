package com.sg_tmt.result_money;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.DialogInterface;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DialogFragment extends android.support.v4.app.DialogFragment {

    public DialogFragment() {
        // Required empty public constructor
    }

    public static DialogFragment newInstance() {

        return  new DialogFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final View dialogView = LayoutInflater.from(activity).inflate(R.layout.fragment_dialog, null);

        builder.setView(dialogView)
                .setTitle("about this application")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                });
        return builder.create();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }



}

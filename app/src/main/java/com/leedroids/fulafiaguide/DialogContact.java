package com.leedroids.fulafiaguide;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogContact extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_contact, null);

        builder.setView(dialogView).setMessage("Choose");


       Button btnCallSecurity =  dialogView.findViewById(R.id.call_security);
       Button btnCallClinic =  dialogView.findViewById(R.id.call_clinic);



        btnCallSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent callIntentpolice = new Intent(Intent.ACTION_CALL);
                callIntentpolice.setData(Uri.parse("tel:123456789"));

                try {

                    startActivity(callIntentpolice);

                } catch (android.content.ActivityNotFoundException ex) {
                    Log.i("Failed,Try Again...", "");
                    Toast.makeText(getActivity(),"Failed, Try Again",Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnCallClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntentambulance = new Intent(Intent.ACTION_CALL);
                callIntentambulance.setData(Uri.parse("tel:1234"));
                try {
                    startActivity(callIntentambulance);

                } catch (android.content.ActivityNotFoundException ex) {
                    Log.i("Failed,Try Again...", "");
                    Toast.makeText(getActivity(),"Failed, Try Again",Toast.LENGTH_SHORT).show();
                }


            }
        });




        return builder.create();

    }
}

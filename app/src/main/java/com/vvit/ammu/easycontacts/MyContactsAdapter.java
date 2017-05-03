package com.vvit.ammu.easycontacts;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Ammu on 02-05-2017.
 */

public class MyContactsAdapter extends RecyclerView.Adapter<MyContactsAdapter.MyViewHolder> {

    private List<Contacts> contactsList;
    private Context firstActivity;

    public MyContactsAdapter(List<Contacts> contactsList, Context firstActivity) {

        this.contactsList = contactsList;
        this.firstActivity = firstActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Contacts contacts = contactsList.get(position);
        holder.name.setText(contacts.getName());
        holder.phone.setText(String.valueOf(contacts.getPhone()));
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+contactsList.get(position).getPhone()));
                if (ActivityCompat.checkSelfPermission(firstActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                firstActivity.startActivity(i);
            }
        });
        holder.message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                String ph = contactsList.get(position).getPhone();
                String msg = "Hi, Hello";
                smsManager.sendTextMessage(ph,null,msg,null,null);
                Toast.makeText(firstActivity,"Message sent",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name,phone;
        ImageView call,message;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.id_contact_name);
            phone = (TextView)itemView.findViewById(R.id.id_contact_phone);
            call = (ImageView) itemView.findViewById(R.id.id_call);
            message = (ImageView) itemView.findViewById(R.id.id_msg);
        }
    }
}

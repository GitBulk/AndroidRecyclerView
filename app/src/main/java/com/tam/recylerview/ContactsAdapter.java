package com.tam.recylerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by toan on 3/26/2016.
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        public TextView tvContactName;
        public Button btnMessage;

        public ContactViewHolder(View itemView) {
            super(itemView);
            tvContactName = (TextView) itemView.findViewById(R.id.tvContactName);
            btnMessage = (Button) itemView.findViewById(R.id.btnMessage);
        }
    }

    private List<Contact> contacts;

    public ContactsAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View contactView = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        ContactViewHolder holder = new ContactViewHolder(contactView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = this.contacts.get(position);
        holder.tvContactName.setText(contact.getName());
        Button button = holder.btnMessage;
        if (contact.isOnline()) {
            button.setText("Message");
            button.setEnabled(true);
        } else {
            button.setText("Offline");
            button.setEnabled(false);
        }
    }

    @Override
    public int getItemCount() {
        return this.contacts.size();
    }

}

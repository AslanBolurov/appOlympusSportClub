package com.aslanbolurov.fibonacci.appolympussportclub;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cursoradapter.widget.CursorAdapter;

import com.aslanbolurov.fibonacci.appolympussportclub.data.ClubOlympusContract;
import com.aslanbolurov.fibonacci.appolympussportclub.data.ClubOlympusContract.MemberEntry;

public class MemberCursorAdapter extends CursorAdapter {
    public MemberCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.member_item, parent,
                false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView firstNameTextView = view.findViewById(R.id.firstNameTextView);
        TextView lastNameTextView = view.findViewById(R.id.lastNameTextView);
        TextView sportTextView = view.findViewById(R.id.sportNameTextView);

        String firstName = cursor.getString
                (cursor.getColumnIndexOrThrow(MemberEntry.COLUMN_FIRST_NAME));
        String lastName = cursor.getString
                (cursor.getColumnIndexOrThrow(MemberEntry.COLUMN_LAST_NAME));
        String sport = cursor.getString
                (cursor.getColumnIndexOrThrow(MemberEntry.COLUMN_SPORT));

        firstNameTextView.setText(firstName);
        lastNameTextView.setText(lastName);
        sportTextView.setText(sport);

    }
}

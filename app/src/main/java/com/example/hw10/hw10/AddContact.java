package com.example.hw10.hw10;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by NGS on 31/05/2018.
 */

public class AddContact extends Fragment {
    EditText mEditTextName, mEditTextPhoneNumber;
    Spinner mSpinner;
    public AddContact() {}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_contact, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        mEditTextName = view.findViewById(R.id.edt_Name);
        mEditTextPhoneNumber = view.findViewById(R.id.edt_PhoneNumber);
        mSpinner = view.findViewById(R.id.spn_PhoneNumberType);
    }

    public ContentValues getContentValues() {
        ContentValues newData = new ContentValues();
        newData.put("name", mEditTextName.getText().toString());
        newData.put("phoneNumber", mEditTextPhoneNumber.getText().toString());
        newData.put("phoneType", mSpinner.getSelectedItem().toString());
        return newData;
    }
}

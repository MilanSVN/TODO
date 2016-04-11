/****************************************************************************
 *
 * Copyright (c) 2016 Elektrotehnički fakultet
 * Patre 5, Banja Luka
 *
 * All Rights Reserved
 *
 * \file NewStavka.java
 * \brief
 * Handle adding new items.
 *
 * Created on 10.04.2016.
 *
 * @Author Milan Bojic
 *
 **********************************************************************/

package net.etfbl.prs.stavka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import prs.etfbl.net.prs112709_z1.MainActivity;
import prs.etfbl.net.prs112709_z1.R;

public class NewStavka extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_stavka);

        Button addNew = (Button)findViewById(R.id.ok);
        addNew.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText mEditText;
        mEditText = (EditText)findViewById(R.id.text);

        if (mEditText != null) {
            if(mEditText.getText().toString().matches("")) {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.empty, Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                MainActivity.adapter.addStavka(new Stavka(mEditText.getText().toString()));
                Toast toast = Toast.makeText(getApplicationContext(), R.string.saved, Toast.LENGTH_SHORT);
                toast.show();
                this.finish();
            }
        }

    }
    //TODO if try to go back without saving display warning this content will not be saved
}
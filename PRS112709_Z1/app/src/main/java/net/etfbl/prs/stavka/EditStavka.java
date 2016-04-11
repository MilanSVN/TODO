/****************************************************************************
 *
 * Copyright (c) 2016 Elektrotehnički fakultet
 * Patre 5, Banja Luka
 *
 * All Rights Reserved
 *
 * \file EditStavka.java
 * \brief
 * Handle editing items.
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

public class EditStavka extends AppCompatActivity implements  View.OnClickListener {

    Stavka stavka;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_stavka);

        Button del = (Button)findViewById(R.id.del);
        del.setOnClickListener(this);

        Button ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);

        stavka = (Stavka)MainActivity.adapter.getItem(getIntent().getExtras().getInt("index"));

        text = (EditText)findViewById(R.id.text);
        text.setText(stavka.opis);

    }

     @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.ok :
                 save();
                 break;
             case R.id.del:
                 delete();
                 break;
             default:
                 break;

         }
    }

/************************************************************************
 * @brief Saves edited item.
 * @return void
 *************************************************************************/
    private void save(){
        if (text != null) {
            if(text.getText().toString().matches("")) {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.empty, Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                stavka.opis = text.getText().toString();
                stavka.gotova = false;
                Toast toast = Toast.makeText(getApplicationContext(), R.string.saved, Toast.LENGTH_SHORT);
                toast.show();
                MainActivity.adapter.notifyDataSetChanged();
                this.finish();
            }
        }

    }
/************************************************************************
     * @brief Deletes opened item.
     * @return void
**************************************************************************/
    private void delete(){
        if(MainActivity.adapter.removeItem(stavka)) {
            Toast toast = Toast.makeText(getApplicationContext(), R.string.deleted, Toast.LENGTH_SHORT);
            toast.show();
            this.finish();
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}

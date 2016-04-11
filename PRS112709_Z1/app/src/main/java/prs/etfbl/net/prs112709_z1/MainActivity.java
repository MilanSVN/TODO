package prs.etfbl.net.prs112709_z1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import net.etfbl.prs.stavka.EditStavka;
import net.etfbl.prs.stavka.NewStavka;
import net.etfbl.prs.stavka.Stavka;
import net.etfbl.prs.stavka.StavkaAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static StavkaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addNew = (Button) findViewById(R.id.addNew);
        addNew.setOnClickListener(this);

        adapter = new StavkaAdapter(this);
        adapter.addStavka(new Stavka("Prva stavka"));

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Stavka stavka = (Stavka) adapter.getItem(position);
                if (stavka.gotova) {
                    stavka.gotova = false;
                    adapter.notifyDataSetChanged();
                } else {
                    stavka.gotova = true;
                    adapter.notifyDataSetChanged();
                }
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                Intent myIntent = new Intent(MainActivity.this, EditStavka.class);
                myIntent.putExtra("index", pos); //Optional parameters
                startActivity(myIntent);

                return true;
            }
        });
    }

    @Override
       public void onClick(View v) {
        Intent intent = new Intent(this, NewStavka.class);
        startActivity(intent);

    }
}

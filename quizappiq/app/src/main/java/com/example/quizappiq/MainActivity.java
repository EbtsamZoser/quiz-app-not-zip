package com.example.quizappiq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView list;

    String[] maintitle ={"IQ Test","ICDL Test", "English Test","InterView Test", "psychological Test" };

    String[] subtitle ={"", "", "", "", ""};
    // images names in drawable folder download_1 for example
    Integer[] imgid={R.drawable.iq,R.drawable.icdl_rgb, R.drawable.english,
            R.drawable.interview,R.drawable.psychological,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListAdapter adapter=new MyListAdapter(this, maintitle, subtitle,imgid);
        //id for list from xml
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //when click on any row of array what happen
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item
                    Intent intent = new  Intent(getBaseContext(), QuizQuisition.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"IQ test",Toast.LENGTH_SHORT).show();
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getApplicationContext(),"ICDL test",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    Toast.makeText(getApplicationContext(),"English test",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {

                    Toast.makeText(getApplicationContext(),"Interview test",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {

                    Toast.makeText(getApplicationContext(),"Psychological test",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

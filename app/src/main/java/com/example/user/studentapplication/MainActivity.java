package com.example.user.studentapplication;
/*Use this appplication to populate the student database. */
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public String name1,mob,insp,cgpa,backk;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button b=(Button)findViewById(R.id.sub);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //b.setText("okay");

                EditText et1,et2,et3,et4,et5;
                et1=(EditText) findViewById(R.id.name);
                et2=(EditText) findViewById(R.id.mob);
                et3=(EditText) findViewById(R.id.cgpa);
                et4=(EditText) findViewById(R.id.insp);
                et5=(EditText) findViewById(R.id.blog);
                System.out.println("lool");


                name1=et1.getText().toString();
                mob=(et2.getText().toString());
                insp=(et4.getText().toString());
                cgpa=(et3.getText().toString());
                backk=et5.getText().toString();
                if(name1.length()<1 || mob.length()<1 || insp.length()<1 || cgpa.length()<1 || backk.length()<1)
                    Toast.makeText(getApplicationContext(),"Incomplete information",Toast.LENGTH_LONG).show();
                else if(mob.length()!=10)
                    Toast.makeText(getApplicationContext(),"Improper mobile number",Toast.LENGTH_LONG).show();
                else {

                    String AUTHORITY = "com.example.user.jobcreator.Directory";
                    String PATH = "/details";
                    Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY+PATH);
                    ContentValues con = new ContentValues();
                    con.put("_name",name1);
                    con.put("_number",mob);
                    con.put("_cgpa",cgpa);
                    con.put("_insp",insp);
                    con.put("_blog",backk);
                    Uri muri = getContentResolver().insert(CONTENT_URI,con);
                    if(muri != null){
                        Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}

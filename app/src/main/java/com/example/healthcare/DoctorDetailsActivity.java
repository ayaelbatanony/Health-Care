package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_detail1={
            {"Doctor Name:Eslam Samir","Hospital Address:Shebeen","Exp:5 do","Mobile No:77777778","600"},
            {"Doctor Name:Nor Mahmoud","Hospital Address:Cairo","Exp:8 do","Mobile No:47832874","800"},
            {"Doctor Name:Rahma Shrif","Hospital Address:Alex","Exp:10 do","Mobile No:66668888","500"},
            {"Doctor Name:Mohamed Ahmed","Hospital Address:Shebeen","Exp:7 do","Mobile No:99994444","400"},
            {"Doctor Name:Lina Ahmed","Hospital Address:Sharm","Exp:11 do","Mobile No:22224444","900"},
    };
    private String[][] doctor_detail2={
            {"Doctor Name:Samir Eslam ","Hospital Address:Shebeen","Exp:5 do","Mobile No:77777778","600"},
            {"Doctor Name:Mahmoud Nor ","Hospital Address:Cairo","Exp:8 do","Mobile No:47832874","800"},
            {"Doctor Name:Shrif Ahmed ","Hospital Address:Alex","Exp:10 do","Mobile No:66668888","500"},
            {"Doctor Name:Ahmed Mohamed ","Hospital Address:Shebeen","Exp:7 do","Mobile No:99994444","400"},
            {"Doctor Name:Ahmed Mahmoud ","Hospital Address:Sharm","Exp:11 do","Mobile No:22224444","900"},
    };
    private String[][] doctor_detail3={
            {"Doctor Name:Eslam Ahmed","Hospital Address:Shebeen","Exp:5 do","Mobile No:77777778","600"},
            {"Doctor Name:Hanin Hani","Hospital Address:Cairo","Exp:8 do","Mobile No:47832874","800"},
            {"Doctor Name:Reham Ashraf","Hospital Address:Alex","Exp:10 do","Mobile No:66668888","500"},
            {"Doctor Name:Maha Ahmed","Hospital Address:Shebeen","Exp:7 do","Mobile No:99994444","400"},
            {"Doctor Name:Asmaa Mosaa","Hospital Address:Sharm","Exp:11 do","Mobile No:22224444","900"},
    };
    private String[][] doctor_detail4={
            {"Doctor Name:Ayaa Hassan","Hospital Address:Shebeen","Exp:5 do","Mobile No:77777778","600"},
            {"Doctor Name:Yara Nagy","Hospital Address:Cairo","Exp:8 do","Mobile No:47832874","800"},
            {"Doctor Name:Adham Nor","Hospital Address:Alex","Exp:10 do","Mobile No:66668888","500"},
            {"Doctor Name:Adam Salah","Hospital Address:Shebeen","Exp:7 do","Mobile No:99994444","400"},
            {"Doctor Name:Saleh Ahmed","Hospital Address:Sharm","Exp:11 do","Mobile No:22224444","900"},
    };
    private String[][] doctor_detail5={
            {"Doctor Name:Eslam Mohamed","Hospital Address:Shebeen","Exp:5 do","Mobile No:77777778","600"},
            {"Doctor Name:Yousef Ahmed","Hospital Address:Cairo","Exp:8 do","Mobile No:47832874","800"},
            {"Doctor Name:Eman mouhamed","Hospital Address:Alex","Exp:10 do","Mobile No:66668888","500"},
            {"Doctor Name:Esraa Saed","Hospital Address:Shebeen","Exp:7 do","Mobile No:99994444","400"},
            {"Doctor Name:Esraa Ata","Hospital Address:Sharm","Exp:11 do","Mobile No:22224444","900"},
    };

 TextView tv;
 Button btn;
 String[][] doctor_details={};
 ArrayList list;
 SimpleAdapter sa;
 HashMap<String,String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);

       Intent it= getIntent();
       String title=it.getStringExtra("title");
       tv.setText(title);

       if(title.compareTo("Family Physician")==0)
           doctor_details=doctor_detail1;
       else
       if(title.compareTo("Dietician")==0)
           doctor_details=doctor_detail2;
       else
       if(title.compareTo("Dentist")==0)
           doctor_details=doctor_detail3;
       else
       if(title.compareTo("Surgeon")==0)
           doctor_details=doctor_detail4;
       else
           doctor_details=doctor_detail5;



        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list= new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons Fees"+doctor_details[i][4]+"/-");
            list.add(item);
        }
            sa=new SimpleAdapter(this,list,
                    R.layout.multi_lines,
                    new String[]{"line1","line2","line3","line4","line5"},
                    new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

            ListView lst=findViewById(R.id.listViewDD);
            lst.setAdapter(sa);
            lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                    it.putExtra("text1",title);
                    it.putExtra("text2",doctor_details[i][0]);
                    it.putExtra("text3",doctor_details[i][1]);
                    it.putExtra("text4",doctor_details[i][3]);
                    it.putExtra("text5",doctor_details[i][4]);
                    startActivity(it);
                }
            });



    }
}
package tw.edu.fcu.lukeway.thesunrise;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //ListView 要顯示的內容　改到全域變數
    public String[] str = {"合歡山 小風口停車場","合歡山 武嶺亭","合歡山 昆陽休息站","合歡山 合歡山莊(松雪樓)","陽明山 擎天崗草原", "..."};
    public static ArrayList<SunData> sunData = new ArrayList<SunData>();
    public String nowDay;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSunFromFirebase();//firebase

        ListView listview = (ListView) findViewById(R.id.listview);

        //取得現在日期
        Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);

        int month = c.get(Calendar.MONTH)+1;      //當前月份

        int day = c.get(Calendar.DAY_OF_MONTH); //當前日期

        if(month<10)
            nowDay = year+"-0"+month+"-"+day;
        else
            nowDay = year+"-"+month+"-"+day;

        //Log.v("Date",Integer.toString(month)+Integer.toString(day));

        //android.R.layout.simple_list_item_1 為內建樣式，還有其他樣式可自行研究
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                str);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(onClickListView);       //指定事件 Method

        dialog = ProgressDialog.show(MainActivity.this,
                "讀取中", "讀取中請等待...",true);
        new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    //Thread.sleep(8000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void getSunFromFirebase() {//firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int i=0;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    //DataSnapshot dsNo = ds.child("No");
                    DataSnapshot dsSpec = ds.child("Spec");
                    DataSnapshot dsDate = ds.child("date");
                    DataSnapshot dsUp = ds.child("日出時刻");
                    DataSnapshot dsDown = ds.child("日沒時刻");

                    SunData data = new SunData((String) dsSpec.getValue(), (String) dsDate.getValue(), (String) dsUp.getValue(), (String) dsDown.getValue());
                    sunData.add(data);

                    //String No = (String) dsNo.getValue();
                    Log.v("測試",    sunData.get(i).getSpec() + ";" + sunData.get(i).getDate() + ";" + sunData.get(i).getUptime() + ";" + sunData.get(i).getDowntime());
                    i++;
                }
                //Log.v("count", Integer.toString(sunData.size()));
                dialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v("測試", databaseError.getMessage());
            }
        });
    }

    /***
     * 點擊ListView事件Method
     */
    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Toast 快顯功能 第三個參數 Toast.LENGTH_SHORT 2秒  LENGTH_LONG 5秒
            //Toast.makeText(MainActivity.this,"點選第 "+(position +1) +" 個 \n內容："+str[position], Toast.LENGTH_SHORT).show();
/////如果選擇第N個選項，各傳不同的值進去////////////////////////////////////////////////////////
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ChooseActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("Choose_num", position +1);
            int index =getDateForTimeIndex(position+1, sunData, nowDay);
            bundle.putString("UpTime", sunData.get(index).getUptime());
            bundle.putString("DownTime", sunData.get(index).getDowntime());
            intent.putExtras(bundle);
            startActivity(intent);
            //MainActivity.this.finish();
/////////////////////////////////////////////////////////////////////////////////////
        }
    };

    private int getDateForTimeIndex(int choose_num, ArrayList<SunData> sunData, String nowDay) {
        switch (choose_num){
            case 1:
            case 2:
            case 3:
            case 4:
                for (int i = 0; i < sunData.size(); i++) {
                    if (sunData.get(i).getSpec().equals("南投") && sunData.get(i).getDate().equals(nowDay)) {
                        return i;
                    }
                }
                break;
            case 5:
                for (int i = 0; i < sunData.size(); i++) {
                    if (sunData.get(i).getSpec().equals("新北市") && sunData.get(i).getDate().equals(nowDay)) {
                        return i;
                    }
                }
                break;
        }
        return -1;
    }

    /*ArrayAdapter <String> adapter;
    String[] name = {"A地點", "B地點", "C地點", "D地點", "E地點"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.spinner_place);
        ArrayAdapter<CharSequence> lunchList = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.spinner_place,
                R.layout.myspinner);
        spinner.setAdapter(lunchList);
        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,name);

        spinner.setAdapter(adapter);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:

                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }
        });
    }*/
}


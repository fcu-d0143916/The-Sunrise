package tw.edu.fcu.lukeway.thesunrise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ChooseActivity extends AppCompatActivity {

    public String weatherIconMorning;
    public String weatherIconNight;
    public String temperatureMorningHigh;
    public String temperatureMorningDown;
    public String temperatureNightHigh;
    public String temperatureNightDown;
    public String rainProbabilityMorning;
    public String rainProbabilityNight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        Bundle bundle = this.getIntent().getExtras();
        final int choose_num = bundle.getInt("Choose_num");
        String upTime = bundle.getString("UpTime");
        String downTime = bundle.getString("DownTime");
        weatherIconMorning = bundle.getString("weatherIconMorning");
        weatherIconNight = bundle.getString("weatherIconNight");
        temperatureMorningHigh = bundle.getString("temperatureMorningHigh");
        temperatureMorningDown = bundle.getString("temperatureMorningDown");
        temperatureNightHigh = bundle.getString("temperatureNightHigh");
        temperatureNightDown = bundle.getString("temperatureNightDown");
        rainProbabilityMorning = bundle.getString("rainProbabilityMorning");
        rainProbabilityNight = bundle.getString("rainProbabilityNight");
        String placeName = bundle.getString("Name");

        ///////////////////////////////////////////////////////////////天氣、影像、地圖三個按鈕
        Button btn_weather = (Button) findViewById(R.id.btm_weather);
        Button btm_liveimage = (Button) findViewById(R.id.btm_liveimage);
        Button btm_map = (Button) findViewById(R.id.btm_map);





        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//中央氣象局
                Intent intent = new Intent();
                intent.setClass(ChooseActivity.this, WeatherActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("weatherIconMorning",weatherIconMorning);
                bundle.putString("weatherIconNight",weatherIconNight);
                bundle.putString("temperatureMorningHigh",temperatureMorningHigh);
                bundle.putString("temperatureMorningDown",temperatureMorningDown);
                bundle.putString("temperatureNightHigh",temperatureNightHigh);
                bundle.putString("temperatureNightDown",temperatureNightDown);
                bundle.putString("rainProbabilityMorning",rainProbabilityMorning);
                bundle.putString("rainProbabilityNight",rainProbabilityNight);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btm_liveimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//即時影像
                Intent intent = new Intent();
                intent.setClass(ChooseActivity.this, WebLoad.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Choose_num", choose_num);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btm_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//地圖
                Intent intent = new Intent();
                intent.setClass(ChooseActivity.this, MapsActivity_new.class);
                //intent.setClass(ChooseActivity.this, WebLoad.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Choose_num", choose_num);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        ///////////////////////////////////////////////////////////////
        TextView uptime = (TextView)findViewById(R.id.up_time);// 取得 日出資料
        TextView downtime = (TextView)findViewById(R.id.down_time);// 取得 日沒資料
        TextView place = (TextView) findViewById(R.id.placename);

        uptime.setText(upTime);
        downtime.setText(downTime);
        place.setText("地點：" + placeName);
    }



}

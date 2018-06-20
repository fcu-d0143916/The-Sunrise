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

    public String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        ///////////////////////////////////////////////////////////////////////////////
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");

        Date curDate = new Date(System.currentTimeMillis()) ; // 獲取當前時間

        String str = formatter.format(curDate);

        Toast.makeText(ChooseActivity.this,"目前日期：" + str, Toast.LENGTH_LONG).show();
        ////////////////////////////////////////////////////////////////////////////////

        Bundle bundle = this.getIntent().getExtras();
        final int choose_num = bundle.getInt("Choose_num");
        String upTime = bundle.getString("UpTime");
        String downTime = bundle.getString("DownTime");
        ///////////////////////////////////////////////////////////////天氣、影像、地圖三個按鈕
        Button btn_weather = (Button) findViewById(R.id.btm_weather);
        Button btm_liveimage = (Button) findViewById(R.id.btm_liveimage);
        Button btm_map = (Button) findViewById(R.id.btm_map);

        switch (choose_num){
            case 1:
                url = "https://www.cwb.gov.tw//V7/forecast/entertainment/7Day/F002.htm";
                break;
            case 2:
                url = "https://www.cwb.gov.tw//V7/forecast/entertainment/7Day/F002.htm";
                break;
            case 3:
                url = "https://www.cwb.gov.tw//V7/forecast/entertainment/7Day/F002.htm";
                break;
            case 4:
                url = "https://www.cwb.gov.tw//V7/forecast/entertainment/7Day/D028.htm";
                break;
            case 5:
                url = "https://www.cwb.gov.tw//V7/forecast/entertainment/7Day/F023.htm";
        }

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect(url).get();
                    Elements elements = doc.select("div.Forecast-box");
                    //早上天氣圖片
                    weatherIconMorning = "https://www.cwb.gov.tw/" + elements.select("table").select("tbody").select("tr").get(2).select("td").get(1).select("img").attr("src");
                    //晚上天氣圖片
                    weatherIconNight = "https://www.cwb.gov.tw/" + elements.select("table").select("tbody").select("tr").get(2).select("td").get(2).select("img").attr("src");
                    //早上最高溫
                    temperatureMorningHigh = elements.select("table").select("tbody").select("tr").get(3).select("td").get(1).text();
                    //早上最低溫
                    temperatureMorningDown = elements.select("table").select("tbody").select("tr").get(4).select("td").get(1).text();
                    //晚上最高溫
                    temperatureNightHigh = elements.select("table").select("tbody").select("tr").get(3).select("td").get(2).text();
                    //晚上最低溫
                    temperatureNightDown = elements.select("table").select("tbody").select("tr").get(4).select("td").get(2).text();
                    //早上降雨機率
                    rainProbabilityMorning = elements.select("table").select("tbody").select("tr").get(10).select("td").get(1).text();
                    //晚上降雨機率
                    rainProbabilityNight = elements.select("table").select("tbody").select("tr").get(10).select("td").get(2).text();
                    Log.v("mytag",weatherIconMorning+";"+weatherIconNight+";"+temperatureMorningHigh+";"+temperatureMorningDown+";"+temperatureNightHigh+";"+temperatureNightDown+";"+rainProbabilityMorning+";"+rainProbabilityNight);
                }catch(Exception e) {
                    Log.v("mytagError", e.toString());
                }
            }
        }).start();

        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//中央氣象局
                Intent intent = new Intent();
                intent.setClass(ChooseActivity.this, WeatherActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Choose_num", choose_num);
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

        uptime.setText(upTime);
        downtime.setText(downTime);
        /*
        if(choose_num == 1) {//合歡山 小風口停車場
            uptime.setText(upTime);
            downtime.setText(downTime);
        }
        else if(choose_num == 2) {//合歡山 武嶺亭
            uptime.setText("??:??");
            downtime.setText("??:??");
        }
        else if(choose_num == 3) {//合歡山 昆陽休息站
            uptime.setText("??:??");
            downtime.setText("??:??");
        }
        else if(choose_num == 4) {//合歡山 合歡山莊(松雪樓)
            uptime.setText("??:??");
            downtime.setText("??:??");
        }
        else if(choose_num == 5) {//陽明山 擎天崗草原
            uptime.setText("??:??");
            downtime.setText("??:??");
        }*/

        //測試值是否有傳過來
        //Toast.makeText(ChooseActivity.this,"點選第 "+(choose_num) +" 個 \n內容："+choose_num, Toast.LENGTH_SHORT).show();
    }



}

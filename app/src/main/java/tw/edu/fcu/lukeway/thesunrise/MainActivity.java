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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //ListView 要顯示的內容　改到全域變數
    public String[] str = {"合歡山 小風口停車場","合歡山 武嶺亭","合歡山 昆陽休息站","合歡山 合歡山莊(松雪樓)","陽明山 擎天崗草原", "..."};
    public static ArrayList<SunData> sunData = new ArrayList<SunData>();
    public static ArrayList<WeatherData> weatherData = new ArrayList<WeatherData>();
    public String nowDay;
    private Dialog dialog;

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

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    for(int i=1;i<=str.length;i++) {
                        switch (i){
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
                        Log.v("mytag", weatherIconMorning + ";" + weatherIconNight + ";" + temperatureMorningHigh + ";" + temperatureMorningDown + ";" + temperatureNightHigh + ";" + temperatureNightDown + ";" + rainProbabilityMorning + ";" + rainProbabilityNight);
                        WeatherData weather = new WeatherData(weatherIconMorning, weatherIconNight, temperatureMorningHigh, temperatureMorningDown, temperatureNightHigh, temperatureNightDown, rainProbabilityMorning, rainProbabilityNight);
                        weatherData.add(weather);
                    }
                    dialog.dismiss();
                }catch(Exception e) {
                    Log.v("mytagError", e.toString());
                }
            }
        }).start();

        dialog = ProgressDialog.show(MainActivity.this,
                "讀取中", "讀取中...",true);

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
            bundle.putString("weatherIconMorning",weatherData.get(position).getWeatherIconMorning());
            bundle.putString("weatherIconNight",weatherData.get(position).getWeatherIconNight());
            bundle.putString("temperatureMorningHigh",weatherData.get(position).getTemperatureMorningHigh());
            bundle.putString("temperatureMorningDown",weatherData.get(position).getTemperatureMorningDown());
            bundle.putString("temperatureNightHigh",weatherData.get(position).getTemperatureNightHigh());
            bundle.putString("temperatureNightDown",weatherData.get(position).getTemperatureNightDown());
            bundle.putString("rainProbabilityMorning",weatherData.get(position).getRainProbabilityMorning());
            bundle.putString("rainProbabilityNight",weatherData.get(position).getRainProbabilityNight());
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


package tw.edu.fcu.lukeway.thesunrise;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherActivity extends AppCompatActivity {

    public String weatherIconMorning;
    public String weatherIconNight;
    public String temperatureMorningHigh;
    public String temperatureMorningDown;
    public String temperatureNightHigh;
    public String temperatureNightDown;
    public String rainProbabilityMorning;
    public String rainProbabilityNight;

    public ImageView img_morning;
    public ImageView img_night;
    public TextView morning_high;
    public TextView morning_down;
    public TextView morning_rain;
    public TextView night_high;
    public TextView night_down;
    public TextView night_rain;


    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        //註冊
        img_morning = (ImageView) findViewById(R.id.image_weather_morning);
        img_night = (ImageView) findViewById(R.id.image_weather_night);
        morning_high = (TextView) findViewById(R.id.weatherMorningHigh);
        morning_down = (TextView) findViewById(R.id.weatherMorningDown);
        morning_rain = (TextView) findViewById(R.id.rainProbabilityMorning);
        night_high = (TextView) findViewById(R.id.weatherNightHigh);
        night_down = (TextView) findViewById(R.id.weatherNightDown);
        night_rain = (TextView) findViewById(R.id.rainProbabilityNight);

        Bundle bundle = this.getIntent().getExtras();
        weatherIconMorning = bundle.getString("weatherIconMorning");
        weatherIconNight = bundle.getString("weatherIconNight");
        temperatureMorningHigh = bundle.getString("temperatureMorningHigh");
        temperatureMorningDown = bundle.getString("temperatureMorningDown");
        temperatureNightHigh = bundle.getString("temperatureNightHigh");
        temperatureNightDown = bundle.getString("temperatureNightDown");
        rainProbabilityMorning = bundle.getString("rainProbabilityMorning");
        rainProbabilityNight = bundle.getString("rainProbabilityNight");

        //建立一個AsyncTask執行緒進行圖片讀取動作，並帶入圖片連結網址路徑
        new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... params) {
                String url = params[0];
                return getBitmapFromURL(url);
            }

            @Override
            protected void onPostExecute(Bitmap result) {
                img_morning.setImageBitmap(result);
                super.onPostExecute(result);
            }
        }.execute(weatherIconMorning);
        new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... params) {
                String url = params[0];
                return getBitmapFromURL(url);
            }

            @Override
            protected void onPostExecute(Bitmap result) {
                img_night.setImageBitmap(result);
                super.onPostExecute(result);
            }
        }.execute(weatherIconNight);
        morning_high.setText(temperatureMorningHigh);
        morning_down.setText(temperatureMorningDown);
        morning_rain.setText(rainProbabilityMorning);
        night_high.setText(temperatureNightHigh);
        night_down.setText(temperatureNightDown);
        night_rain.setText(rainProbabilityNight);
    }

    //讀取網路圖片，型態為Bitmap
    private static Bitmap getBitmapFromURL(String imageUrl)
    {
        try
        {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }


}

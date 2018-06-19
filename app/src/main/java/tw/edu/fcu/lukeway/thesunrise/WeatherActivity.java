package tw.edu.fcu.lukeway.thesunrise;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherActivity extends AppCompatActivity {

    private Button button;

    private ImageView img;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Bundle bundle = this.getIntent().getExtras();
        final int choose_num = bundle.getInt("Choose_num");

        Button nextPageBtn = (Button)findViewById(R.id.button_web);
        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(WeatherActivity.this, WebWeather.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Choose_num", choose_num);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        img = (ImageView) findViewById(R.id.image_weather);

        if (choose_num == 1) {
            //建立一個AsyncTask執行緒進行圖片讀取動作，並帶入圖片連結網址路徑
            new AsyncTask<String, Void, Bitmap>() {
                @Override
                protected Bitmap doInBackground(String... params) {
                    String url = params[0];
                    return getBitmapFromURL(url);
                }

                @Override
                protected void onPostExecute(Bitmap result) {
                    img.setImageBitmap(result);
                    super.onPostExecute(result);
                }
            }.execute("https://www.cwb.gov.tw/V7/symbol/weather/gif/day/18.gif");
        }


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

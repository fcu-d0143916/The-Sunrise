package tw.edu.fcu.lukeway.thesunrise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class WebWeather extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_weather);

        Bundle bundle = this.getIntent().getExtras();
        final int choose_num = bundle.getInt("Choose_num");

        WebView webview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //setContentView(webview);
        webview.setWebViewClient(new WebViewClient());
        //webview.loadUrl("https://google.com");

        if (choose_num == 1) {//合歡山 小風口停車場
            webview.loadUrl("https://www.cwb.gov.tw/V7/forecast/entertainment/other/F002.htm");
            //webview.loadUrl("http://117.56.55.25/T14A-36K+560");
        }
        if (choose_num == 2) {//合歡山 武嶺亭
            //webview.loadUrl("file:///android_asset/webview_2.html");
            Toast.makeText(WebWeather.this,"此資料無中央氣象局網站頁面。", Toast.LENGTH_LONG).show();
            finish();
        }
        if (choose_num == 3) {//合歡山 昆陽休息站
            //webview.loadUrl("file:///android_asset/webview_2.html");
            Toast.makeText(WebWeather.this,"此資料無中央氣象局網站頁面。", Toast.LENGTH_LONG).show();
            finish();
        }
        if(choose_num == 4) {//合歡山 合歡山莊(松雪樓)
            webview.loadUrl("https://www.cwb.gov.tw/V7/forecast/entertainment/other/D028.htm");
        }
        if(choose_num == 5) {//陽明山 擎天崗草原
            webview.loadUrl("https://www.cwb.gov.tw/V7/forecast/entertainment/other/F023.htm");
        }
    }

}

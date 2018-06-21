package tw.edu.fcu.lukeway.thesunrise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class WebLoad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_load);

        TextView place = (TextView)findViewById(R.id.place_text_video);// 取得 地點名稱

        Bundle bundle = this.getIntent().getExtras();
        final int choose_num = bundle.getInt("Choose_num");

        switch (choose_num) {
            case 1:
                place.setText("合歡山 小風口停車場");
                break;
            case 2:
                place.setText("合歡山 武嶺亭");
                break;
            case 3:
                place.setText("合歡山 昆陽休息站");
                break;
            case 4:
                place.setText("合歡山 合歡山莊(松雪樓)");
                break;
            case 5:
                place.setText("陽明山 擎天崗草原");
                break;
            case 6:
                place.setText("陽明山 陽明書屋");
                break;
            case 7:
                place.setText("陽明山 大屯自然公園");
                break;
            case 8:
                place.setText("陽明山 遠眺七星山");
                break;
            case 9:
                place.setText("雪霸 武陵遊客中心");
                break;
            case 10:
                place.setText("雪霸 汶水遊客中心");
                break;
            case 11:
                place.setText("雪霸 雪見遊客中心");
                break;
            case 12:
                place.setText("雪霸 觀霧遊客中心");
                break;
            case 13:
                place.setText("龍潭湖風景區");
                break;
            case 14:
                place.setText("遠眺龜山島");
                break;
            case 15:
                place.setText("羅東夜市入口");
                break;
            case 16:
                place.setText("羅東中山公園");
        }

        WebView webview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //setContentView(webview);
        webview.setWebViewClient(new WebViewClient());

        switch (choose_num) {
            case 1:
                webview.loadUrl("file:///android_asset/webview_1.html");
                break;
            case 2:
                webview.loadUrl("file:///android_asset/webview_2.html");
                break;
            case 3:
                webview.loadUrl("file:///android_asset/webview_3.html");
                break;
            case 4:
                webview.loadUrl("file:///android_asset/webview_4.html");
                break;
            case 5:
                webview.loadUrl("file:///android_asset/webview_5.html");
                break;
            case 6:
                webview.loadUrl("file:///android_asset/webview_6.html");
                break;
            case 7:
                webview.loadUrl("file:///android_asset/webview_7.html");
                break;
            case 8:
                webview.loadUrl("file:///android_asset/webview_8.html");
                break;
            case 9:
                webview.loadUrl("file:///android_asset/webview_9.html");
                break;
            case 10:
                webview.loadUrl("file:///android_asset/webview_10.html");
                break;
            case 11:
                webview.loadUrl("file:///android_asset/webview_11.html");
                break;
            case 12:
                webview.loadUrl("file:///android_asset/webview_12.html");
                break;
            case 13:
                webview.loadUrl("file:///android_asset/webview_13.html");
                break;
            case 14:
                webview.loadUrl("file:///android_asset/webview_14.html");
                break;
            case 15:
                webview.loadUrl("file:///android_asset/webview_15.html");
                break;
            case 16:
                webview.loadUrl("file:///android_asset/webview_16.html");
        }
    }
}

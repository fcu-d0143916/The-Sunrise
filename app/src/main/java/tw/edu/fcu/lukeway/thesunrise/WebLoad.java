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

        if(choose_num == 1) {
            place.setText("合歡山 小風口停車場");
        }
        if(choose_num == 2) {
            place.setText("合歡山 武嶺亭");
        }
        if(choose_num == 3) {
            place.setText("合歡山 昆陽休息站");
        }
        if(choose_num == 4) {
            place.setText("合歡山 合歡山莊(松雪樓)");
        }
        if(choose_num == 5) {
            place.setText("陽明山 擎天崗草原");
        }
        if(choose_num == 6) {
            place.setText("陽明山 陽明書屋");
        }
        if(choose_num == 7) {
            place.setText("陽明山 大屯自然公園");
        }
        if(choose_num == 8) {
            place.setText("陽明山 遠眺七星山");
        }
        if(choose_num == 9) {
            place.setText("雪霸 武陵遊客中心");
        }
        if(choose_num == 10) {
            place.setText("雪霸 汶水遊客中心");
        }
        if(choose_num == 11) {
            place.setText("雪霸 雪見遊客中心");
        }
        if(choose_num == 12) {
            place.setText("雪霸 觀霧遊客中心");
        }
        if(choose_num == 13) {
            place.setText("龍潭湖風景區");
        }
        if(choose_num == 14) {
            place.setText("遠眺龜山島");
        }
        if(choose_num == 15) {
            place.setText("羅東夜市入口");
        }
        if(choose_num == 16) {
            place.setText("羅東中山公園");
        }

        WebView webview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //setContentView(webview);
        webview.setWebViewClient(new WebViewClient());
        //webview.loadUrl("https://google.com");

        if (choose_num == 1) {//合歡山 小風口停車場
            webview.loadUrl("file:///android_asset/webview_1.html");
            //webview.loadUrl("http://117.56.55.25/T14A-36K+560");
        }
        if (choose_num == 2) {//合歡山 武嶺亭
            webview.loadUrl("file:///android_asset/webview_2.html");
        }
        if (choose_num == 3) {//合歡山 昆陽休息站
            webview.loadUrl("file:///android_asset/webview_3.html");
        }
        if (choose_num == 4) {//合歡山 合歡山莊(松雪樓)
            webview.loadUrl("file:///android_asset/webview_4.html");
        }
        if (choose_num == 5) {//陽明山 擎天崗草原
            webview.loadUrl("file:///android_asset/webview_5.html");
        }
        if (choose_num == 6) {//陽明山 陽明書屋
            webview.loadUrl("file:///android_asset/webview_6.html");
        }
        if (choose_num == 7) {//陽明山 大屯自然公園
            webview.loadUrl("file:///android_asset/webview_7.html");
        }
        if (choose_num == 8) {//陽明山 遠眺七星山
            webview.loadUrl("file:///android_asset/webview_8.html");
        }
        if (choose_num == 9) {//雪霸 武陵遊客中心
            webview.loadUrl("file:///android_asset/webview_9.html");
        }
        if (choose_num == 10) {//雪霸 汶水遊客中心
            webview.loadUrl("file:///android_asset/webview_10.html");
        }
        if (choose_num == 11) {//雪霸 雪見遊客中心
            webview.loadUrl("file:///android_asset/webview_11.html");
        }
        if (choose_num == 12) {//雪霸 觀霧遊客中心
            webview.loadUrl("file:///android_asset/webview_12.html");
        }
        if (choose_num == 13) {//龍潭湖風景區
            webview.loadUrl("file:///android_asset/webview_13.html");
        }
        if (choose_num == 14) {//遠眺龜山島
            webview.loadUrl("file:///android_asset/webview_14.html");
        }
        if (choose_num == 15) {//羅東夜市入口
            webview.loadUrl("file:///android_asset/webview_15.html");
        }
        if (choose_num == 16) {//羅東中山公園
            webview.loadUrl("file:///android_asset/webview_16.html");
        }
    }
}

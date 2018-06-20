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
    }
}

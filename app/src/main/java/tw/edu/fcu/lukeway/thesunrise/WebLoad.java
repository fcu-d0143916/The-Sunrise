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

        WebView webview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //setContentView(webview);
        webview.setWebViewClient(new WebViewClient());
        //webview.loadUrl("https://google.com");

        if (choose_num == 1) {
            //webview.loadUrl("file:///android_asset/test.html");
            webview.loadUrl("http://117.56.55.25/T14A-36K+560");
        }
    }
}

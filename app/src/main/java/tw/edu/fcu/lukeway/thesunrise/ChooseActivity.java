package tw.edu.fcu.lukeway.thesunrise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        Bundle bundle = this.getIntent().getExtras();
        final int choose_num = bundle.getInt("Choose_num");
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
                bundle.putInt("Choose_num", choose_num);
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

        if(choose_num == 1) {//合歡山 小風口停車場
            uptime.setText("??:??");
            downtime.setText("??:??");
        }
        if(choose_num == 2) {//合歡山 武嶺亭
            uptime.setText("??:??");
            downtime.setText("??:??");
        }

        //測試值是否有傳過來
        //Toast.makeText(ChooseActivity.this,"點選第 "+(choose_num) +" 個 \n內容："+choose_num, Toast.LENGTH_SHORT).show();
    }


}

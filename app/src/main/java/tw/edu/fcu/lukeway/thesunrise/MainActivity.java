package tw.edu.fcu.lukeway.thesunrise;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    //ListView 要顯示的內容　改到全域變數
    public String[] str = {"合歡山 小風口停車場","合歡山 武嶺亭","合歡山 昆陽休息站","合歡山 合歡山莊(松雪樓)","陽明山 擎天崗草原", "..."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView) findViewById(R.id.listview);

        //android.R.layout.simple_list_item_1 為內建樣式，還有其他樣式可自行研究
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                str);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(onClickListView);       //指定事件 Method

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
            intent.putExtras(bundle);
            startActivity(intent);
            //MainActivity.this.finish();
/////////////////////////////////////////////////////////////////////////////////////
        }
    };

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


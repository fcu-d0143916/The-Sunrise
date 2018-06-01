package tw.edu.fcu.lukeway.thesunrise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        Bundle bundle = this.getIntent().getExtras();
        int choose_num = bundle.getInt("Choose_num");
        //測試值是否有傳過來
        Toast.makeText(ChooseActivity.this,"點選第 "+(choose_num) +" 個 \n內容："+choose_num, Toast.LENGTH_SHORT).show();
    }
}

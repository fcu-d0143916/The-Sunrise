package tw.edu.fcu.lukeway.thesunrise;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity_new extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_new);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        TextView place = (TextView)findViewById(R.id.place_text_2);// 取得 地點名稱



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
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Bundle bundle = this.getIntent().getExtras();
        final int choose_num = bundle.getInt("Choose_num");

        if(choose_num == 1) {//合歡山 小風口停車場
            LatLng sydney = new LatLng(24.162484, 121.287288);
            mMap.addMarker(new MarkerOptions().position(sydney).title("合歡山 小風口"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 2) {//合歡山 武嶺亭
            LatLng sydney = new LatLng(24.137175, 121.275894);
            mMap.addMarker(new MarkerOptions().position(sydney).title("合歡山 武嶺亭"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 3) {//合歡山 昆陽休息站
            LatLng sydney = new LatLng(24.123044, 121.272515);
            mMap.addMarker(new MarkerOptions().position(sydney).title("合歡山 昆陽休息站"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 4) {//合歡山 合歡山莊
            LatLng sydney = new LatLng(24.142161, 121.284291);
            mMap.addMarker(new MarkerOptions().position(sydney).title("合歡山 合歡山莊(松雪樓)"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 5) {//陽明山 擎天崗草原
            LatLng sydney = new LatLng(25.167239, 121.574215);
            mMap.addMarker(new MarkerOptions().position(sydney).title("陽明山 擎天崗草原"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 6) {//陽明山 陽明書屋
            LatLng sydney = new LatLng(25.161623, 121.538937);
            mMap.addMarker(new MarkerOptions().position(sydney).title("陽明山 陽明書屋"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }


        // Add a marker in Sydney and move the camera


        mMap.getUiSettings().setZoomControlsEnabled(true);  // 右下角的放大縮小功能
        mMap.getUiSettings().setCompassEnabled(true);       // 左上角的指南針，要兩指旋轉才會出現
        mMap.getUiSettings().setMapToolbarEnabled(true);    // 右下角的導覽及開啟 Google Map功能


        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));     // 放大地圖到 16 倍大
    }
}

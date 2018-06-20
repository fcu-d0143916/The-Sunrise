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
        if(choose_num == 7) {//陽明山 大屯自然公園
            LatLng sydney = new LatLng(25.186847, 121.523013);
            mMap.addMarker(new MarkerOptions().position(sydney).title("陽明山 大屯自然公園"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 8) {//陽明山 遠眺七星山
            LatLng sydney = new LatLng(25.170837, 121.553333);
            mMap.addMarker(new MarkerOptions().position(sydney).title("陽明山 遠眺七星山"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 9) {//雪霸 武陵遊客中心
            LatLng sydney = new LatLng(25.170837, 121.553333);
            mMap.addMarker(new MarkerOptions().position(sydney).title("雪霸 武陵遊客中心"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 10) {//雪霸 汶水遊客中心
            LatLng sydney = new LatLng(24.451872, 120.876670);
            mMap.addMarker(new MarkerOptions().position(sydney).title("雪霸 汶水遊客中心"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 11) {//雪霸 雪見遊客中心
            LatLng sydney = new LatLng(24.424732, 121.013441);
            mMap.addMarker(new MarkerOptions().position(sydney).title("雪霸 雪見遊客中心"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 12) {//雪霸 觀霧遊客中心
            LatLng sydney = new LatLng(24.424732, 121.013441);
            mMap.addMarker(new MarkerOptions().position(sydney).title("雪霸 觀霧遊客中心"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 13) {//龍潭湖風景區
            LatLng sydney = new LatLng(24.794766, 121.740206);
            mMap.addMarker(new MarkerOptions().position(sydney).title("龍潭湖風景區"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 14) {//遠眺龜山島
            LatLng sydney = new LatLng(24.843290, 121.950137);
            mMap.addMarker(new MarkerOptions().position(sydney).title("遠眺龜山島"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 15) {//羅東夜市入口
            LatLng sydney = new LatLng(24.676489, 121.768647);
            mMap.addMarker(new MarkerOptions().position(sydney).title("羅東夜市入口"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        if(choose_num == 16) {//羅東中山公園
            LatLng sydney = new LatLng(24.676672, 121.769018);
            mMap.addMarker(new MarkerOptions().position(sydney).title("羅東中山公園"));
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

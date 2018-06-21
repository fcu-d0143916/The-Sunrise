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
        LatLng sydney;

        switch (choose_num) {
            case 1:
                sydney = new LatLng(24.162484, 121.287288);
                mMap.addMarker(new MarkerOptions().position(sydney).title("合歡山 小風口"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 2:
                sydney = new LatLng(24.137175, 121.275894);
                mMap.addMarker(new MarkerOptions().position(sydney).title("合歡山 武嶺亭"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 3:
                sydney = new LatLng(24.123044, 121.272515);
                mMap.addMarker(new MarkerOptions().position(sydney).title("合歡山 昆陽休息站"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 4:
                sydney = new LatLng(24.142161, 121.284291);
                mMap.addMarker(new MarkerOptions().position(sydney).title("合歡山 合歡山莊(松雪樓)"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 5:
                sydney = new LatLng(25.167239, 121.574215);
                mMap.addMarker(new MarkerOptions().position(sydney).title("陽明山 擎天崗草原"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 6:
                sydney = new LatLng(25.161623, 121.538937);
                mMap.addMarker(new MarkerOptions().position(sydney).title("陽明山 陽明書屋"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 7:
                sydney = new LatLng(25.186847, 121.523013);
                mMap.addMarker(new MarkerOptions().position(sydney).title("陽明山 大屯自然公園"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 8:
                sydney = new LatLng(25.170837, 121.553333);
                mMap.addMarker(new MarkerOptions().position(sydney).title("陽明山 遠眺七星山"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 9:
                sydney = new LatLng(25.170837, 121.553333);
                mMap.addMarker(new MarkerOptions().position(sydney).title("雪霸 武陵遊客中心"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 10:
                sydney = new LatLng(24.451872, 120.876670);
                mMap.addMarker(new MarkerOptions().position(sydney).title("雪霸 汶水遊客中心"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 11:
                sydney = new LatLng(24.424732, 121.013441);
                mMap.addMarker(new MarkerOptions().position(sydney).title("雪霸 雪見遊客中心"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 12:
                sydney = new LatLng(24.424732, 121.013441);
                mMap.addMarker(new MarkerOptions().position(sydney).title("雪霸 觀霧遊客中心"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 13:
                sydney = new LatLng(24.794766, 121.740206);
                mMap.addMarker(new MarkerOptions().position(sydney).title("龍潭湖風景區"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 14:
                sydney = new LatLng(24.843290, 121.950137);
                mMap.addMarker(new MarkerOptions().position(sydney).title("遠眺龜山島"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 15:
                sydney = new LatLng(24.676489, 121.768647);
                mMap.addMarker(new MarkerOptions().position(sydney).title("羅東夜市入口"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 16:
                sydney = new LatLng(24.676672, 121.769018);
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

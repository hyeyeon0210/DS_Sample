package org.techtown.sample_tmapview;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

public class MainActivity extends AppCompatActivity {

    ToggleButton tb;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayoutTmap = (LinearLayout) findViewById(R.id.tmapView);

        TMapView tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey("03f7aca5-4af8-46d3-96cd-d8d29b992e1b");

        linearLayoutTmap.addView(tMapView);
    //마커
        TMapMarkerItem markerItem1 = new TMapMarkerItem();

        TMapPoint tMapPoint1 = new TMapPoint(37.570841, 126.985302); // SKT타워

    // 마커 아이콘
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.marker);

        markerItem1.setIcon(bitmap); // 마커 아이콘 지정
        markerItem1.setPosition(0.5f, 1.0f); // 마커의 중심점을 중앙, 하단으로 설정
        markerItem1.setTMapPoint( tMapPoint1 ); // 마커의 좌표 지정
        markerItem1.setName("SKT타워"); // 마커의 타이틀 지정
        tMapView.addMarkerItem("markerItem1", markerItem1); // 지도에 마커 추가

        tMapView.setCenterPoint( 126.985302, 37.570841 );

        tv = (TextView)findViewById(R.id.textView2);
        tb = (ToggleButton)findViewById(R.id.toggle1);

        tv.setText("위치정보 미수신중");

        final LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)) {

                    } else {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    }

                }else {
                    try {
                        if (tb.isChecked()) {
                            tv.setText("수신중..");
                            // GPS 제공자의 정보가 바뀌면 콜백하도록 리스너 등록하기~!!!
                            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, // 등록할 위치제공자
                                    100, // 통지사이의 최소 시간간격 (miliSecond)
                                    1, // 통지사이의 최소 변경거리 (m)
                                    mLocationListener);
                            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, // 등록할 위치제공자
                                    100, // 통지사이의 최소 시간간격 (miliSecond)
                                    1, // 통지사이의 최소 변경거리 (m)
                                    mLocationListener);
                        } else {
                            tv.setText("위치정보 미수신중");
                            lm.removeUpdates(mLocationListener);  //  미수신할때는 반드시 자원해체를 해주어야 한다.
                        }
                    } catch (SecurityException ex) {
                    }
                }
            }
        });
    }

    private final LocationListener mLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            //여기서 위치값이 갱신되면 이벤트가 발생한다.
            //값은 Location 형태로 리턴되며 좌표 출력 방법은 다음과 같다.

            Log.d("test", "onLocationChanged, location:" + location);
            double longitude = location.getLongitude(); //경도
            double latitude = location.getLatitude();   //위도
            double altitude = location.getAltitude();   //고도
            float accuracy = location.getAccuracy();    //정확도
            String provider = location.getProvider();   //위치제공자
            //Gps 위치제공자에 의한 위치변화. 오차범위가 좁다.
            //Network 위치제공자에 의한 위치변화
            //Network 위치는 Gps에 비해 정확도가 많이 떨어진다.
            tv.setText("위치정보 : " + provider + "\n위도 : " + longitude + "\n경도 : " + latitude + "\n고도 : " + altitude + "\n정확도 : "  + accuracy);
        }
        public void onProviderDisabled(String provider) {
            // Disabled시
            Log.d("test", "onProviderDisabled, provider:" + provider);
        }

        public void onProviderEnabled(String provider) {
            // Enabled시
            Log.d("test", "onProviderEnabled, provider:" + provider);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            // 변경시
            Log.d("test", "onStatusChanged, provider:" + provider + ", status:" + status + " ,Bundle:" + extras);
        }

    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case  1:{
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"권한을 사용자가 승인함",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"권한 거부됨",Toast.LENGTH_SHORT).show();
                }

                return;
            }
        }
    }
}

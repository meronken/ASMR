package jp.Ken.asmr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;


    @SuppressLint ( "ResourceAsColor" )
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        //Google Mobile Ads SDK を初期化
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        //ステータスバー色変更
        getWindow().setStatusBarColor( R.color.black );

        ViewPager2 viewPager = findViewById ( R.id.pager );
        FragmentStateAdapter pagerAdapter = new ScreenSlidePagerAdapter ( this );
        viewPager.setAdapter( pagerAdapter );
        //遷移時アニメーション 奥行きページ
        viewPager.setPageTransformer ( new DepthPageTransforme () );

    }
}


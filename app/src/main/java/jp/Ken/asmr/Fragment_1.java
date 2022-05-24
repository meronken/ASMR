package jp.Ken.asmr;

import android.annotation.SuppressLint;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private MediaPlayer mediaPlayer;
    private ImageButton imageButton;
    private ImageView imageView2;
    private Animation ImageButtonAnimation;
    private TextView w_,w_360,w_400,w_480,w_600,w_720,w_840;
    private AdView mAdView;







    public Fragment_1 ( ) {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_1 newInstance ( String param1 , String param2 ) {
        Fragment_1 fragment = new Fragment_1 ( );
        Bundle args = new Bundle ( );
        args.putString ( ARG_PARAM1 , param1 );
        args.putString ( ARG_PARAM2 , param2 );
        fragment.setArguments ( args );
        return fragment;
    }

    @Override
    public void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        if ( getArguments ( ) != null ) {
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments ( ).getString ( ARG_PARAM1 );
            String mParam2 = getArguments ( ).getString ( ARG_PARAM2 );
        }
    }

    @SuppressLint ( "UseRequireInsteadOfGet" )
    @Override
    public View onCreateView ( LayoutInflater inflater , ViewGroup container ,
                               Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate ( R.layout.fragment_1 , container , false );

        imageButton = view.findViewById ( R.id.StartButton);
        ImageButtonAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.image_button);

        imageView2 = view.findViewById ( R.id.imageView2 );
        setAnime ();

        w_ = view.findViewById ( R.id.textView_ );
        w_360 = view.findViewById ( R.id.textView_360 );
        w_400 = view.findViewById ( R.id.textView_400 );
        w_480 = view.findViewById ( R.id.textView_480 );
        w_600 = view.findViewById ( R.id.textView_600 );
        w_720 = view.findViewById ( R.id.textView_720 );
        w_840 = view.findViewById ( R.id.textView_840 );

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //再生ボタンを押した時の処理
        imageButton.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                imageButton.startAnimation ( ImageButtonAnimation );

                if ( mediaPlayer == null ){
                    audioPlay ();

                }else {
                    audioStop();
                }

            }
        } );

        return view;
    }


    private void ChangeStopButton(){

        if ( w_ != null ){
            imageButton.setImageResource ( R.drawable.ic_stop_asmr_ );

        }else if ( w_360 != null ){
            imageButton.setImageResource ( R.drawable.ic_stop_asmr_360 );

        }else if ( w_400 != null ){
            imageButton.setImageResource ( R.drawable.ic_stop_asmr_400 );

        }else if ( w_480 != null ){
            imageButton.setImageResource ( R.drawable.ic_stop_asmr_480 );

        }else if ( w_600 != null ){
            imageButton.setImageResource ( R.drawable.ic_stop_asmr_600 );

        }else if ( w_720 != null ){
            imageButton.setImageResource ( R.drawable.ic_stop_asmr_720 );

        }else if ( w_840 != null ){
            imageButton.setImageResource ( R.drawable.ic_stop_asmr_840 );

        }
    }

    private void ChangeStartButton(){

        if ( w_ != null ){
            imageButton.setImageResource ( R.drawable.ic_start_asmr_ );

        }else if ( w_360 != null ){
            imageButton.setImageResource ( R.drawable.ic_start_asmr_360 );

        }else if ( w_400 != null ){
            imageButton.setImageResource ( R.drawable.ic_start_asmr_400 );

        }else if ( w_480 != null ){
            imageButton.setImageResource ( R.drawable.ic_start_asmr_480 );

        }else if ( w_600 != null ){
            imageButton.setImageResource ( R.drawable.ic_start_asmr_600 );

        }else if ( w_720 != null ){
            imageButton.setImageResource ( R.drawable.ic_start_asmr_720 );

        }else if ( w_840 != null ){
            imageButton.setImageResource ( R.drawable.ic_start_asmr_840);

        }
    }

    private void audioSetup(){
        // インタンスを生成
        mediaPlayer = new MediaPlayer ();

        //音楽ファイル名,
        String filePath = "born.mp3";

        boolean fileCheck = false;

        // assetsから mp3 ファイルを読み込み
        try(AssetFileDescriptor afdescripter = getActivity ().getAssets ().openFd(filePath)) {
            // MediaPlayerに読み込んだ音楽ファイルを指定
            mediaPlayer.setDataSource(afdescripter.getFileDescriptor(),
                    afdescripter.getStartOffset(),
                    afdescripter.getLength());
            // 音量調整を端末のボタンに任せる
            getActivity ().setVolumeControlStream( AudioManager.STREAM_MUSIC);
            mediaPlayer.prepare();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    private void audioPlay() {
        //ボタンを停止ボタンに変更
        ChangeStopButton ();

        if (mediaPlayer == null) {
            // audio ファイルを読出し
            audioSetup();
        }

        // 再生する
        mediaPlayer.start();

        // 再生が終了した時の処理
        mediaPlayer.setOnCompletionListener ( new MediaPlayer.OnCompletionListener ( ) {
            @Override
            public void onCompletion ( MediaPlayer mp ) {
                audioStop ();
            }
        } );
    }

    private void audioStop() {

        //ボタンを再生ボタンに変更
        ChangeStartButton ();
        // 再生終了
        mediaPlayer.stop();
        // リセット
        mediaPlayer.reset();
        // リソースの解放
        mediaPlayer.release();

        mediaPlayer = null;
    }

    private void setAnime(){
        //移動アニメーション　x-50
        TranslateAnimation animation_translate = new TranslateAnimation ( 0, -15, 0, 0 );
        //実行時間
        animation_translate.setDuration ( 1200 );
        //反復動作
        animation_translate.setRepeatMode ( Animation.REVERSE );
        //アニメーションを無限に繰り返す
        animation_translate.setRepeatCount ( Animation.INFINITE );
        //起動
        imageView2.startAnimation ( animation_translate );

    }

    public void onPause(){
        super.onPause ();
        //画面遷移時　再生終了
        if ( mediaPlayer != null ){
            audioStop ();
        }
    }

    public void onResume(){
        super.onResume ();
        setAnime ();
    }

}
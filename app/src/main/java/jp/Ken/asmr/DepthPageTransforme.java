package jp.Ken.asmr;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

//遷移アニメーション 奥行きページ
@RequiresApi (21)
public class DepthPageTransforme extends RecyclerView.Adapter implements ViewPager2.PageTransformer {

    private static final float MIN_SCALE = 0.75f;

    @Override
    public void transformPage ( @NonNull View view , float position ) {
        int pageWidth = view.getWidth();

        if (position < -1) {

            view.setAlpha(0f);

        } else if (position <= 0) {

            view.setAlpha(1f);
            view.setTranslationX(0f);
            view.setTranslationZ(0f);
            view.setScaleX(1f);
            view.setScaleY(1f);

        } else if (position <= 1) {

            view.setAlpha(1 - position);

            view.setTranslationX(pageWidth * -position);

            view.setTranslationZ(-1f);

            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        } else {

            view.setAlpha(0f);

        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder ( @NonNull ViewGroup parent , int viewType ) {
        return null;
    }

    @Override
    public void onBindViewHolder ( @NonNull RecyclerView.ViewHolder holder , int position ) {

    }

    @Override
    public int getItemCount ( ) {
        return 0;
    }
}

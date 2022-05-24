package jp.Ken.asmr;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    //ページ数
    private static final int NUM_PAGES = 3;

    public ScreenSlidePagerAdapter ( @NonNull MainActivity fragment ) {
        super ( fragment );
    }


    @NonNull
    @Override
    public Fragment createFragment( int position) {
        //遷移先 Fragment
        switch (position){
            case 0:
                return new Fragment_1 ();

            case 1:
                return new Fragment_2 ();

            case 2:
                return new Fragment_3 ();
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }

}




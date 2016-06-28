package com.thegreatlist.malopa.art;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ArtListFragment.OnArtSelectedListener{

    public static final String LIST_FRAGMENT = "LIST_FRAGMENT";
    public static final String DETAIL_FRAGMENT = "DETAIL_FRAGMENT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.HORIZONTAL);
        //master fragment
        FrameLayout masterFrame = new FrameLayout(this);
        masterFrame.setId(10);
        masterFrame.setBackgroundColor(Color.RED);
        rootLayout.addView(masterFrame,new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1));

        //aside fragement
        FrameLayout detailFrame = new FrameLayout(this);
        detailFrame.setId(11);
        detailFrame.setBackgroundColor(Color.GREEN);
        rootLayout.addView(detailFrame, new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,2));

        //start fragment transaction
        FragmentTransaction transactionManager = getFragmentManager().beginTransaction();
        //ArtDetailFragment art = new ArtDetailFragment();
        ArtListFragment listFragment = (ArtListFragment) getFragmentManager().findFragmentByTag(LIST_FRAGMENT);
        if(listFragment == null){
            listFragment = ArtListFragment.newInstance();
            transactionManager.add(masterFrame.getId(),listFragment,LIST_FRAGMENT);
        }


        ArtDetailtFragment detailtFragment = (ArtDetailtFragment) getFragmentManager().findFragmentByTag(DETAIL_FRAGMENT);
        if(detailtFragment==null){
            detailtFragment = ArtDetailtFragment.newInstance(R.drawable.me);
        }
        transactionManager.add(detailFrame.getId(), detailtFragment,DETAIL_FRAGMENT);

        transactionManager.commit();
        setContentView(rootLayout);
    }

    @Override
    public void onArtSelected(int resourceId) {
        ArtDetailtFragment dfragment = (ArtDetailtFragment)getFragmentManager().findFragmentByTag(DETAIL_FRAGMENT);
        dfragment.setArtResource(resourceId);
    }
}

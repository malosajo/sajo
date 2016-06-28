package com.thegreatlist.malopa.art;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
//import android.support.v4.app.Fragment;


/**
 * Created by Malopa on 6/27/2016.
 */
public class ArtDetailtFragment extends Fragment {
    public static  final String ART_RESOURCE_KEY = "ART_RESOURCE_KEY";
    public static ArtDetailtFragment newInstance(int art_resource_id){
        ArtDetailtFragment fragemet = new ArtDetailtFragment();
        Bundle b = new Bundle();
        b.putInt(ART_RESOURCE_KEY,art_resource_id);
        fragemet.setArguments(b);
        return fragemet;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveIstanceState){
        int artDrawable = R.drawable.sa;
        if(getArguments()!=null && getArguments().containsKey(ART_RESOURCE_KEY))
            artDrawable = getArguments().getInt(ART_RESOURCE_KEY);

        ImageView rootView = new ImageView(getActivity());
        rootView.setImageResource(artDrawable);
        return rootView;
    }

    public int getArtResource(){
        return 0;
    }
    public void setArtResource(int artResourceId){
        ImageView rootView = (ImageView)getView();
        rootView.setImageResource(artResourceId);
    }
}

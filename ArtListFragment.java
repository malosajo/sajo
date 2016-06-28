package com.thegreatlist.malopa.art;

import android.app.Activity;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ArtListFragment extends Fragment implements ListAdapter{
    public static int[] ART = {R.drawable.me,R.drawable.sa,R.drawable.sajo};

    public static ArtListFragment newInstance(){
        ArtListFragment fragment = new ArtListFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public interface OnArtSelectedListener{
            void onArtSelected(int resourceId);
         }

    OnArtSelectedListener _onArtSelectedListener;

    //Fragment Overrides
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            _onArtSelectedListener = (OnArtSelectedListener) activity;
        }catch (ClassCastException ex){
            throw new ClassCastException(activity.toString() + "must Implement the listener");
        }

    }

    @Override
    public void onDetach(){
        _onArtSelectedListener = null;
        super.onDetach();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle saveInstanceState){
        ListView list = new ListView(getActivity());
        list.setBackgroundColor(Color.GREEN);
        list.setAdapter(this);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                _onArtSelectedListener.onArtSelected((int)getItem(position));
            }
        });
        return list;
    }

    //adapter overrides
    @Override
    public boolean isEmpty() {
        return getCount() >0;
    }

    @Override
    public int getCount() {
        return ART.length;
    }

        //items
    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return ART[position];
    }

    //view relatedstaff
    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

        @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            int artResourceId = (int)getItem(position);
            TextView artView = new TextView(getActivity());
            artView.setText(artResourceId);
            int padding = (int)(8.0f*getResources().getDisplayMetrics().density);
            artView.setPadding(padding,padding,padding,padding);
        return artView;
    }


    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    //list adapter overrides
    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }
}

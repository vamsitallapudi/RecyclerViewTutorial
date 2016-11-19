package com.coderefer.recyclerviewtutorial.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coderefer.recyclerviewtutorial.R;
import com.coderefer.recyclerviewtutorial.models.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by vamsi on 06-May-16.
 */
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private List<Song> songList;

    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item, and
    //you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        //each data item is just a string in this case
        public TextView tvRank,tvSongName,tvSinger,tvYear;
        public ImageView ivAlbumCover;

        public ViewHolder(View v) {
            super(v);
            tvRank = (TextView)v.findViewById(R.id.tv_rank);
            tvSongName = (TextView) v.findViewById(R.id.tv_song_name);
            tvSinger = (TextView) v.findViewById(R.id.tv_singer);
            tvYear = (TextView) v.findViewById(R.id.tv_year);
            ivAlbumCover = (ImageView) v.findViewById(R.id.iv_album_cover);
        }
    }

    //Provide a suitable constructor
    public SongAdapter(List<Song> songList){
        this.songList = songList;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Creating a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list_item,parent,false);

        //set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(SongAdapter.ViewHolder holder, int position) {

        // - get element from arraylist at this position
        // - replace the contents of the view with that element

        Song song = songList.get(position);
        holder.tvRank.setText(String.valueOf(song.getRank()));
        holder.tvSongName.setText(song.getName());
        holder.tvSinger.setText(song.getSinger());
        holder.tvYear.setText(song.getYear());
        holder.ivAlbumCover.setImageResource(song.getPic());
        holder.tvYear.setText("2016");
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
}

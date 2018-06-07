package com.coto.cesar.e_learning_beta_01;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CVideoAdapter extends RecyclerView.Adapter<CVideoAdapter.ViewHolder> {


    ArrayList<CVideo> cVideos ;
    Context context;
    OnItemVideoCursoClickListener listener;

    public CVideoAdapter(ArrayList<CVideo> cVideos, OnItemVideoCursoClickListener listener) {
        this.cVideos = cVideos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemvideocurso,
                parent, false);
        this.context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final CVideo cVideo = cVideos.get(position);
        holder.setListener(cVideo, listener);

        holder.textViewNumeroVideo.setText(String.valueOf(cVideo.getId()));
        holder.textViewTitleVideoItem.setText(cVideo.getNombre());
        holder.textViewDurationVideoItem.setText(cVideo.getDuracion());
    }

    public void addVideoAlaLista(CVideo cVideo){
        if (!cVideos.contains(cVideo)){
            cVideos.add(cVideo);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return cVideos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewNumeroVideo)
        TextView textViewNumeroVideo;
        @BindView(R.id.textViewTitleVideoItem)
        TextView textViewTitleVideoItem;
        @BindView(R.id.textViewDurationVideoItem)
        TextView textViewDurationVideoItem;
        @BindView(R.id.shareVideoOfCurso)
        ImageView shareVideoOfCurso;
        @BindView(R.id.containerLista)
        RelativeLayout containerLista;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        void setListener (final CVideo cVideo, final OnItemVideoCursoClickListener listener){
            containerLista.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemVideoCursoClickListener(cVideo);
                }
            });

            shareVideoOfCurso.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String urlVideo = cVideo.getUrlVideo();
                    Intent intentShareVideo = new Intent();
                    intentShareVideo.setAction(Intent.ACTION_SEND);
                    intentShareVideo.putExtra(Intent.EXTRA_TEXT, urlVideo);
                    intentShareVideo.setType("text/plain");
                    context.startActivity(Intent.createChooser(intentShareVideo, "Compartir con"));
                }
            });
            Animation animation = AnimationUtils.loadAnimation(context,R.anim.creation_viewleft);
            containerLista.startAnimation(animation);
        }
    }
}

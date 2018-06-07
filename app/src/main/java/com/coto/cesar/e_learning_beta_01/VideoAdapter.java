package com.coto.cesar.e_learning_beta_01;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    ArrayList<Video> videos;
    Context context;
    OnItemVideoClickListener listener;

    public VideoAdapter(ArrayList<Video> videos, OnItemVideoClickListener listener) {
        this.videos = videos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videoitem, parent, false);

        this.context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Video video = videos.get(position);

            holder.setListener(video,listener);

            holder.textViewTitleVideo.setText(video.getNameVideo());
            holder.textViewDurationVideo.setText(video.getDurationVideo());

            if (video.getUrlImage()!=null){
                RequestOptions options = new RequestOptions();
                options.diskCacheStrategy(DiskCacheStrategy.ALL);
                options.centerCrop();
                options.placeholder(R.drawable.ic_launcher_foreground);

                Glide.with(context)
                        .load(video.getUrlImage())
                        .apply(options)
                        .into(holder.imageVideoItem);
            }else{
                holder.imageVideoItem.setImageDrawable(ContextCompat.getDrawable(context,
                        R.drawable.ic_launcher_foreground));
            }


    }
    public void addVideo(Video video){
        if (!videos.contains(video)){
            videos.add(video);
            notifyDataSetChanged();
        }
    }
    @Override
    public int getItemCount() {
        return videos.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageVideoItem)
        ImageView imageVideoItem;
        @BindView(R.id.imageMoreOptionsVideo)
        ImageView imageMoreOptionsVideo;
        @BindView(R.id.textViewTitleVideo)
        TextView textViewTitleVideo;
        @BindView(R.id.textViewDurationVideo)
        TextView textViewDurationVideo;
        @BindView(R.id.containerItemVideo)
        RelativeLayout containerItemVideo;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        @SuppressLint("ClickableViewAccessibility")
        void setListener(final Video video, final OnItemVideoClickListener listener){
            containerItemVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // listener.onItemVideoLongClickListener(video);
                    generateView(video);
                }
            });
            containerItemVideo.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onItemVideoLongClickListener(video);
                    return true;
                }
            });
            containerItemVideo.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            ObjectAnimator upAnim = ObjectAnimator.ofFloat(itemView, "translationZ",20);
                            upAnim.setDuration(1000);
                            upAnim.setInterpolator(new DecelerateInterpolator());
                            upAnim.start();
                            break;

                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_CANCEL:
                            ObjectAnimator downAnim = ObjectAnimator.ofFloat(itemView,"translationZ",0);
                            downAnim.setDuration(1000);
                            downAnim.setInterpolator(new AccelerateDecelerateInterpolator());
                            downAnim.start();
                            break;
                    }
                    return false;
                }
            });

            Animation animation = AnimationUtils.loadAnimation(context,R.anim.creation_view);
            containerItemVideo.startAnimation(animation);

            imageMoreOptionsVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(context,imageMoreOptionsVideo);
                    popupMenu.getMenuInflater().inflate(R.menu.menu_more_options,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){

                                case R.id.itemOpenVideoOnYoutube:

                                    String playVideo = video.getIdVideo();
                                    Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + playVideo));
                                    Intent webIntent = new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("http://www.youtube.com/watch?v=" + playVideo));
                                    try {
                                        context.startActivity(appIntent);
                                    } catch (ActivityNotFoundException ex) {
                                        context.startActivity(webIntent);
                                    }
                                    break;

                                case R.id.itemShareVideo:
                                    shareVideo(video.getUrlVideo());
                                    break;
                            }

                            return true;
                        }
                    });
                    popupMenu.show();

                }
            });
        }
        void shareVideo(String urlVideo){
            Intent intentShareVideo = new Intent();
            intentShareVideo.setAction(Intent.ACTION_SEND);
            intentShareVideo.putExtra(Intent.EXTRA_TEXT, urlVideo);
            intentShareVideo.setType("text/plain");
            context.startActivity(Intent.createChooser(intentShareVideo, "Compartir con"));
        }
        void generateView(final Video video){

            final Dialog fullScreenDialog = new Dialog(context,R.style.DialongFullscreen);
            fullScreenDialog.setContentView(R.layout.contend_description);



            LinearLayout containerControlsExtras = fullScreenDialog.findViewById(R.id.layoutContainerControlsExtras);

            //cracion de objetos
            ImageView imageBanner = fullScreenDialog.findViewById(R.id.imageBanerVideo);
            ImageView buttonBackVideo = fullScreenDialog.findViewById(R.id.buttonBackVideo);
            ImageView buttonShareVideo = fullScreenDialog.findViewById(R.id.shareButtonVideo);
            TextView textViewTitleVideo = fullScreenDialog.findViewById(R.id.textViewTitleVideoDescription);
            TextView textViewDescription = fullScreenDialog.findViewById(R.id.textViewDescriptionVideo);
            TextView texTViewDuracionVideoDescription = fullScreenDialog.findViewById(R.id.textViewDuracionVideoDescription);
            FloatingActionButton playVideo = fullScreenDialog.findViewById(R.id.playVideo);

            playVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String videoAReproducir = video.getIdVideo();


                    ConnectivityManager connectivityManager = (ConnectivityManager)
                            context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                    if (networkInfo.isConnected()){
                        Intent playVideo = new Intent(context, VideoPlayerActivity.class);
                        playVideo.putExtra("IDVIDEO",videoAReproducir);
                        context.startActivity(playVideo);
                    }else{
                        Toast.makeText(context,
                                "No tienes conexion a internet en estos momentos, intenta más tarde",
                                Toast.LENGTH_SHORT).show();
                    }

                }
            });

            //Sets
            textViewTitleVideo.setText(video.getNameVideo());
            textViewDescription.setText(video.getDescriptonVideo());
            texTViewDuracionVideoDescription.setText(video.getDurationVideo());


            buttonBackVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fullScreenDialog.dismiss();
                }
            });

            buttonShareVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    shareVideo(video.getUrlVideo());
                }
            });

            //glide
            RequestOptions options = new RequestOptions();
            options.diskCacheStrategy(DiskCacheStrategy.ALL);
            options.centerCrop();
            options.placeholder(R.drawable.ic_launcher_foreground);

            Glide.with(context)
                    .load(video.getUrlImage())
                    .apply(options)
                    .into(imageBanner);


            fullScreenDialog.show();
        }
    }
}

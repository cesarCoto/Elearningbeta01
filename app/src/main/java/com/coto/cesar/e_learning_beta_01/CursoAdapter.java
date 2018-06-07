package com.coto.cesar.e_learning_beta_01;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CursoAdapter extends RecyclerView.Adapter<CursoAdapter.ViewHolder> {


    ArrayList<Curso> cursos;
    Context context;
    OnItemCursoClickListener listener;

    public CursoAdapter(ArrayList<Curso> cursos, OnItemCursoClickListener listener) {
        this.cursos = cursos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cursoitem,
                parent, false);

        this.context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Curso curso = cursos.get(position);

        holder.setListener(curso,listener);

        holder.textViewTitleCurso.setText(curso.getNombre());
        holder.textViewNumeroVideos.setText(curso.getNumeroVideos());
        holder.textViewNivel.setText(curso.getNivel());
        holder.textViewEstado.setText(curso.getEstado());

        if (curso.getUrlImage()!=null){
            RequestOptions options = new RequestOptions();
            options.diskCacheStrategy(DiskCacheStrategy.ALL);
            options.centerCrop();
            options.placeholder(R.drawable.ic_launcher_foreground);

            Glide.with(context)
                    .load(curso.getUrlImage())
                    .apply(options)
                    .into(holder.imageViewCurso);
        }else{
            holder.imageViewCurso.setImageDrawable(ContextCompat.getDrawable(context,
                    R.drawable.ic_launcher_foreground));
        }

    }
    public void addCurso(Curso curso){
        if (!cursos.contains(curso)){
            cursos.add(curso);
            notifyDataSetChanged();
        }
    }
    @Override
    public int getItemCount() {
        return cursos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageViewCurso)
        ImageView imageViewCurso;
        @BindView(R.id.textViewTitleCurso)
        TextView textViewTitleCurso;
        @BindView(R.id.textViewNumeroVideos)
        TextView textViewNumeroVideos;
        @BindView(R.id.textViewNivel)
        TextView textViewNivel;
        @BindView(R.id.textViewEstado)
        TextView textViewEstado;
        @BindView(R.id.containerMainCursos)
        RelativeLayout containerMainCursos;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        @SuppressLint("ClickableViewAccessibility")
        void setListener (final Curso curso, final OnItemCursoClickListener listener){

            containerMainCursos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemCursoClickListener(curso);
                }
            });
            containerMainCursos.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onItemLongClickListener(curso);
                    return true;
                }
            });
            containerMainCursos.setOnTouchListener(new View.OnTouchListener() {
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
            containerMainCursos.startAnimation(animation);
        }
    }
}

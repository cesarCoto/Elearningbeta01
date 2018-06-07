package com.coto.cesar.e_learning_beta_01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CursoActivity extends AppCompatActivity implements OnItemVideoCursoClickListener{


    @BindView(R.id.bannerCurso)
    ImageView bannerCurso;
    @BindView(R.id.recyclerViewCursos)
    RecyclerView recyclerViewCursos;
    @BindView(R.id.sahreList)
    FloatingActionButton sahreList;

    @SuppressLint("RestrictedApi")

    CVideoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        Bundle extras = getIntent().getExtras();
        final String[] info = extras.getStringArray("infoCurso");

        loadBanner(info[1]);
        actionBar.setTitle(info[2]);

        sahreList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlList = info[3];
                Intent intentShareVideo = new Intent();
                intentShareVideo.setAction(Intent.ACTION_SEND);
                intentShareVideo.putExtra(Intent.EXTRA_TEXT,urlList );
                intentShareVideo.setType("text/plain");
                startActivity(Intent.createChooser(intentShareVideo, "Compartir con"));
            }
        });

        confyAdapter();
        confyRecycler();
        addnewCurso(Integer.parseInt(info[0]));
    }

    private void loadBanner(String banner) {
        RequestOptions options = new RequestOptions();
        options.diskCacheStrategy(DiskCacheStrategy.ALL);
        options.centerCrop();
        options.placeholder(R.mipmap.ic_launcher);

        Glide.with(this).load(banner).apply(options).into(bannerCurso);
    }

    private void addnewCurso(int curso) {
        if (curso ==1){
            String [] name ={
                    "Crear un nuevo proyecto en Android Studio",
                    "Conociendo la interfaz de Android Studio",
                    "Cómo programar el clic en un botón de Android",
                    "Cómo funciona una app de Android explicacion",
                    "Agrupar botones en grupos",
                    "Programar según el botón seleccionado ",
                    "Los check boxes en Android y Java"};

            String [] duracion ={
                    "35:02 mins",
                    "47:12 mins",
                    "52:24 mins",
                    "57:10 mins",
                    "35:19 mins",
                    "36:36 mins",
                    "23:44 mins"};
            String [] idVideo ={
                    "TGtvo4yZUlE",
                    "rtNeulB_p04",
                    "iUTXRGOyIZM",
                    "Ra8rMkDOnwI",
                    "qwe6MXUb42g",
                    "ED5n9IsLXI8",
                    "W3B5QAy1CuA"};
            String [] urlVideo ={
                    "https://www.youtube.com/watch?v=TGtvo4yZUlE",
                    "https://www.youtube.com/watch?v=rtNeulB_p04",
                    "https://www.youtube.com/watch?v=iUTXRGOyIZM",
                    "https://www.youtube.com/watch?v=Ra8rMkDOnwI",
                    "https://www.youtube.com/watch?v=qwe6MXUb42g",
                    "https://www.youtube.com/watch?v=ED5n9IsLXI8",
                    "https://www.youtube.com/watch?v=W3B5QAy1CuA"};

            for (int i = 0; i<7; i++){
                CVideo cVideo = new CVideo(i+1,name[i],duracion[i],idVideo[i],urlVideo[i]);
                adapter.addVideoAlaLista(cVideo);
            }

        }
        if (curso ==2){
            String[] name = {
                    "Arquitectura de una app en Android", "Cómo crear y compilar tu propio proyecto",
                    "Apps internacionales y ficheros de strings en Android", "La estructura de una actividad en Java",
                    "La estructura de un Layout en XML", "Mi primer app en Android, Hello World!",
                    "Un paseo por la interfaz de Android Studio","El editor de layouts de Android Studio",
                    "El sistema de archivos de Android y Graddle","Los layouts de diseño de interfaces",
                    "Ejercicio de colocación de Widgets","El relative layout",
                    "El linear layout","El constraint layout",
                    "Crear apps para tablet en Android","Listas con Scrolls Views",
                    "Creando un formulario de registro","El layout de términos y condiciones",
                    "El ciclo de vida de una app","Los estados y etapas del ciclo de vida de una app",
                    " El ciclo de vida a través de tostadas","Inflando menús de ajustes",
                    " Java I- Los comentarios","Java II - Los tipos de datos básicos"};

            String[] duracion = {
                    "57:57 mins", "32:03 mins", "16:52 mins", "19:16 mins", "11:09 mins", "42:10 mins",
                    "31:02 mins", "15:19 mins", "37:52 mins", "58:01 mins", "37:09 mins", "21:47 mins",
                    "21:48 mins", "30:43 mins", "13:16 mins", "30:06 mins", "21:59 mins", "30:48 mins",
                    "28:55 mins", "9:23 mins", "17:45 mins", "27:02 mins", "27:16 mins", "23:05 mins"};
            String[] idVideo = {
                    "J6EwGYJJjoI","dpfLCIhnUPQ","ongXWy63pDY","ZmGrwq_Q3h0",
                    "hgFk71ZAzok","yjELAQd_Jxg","jrb9Hx02Dmw","IhJGgw25AwQ",
                    "ZNvKIevRad0","mzKBj-RDHBw","8RzqBeFb7yk","6wEEADGLZR8",
                    "HxGS7o4eHTY","FEbqKVY-N88","7ePdzfXnPL0","VVAy6EU_NcY",
                    "jH4lj4EAYdI","gyHHVj37AhU","rLhKIKawbuQ","DJgADMhc9zI",
                    "3y4kC-VQqL0","ZgHOOE9PJGo","PUNTEFbBJOE","MFGz8EkBEFI"};
            String[] urlVideo = {
                    "https://www.youtube.com/watch?v=J6EwGYJJjoI","https://www.youtube.com/watch?v=dpfLCIhnUPQ",
                    "https://www.youtube.com/watch?v=ongXWy63pDY","https://www.youtube.com/watch?v=ZmGrwq_Q3h0",
                    "https://www.youtube.com/watch?v=hgFk71ZAzok","https://www.youtube.com/watch?v=yjELAQd_Jxg",
                    "https://www.youtube.com/watch?v=jrb9Hx02Dmw", "https://www.youtube.com/watch?v=IhJGgw25AwQ",
                    "https://www.youtube.com/watch?v=ZNvKIevRad0","https://www.youtube.com/watch?v=mzKBj-RDHBw",
                    "https://www.youtube.com/watch?v=8RzqBeFb7yk","https://www.youtube.com/watch?v=6wEEADGLZR8",
                    "https://www.youtube.com/watch?v=HxGS7o4eHTY","https://www.youtube.com/watch?v=FEbqKVY-N88",
                    "https://www.youtube.com/watch?v=7ePdzfXnPL0","https://www.youtube.com/watch?v=VVAy6EU_NcY",
                    "https://www.youtube.com/watch?v=jH4lj4EAYdI","https://www.youtube.com/watch?v=gyHHVj37AhU",
                    "https://www.youtube.com/watch?v=rLhKIKawbuQ","https://www.youtube.com/watch?v=DJgADMhc9zI",
                    "https://www.youtube.com/watch?v=3y4kC-VQqL0","https://www.youtube.com/watch?v=ZgHOOE9PJGo",
                    "https://www.youtube.com/watch?v=PUNTEFbBJOE","https://www.youtube.com/watch?v=MFGz8EkBEFI"};

            for (int i = 0; i< 24; i++){
                CVideo cVideo = new CVideo(i+1,name[i],duracion[i],idVideo[i],urlVideo[i]);
                adapter.addVideoAlaLista(cVideo);
            }

        }
        if (curso == 3 || curso > 3 && curso <8){
            Toast.makeText(this, "Videos proxiamente", Toast.LENGTH_SHORT).show();
        }



    }

    private void confyAdapter() {
        adapter = new CVideoAdapter(new ArrayList<CVideo>(),this);
    }

    private void confyRecycler() {
        recyclerViewCursos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCursos.setAdapter(adapter);
    }

    @Override
    public void onItemVideoCursoClickListener(CVideo cVideo) {
        String idVideoAMostar = cVideo.getIdVideo();
        Intent playVideo = new Intent(this,VideoPlayerActivity.class);
        playVideo.putExtra("IDVIDEO",idVideoAMostar);
        startActivity(playVideo);
    }
}

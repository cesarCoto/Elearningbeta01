package com.coto.cesar.e_learning_beta_01;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class AndroidCursoFragment extends Fragment implements OnItemCursoClickListener {


    @BindView(R.id.recyclerViewFragmentCursos)
    RecyclerView recyclerViewFragmentCursos;
    Unbinder unbinder;

    CursoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_android_curso, container, false);
        unbinder = ButterKnife.bind(this, view);

        confyAdapter();
        confyRecycler();
        addNewCurso();

        return view;
    }

    private void addNewCurso() {
        String[]nombre = {
                "Desarrollo de apps para android",
                "Bootcamp de programacion de apps con Android y java",
                "java desde Android Studio",
                "Diseño en Android a nivel basico",
                "Android Studio y sus herramientas",
                "Curso de Android",
                "Curso Android desde cero"};

        String[]numeroVideos = {
                "7 Videos",
                "24 Videos",
                "8 Videos",
                "10 Videos",
                "19 Videos",
                "19 Videos",
                "38 Videos"};

        String[]nivel = {
                "Principiante",
                "Intermedio",
                "Principiante",
                "Intermedio",
                "Intermedio",
                "Principiante",
                "Intermedio"};

        String[]estado = {
                "Terminado",
                "Terminado",
                "Terminado",
                "Terminado",
                "Terminado",
                "Terminado",
                "Emision"};

        String[]urlPlayList = {
                "https://www.youtube.com/watch?v=TGtvo4yZUlE&list=PLO2KKTlztSAT6astaV8bzE9cBy9Bf6IaK",
                "https://www.youtube.com/watch?v=J6EwGYJJjoI&list=PLO2KKTlztSARb1qN8pBscYXCiPg-yAp4K",
                "https://www.youtube.com/watch?v=fpJqbBVKsEw&list=PL_z8ReaP-3kRaSMBWMz2V25KBKyvRhnC8",
                "https://www.youtube.com/watch?v=96XZGn0bY-I&list=PL_z8ReaP-3kTf017rTy0At67klfJK7JWQ",
                "https://www.youtube.com/watch?v=5Ji0ZF2vLak&list=PL_z8ReaP-3kSPEf9WOaOJ5pZhRPHUJXl7",
                "https://www.youtube.com/watch?v=pO7STLF82Ro&list=PLpOqH6AE0tNh5rvbCb03w8ORR8bOoftZ6",
                "https://www.youtube.com/watch?v=tyx05coXixw&list=PLyvsggKtwbLX06iMtXnRGX5lyjiiMaT2y"};

        String[]urlImage = {
                "https://lh3.googleusercontent.com/5e6ykZWiH_801LIjjtifax-PlcGOfttV1QENF7rNzSEVdyUHh_F6EoupTqI6LJXs_ZCa0IgjiooCoQbA1MMqftL4xZEh3ZSS5HTd_5ta8gmUNdsWbCNHMtkcq_dbm-SyGmHxh7w45SdTwcFyVew6ZbZqXam3IknLg47J8iaQ9iXporWiM4jPKN4nmzThEw1PYPeJMWI3L54Cp4jbF5wjYTwKaFqMVpdA7RSgiWFi6Unn2lxodZJwYPcd7sQejkgloyEGT6jONmK_VwKDmugTy7ooJuFJsMUzW0DUusi22S6cpshahJVDBlBqG-bMlblNK3iB_RxvUIWqWHGFMRcJlnIoqFMeEEpT6dTplDynaYRS_iRdFtT_-i5Rjgf5cwFJ-fppHZ1FV4C5liTyKmfdMFPCjYkHF91PMZ5UHS37EISD0Nlx48dU2HPUi2BElzJc2rfbCEOi0ebjnVFzVfg0JVMNS1k0YezgwSIDKQuxIy5_r6ACojijxxO9rprGIM_arykVVr4zMXAd8ZGPChJPBv8LXDmOPcIH4Uu2T-mNdczDeMziz8dGuHyv6rv4a92NDUtbtB3bB9P9_ifrORD2yeNJYUaNY3WgDiNyu84=w994-h662-no",
                "https://lh3.googleusercontent.com/MueGRzULrLNID4KvkCUBDJSNOqtivFrDwjmBAWGa9g0soD-nhOHl-UkuacvloXKnbDUHx2iEH32NEUAnZ_6KWOKx3lkIOllamKjZnxOmgul9gMbJxnDNVrNcodMI6i_9hXmQT-qcjLAUCm8iUAY4t2wMLfYPts3bErGcwOA888Idt5le03nRBiPNBip7-5VbjatdGJorQ3-Zl5UDy5OLc8JBFY2itbwawTOguOyMOY2pQ_Li8ffHCey14yypU1j9TtB_MXMiV_tm3dm6XzN7LmMxwg6_X7zGlMVq1Fpsz2CioMIQZq16YkTTMuLy_moWNaiwGBo2NB2I1pvF8c2N0jQQ8NBhjwXFB1CStmGYj9AooRZN07CGFcE1AzDOeMA86DqH5MomShZAjjiEhZmxZnSx08wh9-rntpIXfBZw5bMJ2FoXGH29enLFfc7-dfHxw7P7as7Gt2ANzgdyK0GtflGFAe-67BKZqiQ6wr4aCtpi70Qa7yHxphr77q9Z08QKeSQdP2JhSjtiKlNWBj0ApPSz5c2KTHjYz-LL7ZWTS5Ad3TN6fJGqq2JEzpBtCIeNaUvhwbjse5xcAN_YLUSG7PW91bwbFUnGv3JdTLQ=w994-h662-no",
                "https://lh3.googleusercontent.com/IUSJWCI67nhLQixVd-rQZH65k_BDEkDUr9bv25HeS1ApUk-m3NW0Xo5nevIWVe-ZO2rq8pXU6WzXl-IeCvMTsTipe4bOnRuL2pfjd8oW6xwU7Ks0nBFUuFss8qnX5ya7SOgjr15JFJvEW6nfLb8d3toneVI7Eza1sfpW1L9unw3P0v3gCrgdSzrZmIMBahHeEzSVVu7dr68VBiHqlbEgab3_tdBwpkFB7GGB_YEeCTtBesy0Fi2ECFeH0kRJCZzoSrmG7A1QQQzATXaPRVeIH0onBKwmbAyqrQo6t5fL8kKqLStiKeujDhfidgDyE_abhql72Ng3c9OdsC4NTyPtSVb5MX96GCAQi5PZK0OyH-vp8BzGBmKcHnHUsaLugbzX2X2qxlEKumVKI7DCaMLPJRWOgJ5tlGtSURc_SOArrkZEHdoQ11YaONNrkpxsj43DSA_SpQlxq5MKxBofUEUmnCMVDUwtfmPQIEsGm83E1yx4_MJDmX9OZrLSm8L1ze6S6I1j9U4n8eJLRJhLK3KQRskEULGfoHmaRN6rqnXzQEQ4h-HPESWaVGwNE4LCf-Af0ozO23SPXb6QHQFdWKMHxjJDBLGT3DzDZeYC2k8=w994-h662-no",
                "https://lh3.googleusercontent.com/OqILiP3-Q1q7s7GNHFym45LegT6VqJkER-RTpjMZ4lQk4k6Z-eWPVOSZ8K-Zu-2yqU3cwCu4-DN6b_cNEhLK4zJ_be-JqlSMvg_y4MWs5w-tWUrYBQJcK1K7aeoTKthtcOh65VVH6rEVSP2YwalEnfqWpayx74_inl51M26O713oodNOsVAnj5wQLwF_S9OXdz_I64ZzX5BLM91UFThnkWU6PXnwgGjwgVRcenngajUGnJeobN21Oy5cJ6QzBdzX7-EnZb3OCPTKuHJta0mDfHjHYEZr1xNg_qkeJpx0HbESfhY4rGlGW7rzd17FAZGHJ3qSdbHlEScGN4pQLFrkpfX3ykUBrPqF1yjxwqoeiRRMInhJfIl48IQNxNpTYPqGfHoN5ap3VyVRGmQL3wbF1NB4f6NTTa7I9FyN3t8vMo5g2STz3Nuiivlp9mvC_Nii21egsYpGouZPIj2sXjQO4Rj58b363dPZ_Rs1Z-VcUYnft7pwTo2RyJtJeQrntE-aIICrN66iGr7uaD2D2EE8EV-xCcSGlUOHN641EBe6OlFfhsHapjLpYLnxlED-fgBX6cGZSbEedfOVGQUeD1J4_SL5GZbR2lz6h06-2z4=w994-h662-no",
                "https://lh3.googleusercontent.com/bIpkZkTUnqN9RRwsBq8OezeotXA9M_QoCsWUm1Cc-MnFo5KUalw-S3C7IfwUDSJ2t3et0o0jL-yJ4HjoKXbb_ni6jvKCGnfCMCaC3QoReSSzT7nlexUgISF4qcd1oATNnzrNUPwplAgQVyWTLXE6fo0XyHybZCgfiUAZ1FWksZ5tms3zcRSEcRyVOy2DRrqX2lsXqLI0g8bRqyAs78lzuX1PkxLhfoD3T7vWNWn6Sjwm5UOdWEBT1OU3rCF0E8DwsADo6CFfZR342iJ9wwv7hGfJHzU4P_KC7DroYOzd_1Rp0ulplm2VeZjJFdRJ6wbBxXY3gV6LKInZ-PmdmXHV7jKAK5-Vs46CP0EE5nUfaVxNh_bkLRpNPViWe6OGXTJvuCsExRBdLZicxAjC0zwNtbnBMYadgP9iUouy8-hbJCS-GQpcZiz1HuvdPXyUr980cPuYf6zZAymZz5HYIZ67cv3j7-Zj0w4bwZ2UfVzlOop8IldLXEy49y07OUM5a5a7YU81VZnO9ck-gyzLnt0rHvNfT-4uSexNdHWv7SwUGGSA9ys0nsfeAF2zTfw57uxoWrcBKwNZkrS2gWJnOTIX7hnGgMsV-SW1wZao_OM=w994-h662-no",
                "https://lh3.googleusercontent.com/i4ahXutqmonRNU141EFhWQfzO36P4YF0hHCMqYdU-38K6TX_9OEfW41ZiYZHxWyobO5folwXkctjQEja0dA51UmWFNhVsM26ZeAow0PqP_a9Tdnh-QEsifQXXR-arX-MnF5jHvqYjFvK7zrw20dph7DHeSDXC5z0d0KJzInxMMXlSYGmkunHFNSFcOarb3ivRR00avkP1PDloEJ2PAlUlkSN_Pk5iW9mlR3QiqGHlzshVfIZHO13PIZeTwZ93i93Zmz64isTQshsvRMJeRa6YVI5nozfjHQWO17OKirYdKRKlHZDy33kQhxghG6JRtaMk56_nLJiKwqG3-zyJPsTcDXyvG4NYq2UsbJ2BVhKKcQzYZKxSNgeXtFsfMVqHMzqZzX1SbVcEnd0B17jIadB86olBumg8FD7GyG9yXcUoWP253DlNAsol4ReaYLXy18Iy-1DI5RAZQAOor8VRK7Fz62bz2eyvJTh7XH3PZF-c7Ug1naOelGWWx0joHiMwSZ1sJEYuVW_7RHmAnjqZ4MgX4eX_MZAhF4PdDQafIueXEYWoy01rCrf8dZuSykX45Ew8U-uhcjQqcedF_P9lqN42XEZGM0sSlg9c-okBZE=w994-h662-no",
                "https://lh3.googleusercontent.com/nkb3CEAaVLHdPhPCOcBM4c1qsSNMWHGiH4bri2M0Wr5Q_puFz42T6YElfCeSPc2QsBjSqOYdnu5NxD98Lx8SMrMg8n8dozc37kqm8ceAkTYyTt9Gs3MGZWL-72WKKsHJHyeVvLfdcFwlru2LOXfQtCFiNs4xTa1X2QWXFETTAN2mr3kcCN6JmTfOUlMHDdx26LwEkXzSPSA2tdwLN0n9lpSed6AXXnDNQNDe4BmtRLizNebFel9iPor0CRwBhG8xbeiLmvQ53eJiP9k4AeiENZt4XZNSfWnoHPqE9TyyYD8bzVNXH2FqiYNYUQHKzNZTtql40ey-QS6JQY17CCSDDwyn_5WgMa8BfiuenyG7aT5Mf8ZVdG-vT36KbXRdkdRx206YsuWLWIJMeHqua0LYbjt17TkgFBAfslQs9EMRPmS-FJES3f_s8cWJ4jdQa7UhY8P_XvndleYWhQm2V6JS-bPK7rad36GI3pE15xBU7OVenWf_i-AAK2T0gfUC7R3n4en3lhOAt-SW99EmEMMIo58Yx1mwfoWLrqF2zkE1EUV_mwfDzj5_zdyWXCbQnetPfaHjmpY6J2AKXyDG7tv7jWGYtZ0-dG_hfFvunE8=w994-h662-no"};


        for(int i = 0; i < 7; i ++){
            Curso curso = new Curso(i+1, nombre[i],numeroVideos[i],nivel[i],estado[i],urlPlayList[i],urlImage[i]);
            adapter.addCurso(curso);
        }
    }
    private void confyAdapter() {
        adapter = new CursoAdapter(new ArrayList<Curso>(),this);
    }
    private void confyRecycler() {
        recyclerViewFragmentCursos.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewFragmentCursos.setAdapter(adapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemCursoClickListener(Curso curso) {
        String [] informacionCurso = {String.valueOf(curso.getId()),curso.getUrlImage(),curso.getNombre(),curso.getUrlPlaylist()};

        Intent viewCurso = new Intent(getActivity(), CursoActivity.class);
        viewCurso.putExtra("infoCurso",informacionCurso);
        startActivity(viewCurso);
    }

    @Override
    public void onItemLongClickListener(Curso curso) {

    }
}

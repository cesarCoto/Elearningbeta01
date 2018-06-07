package com.coto.cesar.e_learning_beta_01;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class AndroidFragment extends Fragment implements OnItemVideoClickListener {


    @BindView(R.id.recyclerViewAndroidVideos)
    RecyclerView recyclerViewAndroidVideos;
    Unbinder unbinder;

    VideoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android, container, false);
        unbinder = ButterKnife.bind(this, view);


        confyAdapter();
        confyRecyclerView();
        addNewVideo();

        return view;
    }

    private void addNewVideo() {
        String[] name = {
                "Formas de programar un Botón",
                "¿Que es y como usar la clase Toast en Android?",
                "RadioButton y RadioGroup",
                "Como usar un Spinner en Android",
                "Como usar el elemento ImageView (Ingles)",
                "Cargar Imágenes de Internet con Glide",
                "Como reproducri video en android usando VideoView (Ingles)",
                "Reproducir video usando la API de youtube(Ingles)",
                "Como crear un PopPupMenu en android (Ingles)",
                "Selector Fecha Y Hora Android Studio (DatePicker TimePicker)",
                "Instalar Git y crear cuenta en GitHub",
                "Subir proyecto a GitHub"};

        String [] duration = {
                "26:16 mins",
                "3:41 mins",
                "11:37 mins",
                "6:46 mins",
                "3:41 mins",
                "3:14 mins",
                "10:46 mins",
                "10:30 mins",
                "6:39 mins",
                "14:39 mins",
                "3:49 mins",
                "4:08 mins"};

        String [] description = {
                "En este video veremos todas las formas de cómo programar un botón en Android, además de algunos consejos iniciales de buenas prácticas.",
                "En este video veremos como generar una Toast, que es y para que nos sirve.",
                "En este video vamos a conocer los elementos llamados RadioButton y el elemento RadioGroup, realizaremos un pequeño ejemplo de aplicación para mostrar como funcionan.",
                "En este vídeo veremos como usar un Spinner en Android",
                "En este video se muestra como usar el ImageView y como agregar imagenes en nuestra aplicacion",
                "En este video se muestra como usar la libreria Glide para cargar o descargar imágenes desde Internet en nuestras aplicaciones",
                "En este video aprenderas coomo reproducer un vieo en android haciendo uso de el elemento videoview ",
                "En este video aprenderas a como integrar el API de youtube en tus aplicaciones android",
                "En este video veras como crear un PopoMenu en tu aplicacion.",
                "En este video veras como usar el DatePicker y TimePicker e implementarlo en tus aplicaciones android.",
                "En este video veras como instalar Git",
                "En este video veras como crear una cuenta en GitHub, configurar  tu cuenta en android studio y subir tus proyectos"};


        String [] idVideos = {
                "TX-QNc5dVac",
                "OyhB8O0Gzmc",
                "ZQLOdgxGMF4",
                "F9GV7vuIghw",
                "Ab7U7lqikfU",
                "A-KphPemhhg",
                "SrPHLj_q_OQ",
                "W4hTJybfU7s",
                "g3TJ2bMfXsc",
                "y3exATaC0kA",
                "Clvz5gVTUyM",
                "gBXhNwFX4u4"};

        String [] urlVideo = {
                "https://www.youtube.com/watch?v=TX-QNc5dVac",
                "https://www.youtube.com/watch?v=OyhB8O0Gzmc",
                "https://www.youtube.com/watch?v=ZQLOdgxGMF4",
                "https://www.youtube.com/watch?v=F9GV7vuIghw",
                "https://www.youtube.com/watch?v=Ab7U7lqikfU",
                "https://www.youtube.com/watch?v=A-KphPemhhg",
                "https://www.youtube.com/watch?v=SrPHLj_q_OQ",
                "https://www.youtube.com/watch?v=W4hTJybfU7s",
                "https://www.youtube.com/watch?v=g3TJ2bMfXsc",
                "https://www.youtube.com/watch?v=y3exATaC0kA",
                "https://www.youtube.com/watch?v=Clvz5gVTUyM",
                "https://www.youtube.com/watch?v=gBXhNwFX4u4"};

        String [] urlImageVideo = {
                "https://lh3.googleusercontent.com/IU60zdlxuBl-76M-2b9Qu_unHH1-gOqFx9sQKKum0IxBxxjtYFiGDsBbfW34TxwXOxDJTCTXJbsoy5ff_1fY9Dc9-yKIIPQ5edMXHxRTxRiOe55-CHlM6thRCXPOdl3RNKFu0eP4EiRWVCT3ddIP_4C86GJ4dOvh2dt8EDfngyp72rkLVPcINowGMFF2X_v_Q-HwtInT4CcbVJgpe970iWr6-3G_atmLbFm04ugb9b8Lvw7xI8KkLHSvJxVLzIJkZSWXx2-ZGPYWahpzH9tuLx4V0SONol21TPPXCZjxH0svyk4wBXUO0eiDcU8R4kJS0Tc7f4UI9f_nxdW6fQ6GMYfhJR5j2JGV87bvwuX99yEco-FrT7uWlesrZdg7_a-1ebQJxk8gWM7TsX0NuSaMy6bc_yhcxeqQ_Pgc9iE7pfaq30FxGnqL6kmoz-6mMil52bwBg1-thyuT6GzhpxfvW8crGZieC7lKf1zi36wCpqrlCl4CPGSf_x_AY0wYTVSFbSQ6DzPfPZE21q6fGLft2CfpRgIlc3LhKT-DWuhX_hLMPcaYognieS0Lh3ZlHfx3Qr_kdmIr41wEexWyuFkIA3k_WZv8bJX92dnsmSs=w920-h613-no",
                "https://lh3.googleusercontent.com/hYNoOnzoSLyPuYG80ScRsCHgeHtOK7VmGBQEL9tXONU_w9FuCnREYCREiCLquaDtROm4162_xZAxFIoV2BMnsgRk5grbLMY8VOD9PPCs7psFd2EDkj0smVPl2xUKmZxYZ4te0jZ8VU7LRpDCPNzyKv-5t_PyTI3Q30aq8PoVJ3F8qGbqJ-0DJqOVrOkvesGJJ_Nj6N_Ll6L6QoXyPOXvGrmbc2VZn8SaHdHy0UziPQlmjtklkPFNoigRw8vqzzV88BD2q4nEdPNOGG79TZNO0It3Rm_M0qTlak9HSGWS9RZlVD49vOrBeXHXfapYzp5oWcIK_87KTrY5omb4J6QENTwGeHNXxtI7adfwZSVC2zbWiGw5I1Wj5Gt9kNwtabqoQGJA71cDEdNWoAtONEWfKlINHLF20_gwF2Ebn5B2D8I9T3jkz37_cbc3Yc10zRjU7BBJ9B_-zQ_eZYMfEsajUFT7FyPe6UCZZ5_A63bWuPEkpZwTYhEUcDLqwW5WRUeHTpbh_93jWFvRI9zuTkrfR4Iqhi6xuk0bYqw6RIEaHto8TgcQcWgjqIeRN_seG8ivube-efxbBelsGpBXWoCwgxuES9sINL6-FoFerNw=w994-h662-no",
                "https://lh3.googleusercontent.com/sLyksxf_GJHJrpqGSviBjuCHAVOMwQdTa5792QwdLldj3ncpbMytkc0vNv44i3ZuIIloCaGgphZgGH5tJ-j9zSuezuaXBlOjWvqd2PCpvGK0tCJAKcTjwzFIpI0iIgml-vzN4wKgxzywX20IRovvYElEzg-afJmE1Tz_bUlwtSO_SbWIHVkh1gkqh2mPCsvNjn5tCbgcMaQjqXaBoYh7sVjp_1pgUABVaG75_la7-NPxJv0q0a-bZNMqcmeKuGmet3Ihd2eGIGmJbwUaQhWGsQfIKw_i8lUUkbGWodYjyTVXSEynZI8GSssv2LW1MEiNSBCX8K6Brjysex6FyOwnBvRaJySk3G81BqIwdR5_TdkIVxtMwLtxXVcDf2tqjAbJ7KQLbVuugnncp67vWBc1l94JzFP-W_56YTAjkDGP7bOJMoQX1gBFq86oLUfuobX5SK3c0z8CBbAvp57M9jF802b5UJO2cRQHUYc3Cq9d5A9lB-S3Otu0rip6_aFgZ9FFac8f9bBFANt40npc_YyldOj8xNRT2i53RXbtcC4DZe546VRtYtm_w4qoMDe7-hVWrEX0KBSJqBCTwUhIk5jZ4D2WCf-2w31cmkFzzVc=w994-h662-no",
                "https://lh3.googleusercontent.com/uRoVdDk7gMsUhr_LDYp-s7oglXrh7F5Jh4H-x9uuNes5yW1UEAlLVjY4cpAsWADY4ElRjN6G5uhkPfN4lzNZpXh4j_5x5DBRXa-X_IjY2lzuQTZVpPQxveYTSNrA3djZr5oVrHZaW7bYjfIeoFIzzCuQly1C-zdosbdqOyrFuQdqIh9A0eTIxReHfFyEN07g2owxH5mlhKd5Zfawpf6uK4L0H21Jf-LTikfCLPHyDnpz1bgRtn7OVunYQ_kqFE6O8fdKsLjiJp9ZYD1Y_PiXSeAQBytrum8F-Jb8EtW8TK6a4nin7FIp186ggKVMAn6iszfUbZGspCNK-jc9yjA_RrcwFP2G0isR3k0JuQv0bdv25M92McKgs74-O4ghTBB3cAIOjfNKt1R_rqeQhhdZyeH1p7Y-GPRQ6guXxrVHAwC_KY3YfhYj-lpnYse7y1sakUQTmYo6xC7KREhYXGhW4l4_0x_xKrhN6bRGT8eee5H6VXRnIp-x87AMphc807Flimorj9HHlCRmmZAVG1pp3rYkrfJIqbVPbiLMZPi4vSjfzBgVHEgpq4lFBu5JXN5LLvOQ1wOZlRsEWXBiIGzVjxU75XhsrTnZN7dVO5U=w994-h662-no",
                "https://lh3.googleusercontent.com/nYV5xpCa9400uf9pSy7FuMs7iK6TwB39pzg6Jw3f6VFihKN4nVK467iildcfDOkKy3hUMRSL-32s9WV9B0of8ZZxipt0lOvmxKQPnQtKNrMhqONFKgeS4JY3D-CagrpreYrMvvsOxrXZCJZUnCMsf0EtL7KGGrgSWQD34d1WiYYi37wgYR-WJ2gFdc9li_q45GSxXYB-6MyjksOEnz6QT9PSmUg3FITPVxPvwELRP7DHtD6M_UvdOYmS2d7JzaTcxPeI8wsga2jyLdXMu0qOvbMv4YCEDjP2wbhHDJP3Hbr8cv_qvfVDYros5nPiQKw9dRoE8DDHffRJCeqUGadO4Wr8O85dl3cMCpSbPOt22av2jrj2_xasZg523ikPZ13hyu9CU2ElvGKm6N6xYYEKp8_84wW13ZIgmLBsBKtcLxVoA1MvdL3jbJp2dLAnLYT3oFI0ViV-8tonZOyot_TXHtrZGhQBDfKaZobQJau6FG5lq-I5Vyhm4yY64RsQdCaM1ypZlws2CCMMqILTGTP075gV8xJWAWufoQ9eg4lX40MdIIRfAERBCIvEg-5GWF_fYQusJaW13ZPPRFKRg37ElaRl9IJQ-XI44nAiyQg=w994-h662-no",
                "https://lh3.googleusercontent.com/fLP6jmjfodIpD_3H87TQwGKLeGX42eeKzqmJAu2tWxHIyXvWMCohnaPMfEg7L-H9GaqHWNZ0mpqFge4r5CqQU9AqNt4EA_voM4Mz_i1lFvErgC5mKC5YDfe3ble7HFxla5yYisdS9eAWwRLmy6z9LsFpRfOrnHBjlb-q3s3aSpO1Mn_6u71kjztECG1hzaSnKp4YnWRuXKCOmvfJXdAVPz1Zrbc4JkdWH1yk4ov-SBhTwDAjXZRsE_81AmNikV_0Y3Z8V26CKOegjwYBxj6ytE1Y6hMl_rfxGbkiLAfgY3aJ47UhkP-Bw9WqK6GnMcD3xuVB90cA1tKRezWZM-f6cbexXq7Dv9tOOmm9GJ5GrZkjGwmJ_GveqdxMmPhc6MwccfNbXSlP9euxva_a0aptnWqmL22i3J7Mkr9Ntyc8lD9zotAFq7C2qA8ZZ7J7ZFsF5VDd1gPcBfxm0f3hLRIH3gwsIPR5t7Cb9-I8fAoodR7xFf7Tu3Z3JVo644n6UdQi4NdbcezBYyawd_nL-ptAx09PjX60R4ouj3eXEWxRZVGx88VYt596FG41v8LXa9JxptmRpvZpX5Sz9iZBfNzpnXmSHdkkoLFyppB1SKA=w994-h662-no",
                "https://lh3.googleusercontent.com/2hX_HNaQ530LWKgMasX3-4AVl7viPFLPoOmr1tEeM0NJTIOehl-3lAdWqLTFeWVHPcY3LfA8z3fRfsNV1qAXMjpl3GWloX_O6YwOmh29Dp_HJ5JbLf9mYDxabPatsmO2l_7kEt-ji1wP8rDCtaAxx82m5emttztsGa4kHQezP15Oka2UJjW4n3R2V433tjYe7voGnRLQTbA3OSZU8X5X3YMA48Ii3DlQOup4hM9TGfWYcNUtGZCD_cROQ2iG9bYPHho40tIVLvrkarClkYWMX1nRVr3YGLYXwi4qzokEt9gL-02yFN1dC8uC02zSYQhhgULyTnFhRuDsEnNopOyKU-w5s5qiYAW55sl1etO45Me356nQU0Wz0Pr_mBDouyToVfu_f8LJJCpkvGDoIyTTPoJy_GcLtw5F7uhQoorVLvlQea_A4m39tDIpST5b3kYbnHMjwESZadJ9GxHZteAUmdj6GCzwOPbpk9NumV8INuzikj8WRpQxMJ7HTAoR13Kl6xKz8n-yQHQnOuVUEnFS_lkWXaaxqFG4iPDrsK4UmvPRKymfgLjdRprFZjosSbuxDHSVwj25BCs-lYOSXM3l2Mj8W63NC7k0u5h6VHs=w994-h662-no",
                "https://lh3.googleusercontent.com/c3eOHb4PJBVTvgbVz9mniPBAyUQAY8sayUZ1Qvpgfk8jzsYj-sMyBXMs0GOvOfgxXOLbjyZBM56SyZ9BR7WxZSxxc1TxR_zXBO0gddwfOMWM01CpfaNh6NQELbNdbt8RiGgYD5uljwAokWma0mWVnmFLSioACFp-w9eumWIL0IG0_0bLmqfA3b4YS3uc9_p4S9HM3ZegD2HXbG9FIBFlh5usF_XTkety5E31O75yrNV3D0SUEHT6TRHORy8IT4N2wKLTHvLW1ih1Gy0bLBGCIi4N_vclomKDeXsiRAagE0dXHfJImmJi932VwcK9KqADre5w-yY44ZStDubpHnh8rf9Bu3yfX7uDHExsJpbYpJezuvDjSIYcrRkpuD_u1I2SJOQvJLiBA_jb77qQTlRujCwWDf85AOQVosggCvxrp0-udNOtkJw0xKUNK0_05jd5bxQTsjZgzO_DT6m5AqRG8-YCR1YNSMDNtdroBPBs5ejwbbrFwoWVXrSuj7RM3UwbuETpdmw6ZbqR5MXqJU5iDUNHqbcVfvT-tudZkA9wC-6f90veF5rkdnf31sQ_GoFqtLA2d3mKJ8gAOy3g3j3t6uGOhbsSi9tuwPE6k1U=w994-h662-no",
                "https://lh3.googleusercontent.com/CgrIpohTf8lyo_4q7hXYheMSxKC3RA5d1qMfit06_EPLD1bi7WaP3f-s40W9d9tee1IK4VYjp_yl_cUojMuhNuHi95YYNLAwifxNdMhgLQYOJAYtO9pFla_Sj0PMOzBCKgI7kjl9b6AGMv77ygHptQlQCIUWOlNDYU6lrppDpXMb1T129oIyQoQxOuWlj0MuDQ-u9aVnjx5Gbu0UeKS52DYOJPlbzdeVyKrXwX3Cpf3BYmrW3j4i0RAPrE5DSYBsEJCHDgEQPleV4Up5NIOg5IAnCPjVpMG4HNuLz-mZ6pwa9dFKy8uKOVBuy2Z3NsXN6dOIrt1krxOHkIma87L6cnAjpQUrj9esSxv6JGe8I2EVgHSTdQkq1ib-QdIPZMSdFzoCZKAq4YBdevDH479vcqD0nqknt-1twIAU7ZNMZI_HMe4KiKPWXEGoY6Cwb0x1VcjfCrIBFSruek0hsp1OGthRcAke6vLCbA8TwfB4K7HnuePxLJuONguS7TTVeG2XwdkMdBsSK1LkxnoTx0tbqUxZ_ONWvLUPszl9QdWiWUyNPXW9s_qC8G_60hDIyYpB-m9nDSBDtWzDyryGLaqaGU3b6dPorE9RJP92MB4=w994-h662-no",
                "https://lh3.googleusercontent.com/nFIqzvoXH36Zoo7lUfqWM65U_3l8PnR_afJCSTIQ4HbtZiQWTCM3fzFjqbz-4GLfz6eTPJ9_bnNhRvFHFqMgcLJb6jKbGE1Tp_Bi9lKj6dJM3qL4DExcFP1biNiY2hX4jsIZNdPmL1LrWRlB49ppdkoeIug1nXdurwiTQ9inR1IPbEr_Qvwtllq1ryzmMNPawd5SBuY9LqlL48yLhseR2PXjuqPGcHQpZoLvfvc3I8sFvqcDhcK_hR47ERWAfxOkMszOpbPt0OPf9os49YoMtbNUqxrSN7E2dQVNqlUJc9FeDndUj06Cf00S-fXk9X40w2agjsCFyiug0jK-Q0bAGZixirQZOC8P7oMh23AKmvtDV09qGkFMd-PZBDvxo1w_kRZb1JJOgva4DS9E_x-ZWzgib39fBQOUKw_qzA6pItRVOvjTlTRp4Ugs3M6hZf6Thjt8EABO6DlT3gFoqrwRWS_BI-YRzkDw_Yi5h5mdb7kjEC3zq4GQ99VoBEFqAODRjfEz7nmIL1tC7TGnrAHtRli9BqrtibvunndeIUPXMQnh4cV1TCQQydctSPn3xXxziRZwUkyxtVuJcRK5U9RRjUTqxazM9ZFtytXUthk=w994-h662-no",
                "https://lh3.googleusercontent.com/AzMVzf51gwAMZKGGGZnIoocbB47qkT-0zP6bSTpabdbROm5qQuBt-dutuljHOynZtnHNOz52_b1FjvCgH9OaCm-LEJWg63PaZByiF-1UKK0wPwgQ1gHixio0lBPff23zUUkyxvkuQErjdB3eaG9BwMhs0HsgOxeJxakG_Hubs_FdmzeY20yVAfmm-IKOBWqWZaTwk7oZiK6izXJeoee0sWv6Wf-0d-7O77x6S8BupA4Id_KlV81_8dAuO9Cz-fzLjf850kWCdeSNgSjw4xZJbU4eSsSSq2qFsh1VFnlK4sBRje6EmE4c8s0vBqqpTp1Ie9pkU6sr7vyp0WreRt-_fPoLQ4-wa_XqB2b8ryjs8LLOPAB9lDoNQBlyT8CyzWdy0zkKRgwvdL6GzHBZ1t1bborKftK8hWuJm9T59jVUrniP_QNPfgO_CujZi8FUb9gNfCqVzV5v9yq2dqIbl6eHgoTDI0OQJSse7hrw_2TUaEc44KRFOFSOjwFd_-m-tHD8_IpTN3p2iwU8ZzgWgzroG85C80we57RKCAAas8t7hU4QCYlvJi_O5gbDERYpoI1EtkF20fFNyaAVFrAu8omxxXWknvlGYwNj02339nE=w994-h662-no",
                "https://lh3.googleusercontent.com/SYR7-z8jZ6VEYNVbS0tMAHHGF1QfVwtYXmjCxBLDIz46F42yXoLHv7xaij6qQQ7uNpHiabHfyM8GSS6quA37wyyi3rJ6uHiW05T9W9WLIhaPoufrlFeG8JIgeGxuS7t3K09SpR_kj3d2BAUoiU4H0tAMzmQsn0lCnGAQKcghU4EhtlVezAZt5L7s5CCIHErGV43vyJOZcg0IeVb14wyjBwam5zCFzQA71AlsoscYP9YiNGGB3WgdpX_GtWHFKut9hPuagqZoLarfv6YiffU7KE58i-lVk1ZuwEcVV1rm6Lsh5gusReB8sEZzLWSWOR4LTimomfLh4b9C2bpWQJZFqFT6ACxTkkFD1kkTqgRNM8-7SYVH46DDw6z0PNLzmopAxxmY0TPlLcKS4A204aioyMzk1H5cMRepI44W059lb7geaf1PgA3muVVN93NwfwnykTkNAHxbnP-9OZZSRuv27epOlefV76koe7iWQm6kBV3TPrBVsvRRn7HgpiCEiTWgixwDKE4cuGT51We1ZxVlJ6zmkq-tbG2ZvQyWcJIcnr-c_V-tmuu6-ZLldfo0g_H1R4ip8vjA-xvA1eRwMmAi5fvpWPkgfM_rs_aXJ1Q=w994-h662-no"};

        for (int i = 0; i < 12; i++){
            Video video = new Video(i+1,name[i],duration[i],description[i],idVideos[i],urlVideo[i],urlImageVideo[i]);
            adapter.addVideo(video);
        }
    }

    private void confyAdapter() {
        adapter = new VideoAdapter(new ArrayList<Video>(),this);
    }


    private void confyRecyclerView() {
        recyclerViewAndroidVideos.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerViewAndroidVideos.setAdapter(adapter);
    }

    @Override
    public void onItemVideoClickListener(Video video) {
    }

    @Override
    public void onItemVideoLongClickListener(Video video) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

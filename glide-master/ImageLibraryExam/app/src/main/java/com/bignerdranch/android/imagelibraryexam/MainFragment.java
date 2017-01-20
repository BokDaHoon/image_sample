package com.bignerdranch.android.imagelibraryexam;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.bumptech.glide.request.target.Target;
import com.squareup.picasso.Picasso;

/**
 * Created by DaHoon on 2017-01-19.
 */

public class MainFragment extends Fragment {

    private ImageView glideImageView;
    private ImageView picassoImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        glideImageView = (ImageView) view.findViewById(R.id.glide_image);
        picassoImageView = (ImageView) view.findViewById(R.id.picasso_image);

        //Glide에서 사용할 animation object
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                view.setAlpha( 0f );

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat( view, "alpha", 0f, 1f );
                fadeAnim.setDuration( 2500 );
                fadeAnim.start();
            }
        };

        //Glide 이미지 로딩
        Glide.with(getContext()) // 액티비티와 LifeCycle과 동기화
                .load("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSO6Qh6k7iKlqZK8Kw_xbXiFVwrNuSWa36H3xSBqkipNRiAVID3")
                .override(600, 600) // 이미지 리사이징
                /*.listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        Toast.makeText(getContext(), "Glide Ready!", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                })
                .thumbnail(0.1f)*/
                .animate(R.anim.slide_in_left)
                .into(glideImageView);

        Picasso.with(getContext()) // 액티비티와 LifeCycle과 동기화
                .load("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSO6Qh6k7iKlqZK8Kw_xbXiFVwrNuSWa36H3xSBqkipNRiAVID3")
                .resize(600, 600) // 이미지 리사이징
                .into(picassoImageView);
                /*.into(picassoImageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getContext(), "Picasso Ready!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError() {

                    }
                });*/

        return view;
    }
}

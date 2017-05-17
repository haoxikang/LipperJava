package com.fallllllll.lipper.ui.shotbeandetail;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Animatable;
import android.support.annotation.Nullable;
import android.transition.Transition;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.activity.BaseActivity;
import com.fallllllll.lipper.data.databean.ShotBean;
import com.fallllllll.lipper.databinding.ActivityShotDetailBinding;

/**
 * Created by fallllllll on 2017/5/16/016.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class ShotBeanDetailActivity extends BaseActivity {
    private ShotBean shotBean;
    private SimpleDraweeView simpleDraweeView;
    private Animatable animatable;
    private boolean canPlayGif;

    @Override
    protected void initViewAndData() {
        ActivityShotDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_shot_detail);
        shotBean = (ShotBean) getIntent().getSerializableExtra("shotss");
        binding.setShot(shotBean);
        simpleDraweeView = binding.imageDetail;

    }

    @Override
    protected void initListeners() {

        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(
                    String id,
                    @Nullable ImageInfo imageInfo,
                    @Nullable Animatable anim) {
                if (canPlayGif) {
                    if (anim != null) {
                        anim.start();
                    }

                } else {
                    animatable = anim;
                }

            }
        };
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setLowResImageRequest(ImageRequest.fromUri(shotBean.getImages().getNormal()))
                .setImageRequest(ImageRequest.fromUri(shotBean.getImages().getHidpi()))
                .setControllerListener(controllerListener)
                .build();
        simpleDraweeView.setController(controller);

        Transition transition = getWindow().getSharedElementEnterTransition();
        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
                if (animatable != null) {
                    animatable.start();
                } else {
                    canPlayGif = true;
                }
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
    }
}

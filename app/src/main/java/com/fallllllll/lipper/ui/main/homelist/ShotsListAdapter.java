package com.fallllllll.lipper.ui.main.homelist;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fall.generalrecyclerviewfragment.GeneralAdapter;
import com.fall.generalrecyclerviewfragment.GeneralDataController;
import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.constants.AppConstants;
import com.fallllllll.lipper.data.databean.ShotBean;
import com.fallllllll.lipper.ui.shotbeandetail.ShotBeanDetailActivity;
import com.fallllllll.lipper.utils.FrescoUtils;
import com.fallllllll.lipper.utils.StringUtils;


/**
 * Created by fallllllll on 2017/2/4.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class ShotsListAdapter extends RecyclerView.Adapter<ShotsListAdapter.ShotsListViewHolder> implements GeneralAdapter {

    private Context context;
    private GeneralDataController<ShotBean> mStringGeneralDataController;
    private ShotsListLayoutEnum shotsListLayoutEnum;


    @Override
    public ShotsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_view_shots, parent, false);
        return new ShotsListViewHolder(view);
    }

    public ShotsListAdapter(ShotsListLayoutEnum shotsListLayoutEnum) {
        this.shotsListLayoutEnum = shotsListLayoutEnum;
        mStringGeneralDataController = new GeneralDataController<>(this);

    }

    @Override
    public void onBindViewHolder(ShotsListViewHolder holder, int position) {
        ShotBean shotBean = mStringGeneralDataController.datas.get(position);
        holder.bindView(shotBean);
    }

    @Override
    public int getItemCount() {
        return mStringGeneralDataController.datas.size();
    }

    @Override
    public GeneralDataController getGeneralDataController() {
        return mStringGeneralDataController;
    }

    class ShotsListViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout itemShotRootLayout;
        private CardView itemShotCardView;
        private LinearLayout itemShotTopLayout;
        private SimpleDraweeView itemShotUserImage;
        private TextView itemShotUserName;
        private ImageView itemShotReboundImage;
        private SimpleDraweeView itemShotImage;
        private ImageView itemShotGIFImage;
        private RelativeLayout itemShotBottomLayout;
        private LinearLayout itemShotCommentsLayout;
        private TextView itemShotCommentsNum;
        private TextView itemShotViewText;
        private TextView itemShotViewsCount;
        private TextView itemShotLikeCount;
        private TextView itemShotLikeText;
        private TextView itemShotReplay;

        public ShotsListViewHolder(View view) {
            super(view);
            itemShotRootLayout = (LinearLayout) view.findViewById(R.id.itemShotRootLayout);
            itemShotCardView = (CardView) view.findViewById(R.id.itemShotCardView);
            itemShotTopLayout = (LinearLayout) view.findViewById(R.id.itemShotTopLayout);
            itemShotUserImage = (SimpleDraweeView) view.findViewById(R.id.itemShotUserImage);
            itemShotUserName = (TextView) view.findViewById(R.id.itemShotUserName);
            itemShotReboundImage = (ImageView) view.findViewById(R.id.itemShotReboundImage);
            itemShotImage = (SimpleDraweeView) view.findViewById(R.id.itemShotImage);
            itemShotGIFImage = (ImageView) view.findViewById(R.id.itemShotGIFImage);
            itemShotBottomLayout = (RelativeLayout) view.findViewById(R.id.itemShotBottomLayout);
            itemShotCommentsLayout = (LinearLayout) view.findViewById(R.id.itemShotCommentsLayout);
            itemShotCommentsNum = (TextView) view.findViewById(R.id.itemShotCommentsNum);
            itemShotViewText = (TextView) view.findViewById(R.id.itemShotViewsText);
            itemShotViewsCount = (TextView) view.findViewById(R.id.itemShotViewsCount);
            itemShotLikeCount = (TextView) view.findViewById(R.id.itemShotLikeCount);
            itemShotLikeText = (TextView) view.findViewById(R.id.itemShotLikeText);
            itemShotReplay = (TextView) view.findViewById(R.id.itemShotReplay);


        }

        public void bindView(ShotBean shotBean) {

            FrescoUtils.displayWithResize(AppConstants.INSTANCE.getUSER_IMAGE_SIZE(), AppConstants.INSTANCE.getUSER_IMAGE_SIZE()
                    , Uri.parse(shotBean.getUser().getAvatar_url()), itemShotUserImage);
            itemShotUserName.setText(shotBean.getUser().getName());

            if (TextUtils.isEmpty(shotBean.getRebound_source_url())) {
                itemShotReboundImage.setVisibility(View.GONE);
            } else {
                itemShotReboundImage.setVisibility(View.VISIBLE);
            }

            if (!TextUtils.isEmpty(shotBean.getImages().getHidpi()) && !shotBean.isAnimated()) {
                FrescoUtils.display(itemShotImage, shotBean.getImages().getHidpi(), false);
            } else {
                FrescoUtils.display(itemShotImage, shotBean.getImages().getNormal(), false);
                if (shotBean.isAnimated()) {
                    itemShotGIFImage.setVisibility(View.VISIBLE);
                } else {
                    itemShotGIFImage.setVisibility(View.GONE);
                }
            }

            itemShotCommentsNum.setText(StringUtils.numberToK(shotBean.getComments_count()));
            itemShotViewsCount.setText(StringUtils.numberToK(shotBean.getViews_count()));
            itemShotLikeCount.setText(StringUtils.numberToK(shotBean.getLikes_count()));


            if (shotsListLayoutEnum.getCurrentLayout() == ShotsListLayoutEnum.LINEAR_LAYOUT) {
                itemShotLikeCount.setPadding((int) context.getResources().getDimension(R.dimen.shots_item_padding_left_large), 0, 0, 0);
                itemShotReplay.setPadding((int) context.getResources().getDimension(R.dimen.shots_item_padding_left_large), 0, 0, 0);
                itemShotCommentsLayout.setVisibility(View.VISIBLE);
                itemShotViewText.setVisibility(View.VISIBLE);
                itemShotLikeText.setVisibility(View.VISIBLE);
                itemShotRootLayout.setPadding(0, (int) context.getResources().getDimension(R.dimen.shots_padding_top_large), 0, 0);
            } else {
                itemShotLikeCount.setPadding((int) context.getResources().getDimension(R.dimen.shots_item_padding_left_small), 0, 0, 0);
                itemShotReplay.setPadding((int) context.getResources().getDimension(R.dimen.shots_item_padding_left_small), 0, 0, 0);
                itemShotRootLayout.setPadding(0, (int) context.getResources().getDimension(R.dimen.shots_padding_top_small), 0, 0);
                itemShotCommentsLayout.setVisibility(View.GONE);
                itemShotViewText.setVisibility(View.GONE);
                itemShotLikeText.setVisibility(View.GONE);
            }

            if (shotsListLayoutEnum.getCurrentLayout() == ShotsListLayoutEnum.ONLY_IMAGE_LAYOUT) {
                itemShotTopLayout.setVisibility(View.GONE);
                itemShotBottomLayout.setVisibility(View.GONE);
                itemShotCardView.setCardElevation(context.getResources().getDimension(R.dimen.shots_card_elevation_image));
            } else {
                itemShotCardView.setCardElevation(context.getResources().getDimension(R.dimen.shots_card_elevation));
                itemShotTopLayout.setVisibility(View.VISIBLE);
                itemShotBottomLayout.setVisibility(View.VISIBLE);
            }
            itemShotImage.setOnClickListener(v -> {
                Intent i = new Intent(context, ShotBeanDetailActivity.class);
                i.putExtra("shotss", shotBean);
                View layout = itemShotRootLayout;
                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, Pair.create(layout, "layout"));
                context.startActivity(i, transitionActivityOptions.toBundle());
            });
        }
    }
}

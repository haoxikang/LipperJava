package com.fallllllll.lipper.ui.main.homelist;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fall.generalrecyclerviewfragment.GeneralAdapter;
import com.fall.generalrecyclerviewfragment.GeneralDataController;
import com.fallllllll.lipper.R;
import com.fallllllll.lipper.data.databean.ShotBean;
import com.fallllllll.lipper.databinding.ItemViewShotsBinding;
import com.fallllllll.lipper.ui.shotbeandetail.ShotBeanDetailActivity;


/**
 * Created by qqq34 on 2017/2/4.
 */

public class ShotsListAdapter extends RecyclerView.Adapter<ShotsListAdapter.ShotsListViewHolder> implements GeneralAdapter {

    private Context context;
    private GeneralDataController<ShotBean> mStringGeneralDataController;
    private ShotsListItemViewModel shotsListItemViewModel;


    @Override
    public ShotsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        ItemViewShotsBinding itemViewShotsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_view_shots, parent, false);
        return new ShotsListViewHolder(itemViewShotsBinding);
    }

    public ShotsListAdapter(ShotsListItemViewModel shotsListItemViewModel) {
        this.shotsListItemViewModel = shotsListItemViewModel;
        mStringGeneralDataController = new GeneralDataController<>(this);

    }

    @Override
    public void onBindViewHolder(ShotsListViewHolder holder, int position) {
        ShotBean shotBean = mStringGeneralDataController.datas.get(position);
        holder.getBinding().setItemViewModel(shotsListItemViewModel);
        holder.getBinding().setShotBean(shotBean);
        holder.getBinding().executePendingBindings();
        holder.binding.itemImage.setOnClickListener(v -> {
            Intent i = new Intent(context, ShotBeanDetailActivity.class);
            i.putExtra("shotss",shotBean);
            View layout =  holder.binding.itemShotLayout;
            ActivityOptions transitionActivityOptions =ActivityOptions.makeSceneTransitionAnimation((Activity) context, Pair.create(layout,"layout"));
            context.startActivity(i,transitionActivityOptions.toBundle());
        });
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
        private ItemViewShotsBinding binding;

        public ShotsListViewHolder(ItemViewShotsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ItemViewShotsBinding getBinding() {
            return binding;
        }
    }
}

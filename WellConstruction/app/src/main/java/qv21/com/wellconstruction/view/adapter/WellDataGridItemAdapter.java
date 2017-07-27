/*
 * Copyright (C) 2017. All rights reserved.
 * @author Dora Khiev
 */

package qv21.com.wellconstruction.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import qv21.com.wellconstruction.R;
import qv21.com.wellconstruction.domain.Owner;

/**
 * Created by Dora on 7/26/2017.
 */

/**
 * It is a Adapter for GridView. It follow Adapter Pattern for interaction between Container View and
 * Collection of Data.
 */
public class WellDataGridItemAdapter extends BaseAdapter {

    private final String TAG = WellDataGridItemAdapter.class.getName();

    private List<Owner> mOwnerList;

    public WellDataGridItemAdapter(List<Owner> ownerList) {
        mOwnerList = ownerList;
    }

    @Override
    public int getCount() {
        return mOwnerList.size();
    }

    @Override
    public Owner getItem(int position) {
        return mOwnerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        WellDataViewHolder viewHolder = null;

        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_well_data_grid, parent, false);
            viewHolder = new WellDataViewHolder();
            viewHolder.mImgIcon = (ImageView) view.findViewById(R.id.imgIcon);
            viewHolder.mTxtOwner = (TextView) view.findViewById(R.id.txtOwner);
            viewHolder.mWellName = (TextView) view.findViewById(R.id.txtWellName);
            viewHolder.mTankName = (TextView) view.findViewById(R.id.txtTankName);
            viewHolder.mTankNumber = (TextView) view.findViewById(R.id.txtTankNumber);
            view.setTag(viewHolder);
        }

        if (viewHolder == null) {
            viewHolder = (WellDataViewHolder) view.getTag();
        }

        Log.d(TAG, "Owner " + position + " is " + mOwnerList.get(position).getOwnerName());
        viewHolder.mTxtOwner.setText(mOwnerList.get(position).getOwnerName());
        viewHolder.mWellName.setText(mOwnerList.get(position).getWell().getLeaseWellName());
        viewHolder.mTankName.setText(mOwnerList.get(position).getWell().getTank().getTankName());
        viewHolder.mTankNumber.setText(mOwnerList.get(position).getWell().getTank().getTankNumber() + "");

        return view;
    }

    @Override
    public void notifyDataSetChanged() {
        Log.d(TAG, mOwnerList.get(0).getOwnerName());
        super.notifyDataSetChanged();
    }

    /**
     * By create ViewHolder, it is a best practice from Google to make the scrolling in GridView
     * goes smoothly.
     */
    public static class WellDataViewHolder {

        private ImageView mImgIcon;
        private TextView mTxtOwner;
        private TextView mWellName;
        private TextView mTankName;
        private TextView mTankNumber;

    }

}

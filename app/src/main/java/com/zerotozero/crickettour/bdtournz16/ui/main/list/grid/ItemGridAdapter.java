package com.zerotozero.crickettour.bdtournz16.ui.main.list.grid;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.zerotozero.crickettour.bdtournz16.R;

/**
 * Created by Saeed on 11/24/2016.
 */

public class ItemGridAdapter extends BaseAdapter {

    private final GridPresenter mPresenter;


    public ItemGridAdapter(GridPresenter gridPresenter) {
        this.mPresenter = gridPresenter;
    }

    public class GridViewHolder implements GridContact.View{
        TextView textView;
        ImageView imageView;
        View rootView;


        public GridViewHolder(View itemView) {
            textView = itemView.findViewById(R.id.item_text);
            imageView = itemView.findViewById(R.id.item_image);
            rootView = itemView;
        }

        @Override
        public void setView(final int position, String title, String imageUrl) {
            textView.setText(title);
            loadLiveImage(Uri.parse(imageUrl),imageView);
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPresenter.itemClicked(position);
                }
            });
        }
    }


    @Override
    public int getCount() {
        return mPresenter.getItemCount();
    }

    @Override
    public Object getItem(int i) {
        return mPresenter.getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        View rootView ;
        GridViewHolder viewHolder;
        if (view == null) {
            rootView = (View) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.book_item_layout, viewGroup, false);
            viewHolder = new GridViewHolder(rootView);
            rootView.setTag(viewHolder);
            mPresenter.bindView(i,viewHolder);
        }
        else {
            rootView = view;
            viewHolder = (GridViewHolder) rootView.getTag();
        }

        return rootView;
    }


    private void loadLiveImage(Uri uri, ImageView imageView) {

        if (uri != null && imageView != null) {

            final Context context = imageView.getContext().getApplicationContext();
            final Uri thisUri = uri;
            final ImageView thisImageView = imageView;
            Picasso.with(context)
                    .load(uri)
                    .placeholder(R.drawable.ic_launcher_background)
                    .networkPolicy(NetworkPolicy.OFFLINE)
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            Picasso.with(context)
                                    .load(thisUri)
                                    .placeholder(R.drawable.ic_launcher_background)
                                    .error(R.drawable.ic_launcher_background)
                                    .into(thisImageView);
                        }
                    });


        }
    }




}

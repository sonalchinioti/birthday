package com.whitebutter.birhtday.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whitebutter.birhtday.R;
import com.whitebutter.birhtday.activities.NActivityYoutubePlayer_;
import com.whitebutter.birhtday.models.NVideoModel;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

/**
 * Created by sonal on 31/10/17.
 */

public class NListLearnAboutVr extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<NVideoModel> list_item;





    public static class ViewHolder{
        public LinearLayout rl_vr_row;
        public ImageView bg_image;
        public TextView tv_video_title;


    }


    public NListLearnAboutVr(Context context){
        mContext = context;
        inflater =LayoutInflater.from(context);
        list_item = new ArrayList<NVideoModel>();

    }


    public void addItem (NVideoModel model){
        list_item.add(model);
    }
    @Override
    public int getCount() {
        return list_item.size();
    }

    @Override
    public NVideoModel getItem(int position) {
        return list_item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder ;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.row_item_all_videos, null);
            holder.rl_vr_row = (LinearLayout)convertView.findViewById(R.id.rl_vr_row);
            holder.bg_image = (ImageView)convertView.findViewById(R.id.bg_image);
            holder.tv_video_title = (TextView)convertView.findViewById(R.id.tv_video_title);

            convertView.setTag(holder);

        }else {
            holder = (ViewHolder)convertView.getTag();
        }


        //loading images on image view
        Picasso.with(mContext).load(getItem(position).getThumbnail()).into(holder.bg_image);

        holder.tv_video_title.setText(getItem(position).getTitle());
        holder.rl_vr_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NActivityYoutubePlayer_.intent(mContext).VIDEO_ID(getItem(position).getVideo_id()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();

            }
        });


        return convertView;


    }




}

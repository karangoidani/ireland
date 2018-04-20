package com.collegedekho.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.collegedekho.MainActivity;
import com.collegedekho.R;

/**
 * Created by karan on 11/4/18.
 */

public class CollegeListAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context mContext;

    public CollegeListAdapter(Context mContext) {
        this.mContext = mContext;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_layout_college_list_row, parent, false);
            viewHolder.CollegeName = (TextView) convertView.findViewById(R.id.txt_college_name);
            viewHolder.Address = (TextView) convertView.findViewById(R.id.address_txt);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) mContext).onHandleClick("CollegeListOnClick");

            }
        });
        return convertView;
    }

    private static class ViewHolder {
        TextView CollegeName;
        TextView Address;
    }
}

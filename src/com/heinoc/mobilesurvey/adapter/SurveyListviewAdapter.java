package com.heinoc.mobilesurvey.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.heinoc.mobilesurvey.R;
import com.heinoc.mobilesurvey.model.Survey;

import java.util.List;

/**
 * 查勘任务listview适配器
 * Created by heinoc on 14-8-10.
 */
public class SurveyListviewAdapter extends BaseAdapter {

    private Context context;
    private List<Survey> surveys;

    public SurveyListviewAdapter(Context context, List<Survey> surveys) {
        this.context = context;
        this.surveys = surveys;
    }

    @Override
    public int getCount() {
        return surveys.size();
    }

    @Override
    public Object getItem(int i) {
        return surveys.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Survey survey = surveys.get(i);
        ViewHolder holder;

        if (view == null){
            holder = new ViewHolder();

            view = LayoutInflater.from(context).inflate(R.layout.survey_listview_item_layout, null);

            holder.address_txt = (TextView) view.findViewById(R.id.address_txt);
            holder.fSelect_txt = (TextView) view.findViewById(R.id.fSelect_txt);
            holder.tSelect_txt = (TextView) view.findViewById(R.id.tSelect_txt);
            holder.send_time_txt = (TextView) view.findViewById(R.id.send_time_txt);

            view.setTag(holder);

        }

        holder = (ViewHolder) view.getTag();

        holder.address_txt.setText(survey.address);
        holder.fSelect_txt.setText(survey.fSelect);
        holder.tSelect_txt.setText(survey.tSelect);
        holder.send_time_txt.setText(survey.send_time);


        return view;
    }

    private class ViewHolder{
        TextView address_txt;
        TextView fSelect_txt;
        TextView tSelect_txt;
        TextView send_time_txt;
    }

}

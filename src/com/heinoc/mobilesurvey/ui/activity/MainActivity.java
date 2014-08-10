package com.heinoc.mobilesurvey.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.heinoc.mobilesurvey.R;
import com.heinoc.mobilesurvey.adapter.SurveyListviewAdapter;
import com.heinoc.mobilesurvey.model.NetWorkEntity;
import com.heinoc.mobilesurvey.model.Survey;
import com.heinoc.mobilesurvey.model.User;
import com.heinoc.mobilesurvey.network.WebInterface;
import com.heinoc.mobilesurvey.utils.JsonParser;
import com.heinoc.mobilesurvey.utils.SurveyApplication;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalDb;
import net.tsz.afinal.annotation.view.ViewInject;
import net.tsz.afinal.http.AjaxCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 *
 * Created by heinoc on 14-8-9.
 */
public class MainActivity extends FinalActivity {

    @ViewInject(id = R.id.title_txt)
    private TextView title_txt;
    @ViewInject(id = R.id.menu_ibtn, click = "clickListener")
    private ImageButton menu_ibtn;

    @ViewInject(id = R.id.waiting_survey_txt, click = "clickListener")
    private TextView waitingSurvey_txt;
    @ViewInject(id = R.id.surveying_txt, click = "clickListener")
    private TextView surveying_txt;
    @ViewInject(id = R.id.surveyed_txt, click = "clickListener")
    private TextView surveyed_txt;

    @ViewInject(id = R.id.survey_listview)
    private ListView survey_listview;

    private SurveyListviewAdapter surveyListviewAdapter;


    private User user;

    /**
     * 请求接口时提供的任务id
     */
    private String task_ids;

    /**
     * 查勘任务list
     */
    private List<Survey> surveys;

    private FinalDb finalDb;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        initView();

    }

    private void initView(){
        user = ((SurveyApplication)getApplication()).user;
        finalDb = ((SurveyApplication)getApplication()).finalDb;

        title_txt.setText(user.realname);

        if (surveys == null)
            surveys = new ArrayList<Survey>();

        surveyListviewAdapter = new SurveyListviewAdapter(this, surveys);
        survey_listview.setAdapter(surveyListviewAdapter);

        survey_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //todo:listview点击事件处理（跳转到任务详情）
            }
        });

        getTaskList();


    }

    /**
     * 点击事件
     *
     * @param view
     */
    public void clickListener(View view){
        switch (view.getId()){
            case R.id.menu_ibtn:
                break;
            case R.id.waiting_survey_txt:
                changeBottomBtnStatus(view);
                getTaskList();
                break;
            case R.id.surveying_txt:
                changeBottomBtnStatus(view);
                getSurveyingTaskList();
                break;
            case R.id.surveyed_txt:
                changeBottomBtnStatus(view);
                getCompleteTaskList();
                break;
        }

    }

    private void changeBottomBtnStatus(View view){
        waitingSurvey_txt.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.gray));
        surveying_txt.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.gray));
        surveyed_txt.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.gray));

        view.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.bottome_btn_selected));

    }

    /**
     * 获取待查勘任务列表
     */
    private void getTaskList(){
        surveys.clear();
        WebInterface.getInstance().getTaskList(user.token, task_ids, getTaskListAjaxCallBack);

    }

    /**
     * 获取查勘中的任务列表，从数据库中获取数据
     */
    private void getSurveyingTaskList(){
        surveys.clear();
        surveys = finalDb.findAllByWhere(Survey.class, "status=查勘中");
        surveyListviewAdapter.notifyDataSetChanged();

    }

    /**
     * 获取已查勘任务列表
     */
    private void getCompleteTaskList(){
        surveys.clear();
        WebInterface.getInstance().getCompleteTaskList(user.token, task_ids, getTaskListAjaxCallBack);
    }

    AjaxCallBack<String> getTaskListAjaxCallBack = new AjaxCallBack<String>() {
        @Override
        public void onSuccess(String s) {
            super.onSuccess(s);

            JsonParser.getInstance().getSurveyList(s, surveys);

            if (NetWorkEntity.getInstance().hasError()){
                Toast.makeText(MainActivity.this, "网络请求出错：" + NetWorkEntity.getInstance().errmsg, Toast.LENGTH_SHORT).show();
                return;
            }

            surveyListviewAdapter.notifyDataSetChanged();


        }

        @Override
        public void onFailure(Throwable t, int errorNo, String strMsg) {
            super.onFailure(t, errorNo, strMsg);

            NetWorkEntity.getInstance().errcode = errorNo;
            NetWorkEntity.getInstance().errmsg = strMsg + "\n" + t.getMessage();

            Toast.makeText(MainActivity.this, "网络请求出错：" + NetWorkEntity.getInstance().errmsg, Toast.LENGTH_SHORT).show();
        }
    };

}

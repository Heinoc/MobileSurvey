package com.heinoc.mobilesurvey.ui.activity;

import android.os.Bundle;
import com.heinoc.mobilesurvey.R;
import net.tsz.afinal.FinalActivity;

/**
 * 查勘任务详情界面
 * Created by heinoc on 14-8-10.
 */
public class TaskDetailActivity extends FinalActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_detail_activity_layout);
    }
}
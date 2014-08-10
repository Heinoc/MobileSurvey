package com.heinoc.mobilesurvey.utils;

import android.app.Application;
import com.heinoc.mobilesurvey.model.User;
import net.tsz.afinal.FinalDb;

/**
 * Created by heinoc on 14-8-10.
 */
public class SurveyApplication extends Application {

    public User user;

    public FinalDb finalDb;

    @Override
    public void onCreate() {
        super.onCreate();

        if (user == null)
            user = new User();

        //测试数据
        user.realname = "乔布斯";
        user.token = "118e6d6287cb48a82f37f8639a94db14";

        if (finalDb == null)
            finalDb = FinalDb.create(this, Constants.DB_NAME);

    }
}

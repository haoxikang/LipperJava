package com.fallllllll.lipper.utils;

import com.fallllllll.lipper.data.local.user.UserHelper;
import com.fallllllll.lipper.data.local.user.UserManager;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.robolectric.shadows.ShadowLog;

/**
 * Created by fallllllll on 2017/4/13/013.
 */

public class BaseRule implements TestRule {
    private UserHelper userHelper;

    public BaseRule(boolean isLogin) {
        if (isLogin){
            this.userHelper = TestUtils.getLoginMockUserHelper();
        }else {
            this.userHelper = TestUtils.getDefaultMockUserHelper();
        }
    }


    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                ShadowLog.stream = System.out;
                UserManager.INSTANCE.init(userHelper);
                base.evaluate();
            }
        };
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }
}

package com.fallllllll.lipper.ui.main.home;

import android.support.v7.widget.AppCompatRadioButton;

import com.fallllllll.lipper.BuildConfig;
import com.fallllllll.lipper.R;
import com.fallllllll.lipper.TestApplication;
import com.fallllllll.lipper.core.MyRobolectricTestRunner;
import com.fallllllll.lipper.core.constants.AppConstants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;

/**
 * Created by fallllllll on 2017/5/12/012.
 * GitHub :  https://github.com/348476129/Lipper
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, application = TestApplication.class)
public class HomeBottomSheetFragmentTest {
    @Test
    public void testHomeBottomSheetFragment() {
        HomeBottomSheetFragment homeBottomSheetFragment = HomeBottomSheetFragment.newInstance(AppConstants.INSTANCE.getNOW(), AppConstants.INSTANCE.getSHOTS(), AppConstants.INSTANCE.getPOPULARITY());
        startFragment(homeBottomSheetFragment);
        AppCompatRadioButton appCompatRadioButtonTime = (AppCompatRadioButton) homeBottomSheetFragment.getView().findViewById(R.id.timeRadio1);
        AppCompatRadioButton appCompatRadioButtonType= (AppCompatRadioButton) homeBottomSheetFragment.getView().findViewById(R.id.typeRadio1);
        AppCompatRadioButton appCompatRadioButtonSort= (AppCompatRadioButton) homeBottomSheetFragment.getView().findViewById(R.id.sortRadio1);
        assertTrue(appCompatRadioButtonTime.isChecked());
        assertTrue(appCompatRadioButtonType.isChecked());
        assertTrue(appCompatRadioButtonSort.isChecked());
    }
    @Test
    public void testHomeBottomSheetFragment2() {
        HomeBottomSheetFragment homeBottomSheetFragment = HomeBottomSheetFragment.newInstance(AppConstants.INSTANCE.getWEEK(), AppConstants.INSTANCE.getDEBUTS(), AppConstants.INSTANCE.getRECENT());
        startFragment(homeBottomSheetFragment);
        AppCompatRadioButton radioButtonTime = (AppCompatRadioButton) homeBottomSheetFragment.getView().findViewById(R.id.timeRadio2);
        AppCompatRadioButton radioButtonType= (AppCompatRadioButton) homeBottomSheetFragment.getView().findViewById(R.id.typeRadio2);
        AppCompatRadioButton radioButtonSort= (AppCompatRadioButton) homeBottomSheetFragment.getView().findViewById(R.id.sortRadio2);
        assertTrue(radioButtonTime.isChecked());
        assertTrue(radioButtonType.isChecked());
        assertTrue(radioButtonSort.isChecked());
    }
}
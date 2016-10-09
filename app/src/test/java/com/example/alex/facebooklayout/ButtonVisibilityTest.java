package com.example.alex.facebooklayout;

import android.widget.Button;

import com.example.alex.unittestobject.Timer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 22)
public class ButtonVisibilityTest {

    private Button mButton;
    private ThirdActivity mActivity;
    private Timer mMockedTimer;

    @Before
    public void init() {
        ActivityController controller = Robolectric.buildActivity(ThirdActivity.class).create().start();
        mActivity = (ThirdActivity) controller.get();
        mMockedTimer = Mockito.mock(Timer.class);
        mActivity.createTimer(mMockedTimer);
        controller.resume();
        mButton = (Button) mActivity.findViewById(R.id.btn);
    }

    @Test
    public void invisibilityTest() {
        Mockito.when(mMockedTimer.isTimeLessHalfMinute()).thenReturn(true);
        mActivity.onResume();
        assertEquals(mButton.getVisibility(), Button.INVISIBLE);
    }

    @Test
    public void visibilityTest() {
        Mockito.when(mMockedTimer.isTimeLessHalfMinute()).thenReturn(false);
        mActivity.onResume();
        assertEquals(mButton.getVisibility(), Button.VISIBLE);
    }
}

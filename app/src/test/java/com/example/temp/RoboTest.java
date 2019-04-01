package com.example.temp;

import android.content.Intent;
import android.widget.Button;

import com.example.temp.presentation.collections.CollectionsActivity;
import com.example.temp.presentation.restaurants.RestaurantsActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadow.api.Shadow;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config()
public class RoboTest {

    private CollectionsActivity collectionsActivity;
    private CollectionsActivity collectionsActivity2;

    @Before
    public void setUp() {
        collectionsActivity = Robolectric.buildActivity(CollectionsActivity.class)
                .create().resume().get();
        collectionsActivity2 = Shadow.newInstanceOf(CollectionsActivity.class);
    }

    @Test
    public void collectionsActivityIsNotNull() {
        assertNotNull(collectionsActivity);
    }

    @Test
    public void shadowCollectionsActivityIsNotNull() {
        assertNotNull(collectionsActivity2);
    }

    @Test
    public void buttonIsNotNull() {
        Button button = collectionsActivity.findViewById(R.id.testButton);
        assertNotNull(button);
    }

    @Test
    public void nextActivityIsRestaurants(){
        Button button = collectionsActivity.findViewById(R.id.testButton);
        button.performClick();

        Intent expected = new Intent(collectionsActivity, RestaurantsActivity.class);
        ShadowActivity shadowActivity = Shadows.shadowOf(collectionsActivity);
        Intent actual = shadowActivity.peekNextStartedActivity();

        assertTrue(expected.filterEquals(actual));
    }
}

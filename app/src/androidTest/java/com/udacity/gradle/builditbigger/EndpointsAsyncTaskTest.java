package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

@SuppressWarnings("unchecked")
public class EndpointsAsyncTaskTest extends AndroidTestCase {

    /**
     * Ensure you have the app engine running. If this test is run without the app engine the test will fail with a 'Connection refused' string
     */
    public void testEndpointAsyncTask_getLaughs_returnFromJokeLibrary() {
        try {
            // Setup
            EndpointsAsyncTask task = new EndpointsAsyncTask();

            // Run
            String joke = task.execute().get();

            // Verify
            assertThat(joke, notNullValue());
        } catch (Exception e) {
            fail("Async task failed");
        }
    }

}
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Vishnu Sosale
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.vishnu.ledger.application;

import android.app.Application;

import com.parse.Parse;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetui.TweetUi;
import com.vishnu.ledger.R;

import io.fabric.sdk.android.Fabric;

/**
 * Created by vishnu on 30/6/15.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(getApplicationContext(), getString(R.string.app_id), getString(R.string.client_key));
        TwitterAuthConfig authConfig =
                new TwitterAuthConfig(getResources().getString(R.string.consumerKey),
                        getResources().getString(R.string.consumerSecret));
        Fabric.with(this, new TwitterCore(authConfig), new TweetUi());

    }
}

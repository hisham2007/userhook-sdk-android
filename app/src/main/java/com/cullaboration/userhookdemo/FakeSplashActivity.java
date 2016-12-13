/**
 * Copyright (c) 2015 - present, Cullaboration Media, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.cullaboration.userhookdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class FakeSplashActivity extends AppCompatActivity {




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }


    /*
  If your activity uses launchMode="singleTop", you will need to override the onNewIntent
  with the code below to properly track push notifications opens
   */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);

        // check for deep link

        if (intent.getAction().equals(Intent.ACTION_VIEW)) {
            Uri uri = intent.getData();

            // respond to deep link for url, userhookdemo://product
            if (uri.getHost().equals("product")) {
                Intent newIntent = new Intent(FakeSplashActivity.this, PurchaseActivity.class);
                startActivity(newIntent);
            }

        }
    }

}

package edu.orangecoastcollege.cs273.petprotector;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class PetListActivity extends AppCompatActivity {

    private ImageView petImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        petImageView = (ImageView) findViewById(R.id.petImageView);
        petImageView.setImageURI(getUriFromResource(this, R.drawable.none));
    }

    public static Uri getUriFromResource(Context context, int resId)
    {
        Resources res = context.getResources();
        //Build a string in the form:
        //android.resource://edu.orangecoastcollege.cs273.petprotector/drawable/none

        //built in constant ContentResolver.SCHEME_ANDROID_RESOURCE means android.resource
        String uri = ContentResolver.SCHEME_ANDROID_RESOURCE  + "://"
                + res.getResourcePackageName(resId) + "/"
                + res.getResourceTypeName(resId) + "/"
                + res.getResourceEntryName(resId);
        return Uri.parse(uri);
    }
}

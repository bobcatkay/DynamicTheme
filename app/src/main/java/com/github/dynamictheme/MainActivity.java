package com.github.dynamictheme;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private static int sMessage;
    private static int sTheme;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_blue:
                    sMessage = R.string.title_blue;
                    sTheme = R.style.AppThemeLightBlue;
                    recreate();
                    return true;
                case R.id.navigation_deep_blue:
                    sMessage = R.string.title_deep_blue;
                    sTheme = R.style.AppThemeDeepBlue;
                    recreate();
                    return true;
                case R.id.navigation_green:
                    sMessage = R.string.title_green;
                    sTheme = R.style.AppThemeGreen;
                    recreate();
                    return true;
                case R.id.navigation_pink:
                    sMessage = R.string.title_pink;
                    sTheme = R.style.AppThemePink;
                    recreate();
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (sTheme!=0) {
            setTheme(sTheme);
        }
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        if (sMessage!=0)
            mTextMessage.setText(sMessage);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}

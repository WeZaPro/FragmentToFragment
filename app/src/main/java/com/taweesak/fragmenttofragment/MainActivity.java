package com.taweesak.fragmenttofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    AFragment aFragment;
    BFragment bFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*getSupportFragmentManager().beginTransaction()
                .add(R.id.container_a, new AFragment())
                .add(R.id.container_b, new BFragment())
                .commit();*/

        callAFragment();
    }

    private void callAFragment() {
        aFragment = new AFragment();
        bFragment = new BFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container_a,aFragment)
                .add(R.id.container_b,bFragment).commit();
        Toast.makeText(this,"Main",Toast.LENGTH_SHORT).show();

    }
}

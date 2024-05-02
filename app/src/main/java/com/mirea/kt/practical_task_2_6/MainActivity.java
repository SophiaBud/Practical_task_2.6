package com.mirea.kt.practical_task_2_6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button btnStart = findViewById(R.id.btnStartActivity);
        tvTextValue = findViewById(R.id.tvText);
        btnStart.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnStartActivity) {
            Intent intent = new Intent(this, CalcActivity.class);
            activityResultLaunch.launch(intent);
        }
    }

    ActivityResultLauncher<Intent> activityResultLaunch = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getData() != null){
                        double res = result.getData().getDoubleExtra("data", 0);
                        Log.d("simple_app_tag", "Result: " + res);
                        tvTextValue.setText("Произведение чисел = " + res);
                    }
                }
            }
    );

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 12345){
//            if(data != null){
//                int res = data.getIntExtra("data", 0);
//                Log.d("simple_app_tag", "Result: " + res);
//                tvTextValue.setText("Произведение чисел: " + res);
//            }
//        }
//    }
}
package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // intent from parent
        Intent intentFromParent = getIntent();
        Bundle data = intentFromParent.getExtras();
        // process information from data ...

        String all_terms = data.get("all_terms").toString();

        String[] t = all_terms.split("\\+");

        int sum = 0;
        for (String x : t) {
            x = x.trim();
            if(x.isEmpty())
                continue;

            sum += Integer.parseInt(x);
        }

        // intent to parent
        Intent intentToParent = new Intent();
        intentToParent.putExtra("all_terms", String.valueOf(sum));
        setResult(RESULT_OK, intentToParent);
        finish();
    }


}

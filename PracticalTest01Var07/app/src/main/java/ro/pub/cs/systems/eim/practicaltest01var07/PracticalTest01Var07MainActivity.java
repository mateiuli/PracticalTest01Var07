package ro.pub.cs.systems.eim.practicaltest01var07;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var07MainActivity extends AppCompatActivity  implements View.OnClickListener  {

    final private static int ANOTHER_ACTIVITY_REQUEST_CODE = 2017;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        findViewById(R.id.add_btn).setOnClickListener(this);
        findViewById(R.id.compute_btn).setOnClickListener(this);


    }

    private void onadd(Button btn) {
        EditText allTerms = (EditText) findViewById(R.id.all_terms);
        EditText next = (EditText) findViewById(R.id.next_term_text);
        if(next.getText().toString().isEmpty())
            return;


        allTerms.append("+" + next.getText().toString());
        next.setText("");
    }

    private void oncomp(Button btn) {
        EditText allTerms = (EditText) findViewById(R.id.all_terms);
        Intent intent = new Intent("ro.pub.cs.systems.eim.practicaltest01var07.intent.action.SECONDARY");
        intent.putExtra("all_terms", allTerms.getText().toString());
        startActivityForResult(intent, ANOTHER_ACTIVITY_REQUEST_CODE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch(requestCode) {
            case ANOTHER_ACTIVITY_REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    Bundle data = intent.getExtras();
                    // process information from data ...
                    Log.d("RESULT", "Got all_terms value = " + data.get("all_terms").toString());
                }
                break;

            // process other request codes
        }
    }



    public void onClick(View view) {
        if(view instanceof Button) {
            Button btn = (Button) view;

            switch(btn.getId()) {
                case R.id.add_btn:
                    onadd(btn);
                    break;

                case R.id.compute_btn:
                    oncomp(btn);
                    break;

            }
        }
    }
}

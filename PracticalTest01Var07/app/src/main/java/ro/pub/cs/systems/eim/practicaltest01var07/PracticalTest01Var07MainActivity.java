package ro.pub.cs.systems.eim.practicaltest01var07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var07MainActivity extends AppCompatActivity  implements View.OnClickListener  {

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

        next.setText("");
        allTerms.append("+" + next.getText().toString());
    }



    public void onClick(View view) {
        if(view instanceof Button) {
            Button btn = (Button) view;

            switch(btn.getId()) {
                case R.id.add_btn:
                    onadd(btn);
                    break;

                case R.id.compute_btn:

                    break;

            }
        }
    }
}

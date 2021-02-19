package in.bitcode.fragment4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtQuestion;
    private Button mBtnStartQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mTxtQuestion = findViewById(R.id.txtQuestion);
        mBtnStartQuestion = findViewById(R.id.btnStartQuestion);

        mBtnStartQuestion.setOnClickListener(new BtnStartQuestionClickListener());
    }

    private class BtnStartQuestionClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            FragmentQuestion fragmentQuestion = new FragmentQuestion();

            Bundle bundle = new Bundle();
            bundle.putString("question", mTxtQuestion.getText().toString());

            fragmentQuestion.setOnQuestionResultListener(new FragmentQuestionListener());

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.mainContainer, fragmentQuestion, null)
                    .addToBackStack(null)
                    .commit();
        }
    }

    private class FragmentQuestionListener implements FragmentQuestion.OnQuestionResultListener {
        @Override
        public void onResult(FragmentQuestion fragmentQuestion, boolean res) {
            Toast.makeText(MainActivity.this, res +"", Toast.LENGTH_LONG).show();
            if(res == true) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .remove(fragmentQuestion)
                        .commit();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //some action
        return false;
    }
}
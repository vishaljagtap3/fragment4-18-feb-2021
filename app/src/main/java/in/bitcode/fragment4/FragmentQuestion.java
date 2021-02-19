package in.bitcode.fragment4;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentQuestion extends Fragment {

    private TextView mTxtQuestion;
    private Button mBtnYes, mBtnNo;

    public interface OnQuestionResultListener {
        public void onResult(FragmentQuestion fragmentQuestion, boolean res);
    }

    private OnQuestionResultListener mOnQuestionResultListener;

    public void setOnQuestionResultListener(OnQuestionResultListener onQuestionResultListener) {
        this.mOnQuestionResultListener = onQuestionResultListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, null);

        setHasOptionsMenu(true);

        mTxtQuestion = view.findViewById(R.id.txtQuestion);
        mBtnYes = view.findViewById(R.id.btnYes);
        mBtnNo = view.findViewById(R.id.btnNo);

        mBtnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnQuestionResultListener != null) {
                    mOnQuestionResultListener.onResult(FragmentQuestion.this, true);

                    /*
                    getFragmentManager().beginTransaction()
                            .remove(FragmentQuestion.this)
                            .commit();

                     */
                }
            }
        });

        mBtnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnQuestionResultListener != null) {
                    mOnQuestionResultListener.onResult(FragmentQuestion.this, false);

                    /*
                    getFragmentManager().beginTransaction()
                            .remove(FragmentQuestion.this)
                            .commit();
                            */

                }
            }
        });

        return view;
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}

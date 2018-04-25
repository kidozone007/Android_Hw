package tw.edu.ntut.csie.app01_105590014;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private  Button mBtnOK;
    private  EditText medtSex;
    private  TextView mtxtR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnOK=(Button)findViewById(R.id.btnOK);
        medtSex=(EditText)findViewById(R.id.edtSex);
        mtxtR=(TextView)findViewById(R.id.txtR);
        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private char getGrade(int score){
        if (score>100)
            return 'X';
        else if (score>=90)
            return 'A';
        else if (score>=80)
            return 'B';
        else if (score>=70)
            return 'C';
        else if (score>=60)
            return 'D';
        else if (score>=0)
            return 'F';
        else
            return 'X';
    }

    private View.OnClickListener btnOKOnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            int iAge=Integer.parseInt(medtSex.getText().toString());
            char theClass=getGrade(iAge);

            String strSug=getString(R.string.suggestion);
            if (theClass=='X')
                strSug+=getString(R.string.the_error);
            else
                strSug+=theClass;

            mtxtR.setText(strSug);
        }
    };
}
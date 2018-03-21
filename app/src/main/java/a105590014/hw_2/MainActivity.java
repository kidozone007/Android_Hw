package a105590014.hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private  Button mBtnOK;
    private  EditText medtSex,medtAge;
    private  TextView mtxtR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnOK=(Button)findViewById(R.id.btnOK);
        medtSex=(EditText)findViewById(R.id.edtSex);
        medtAge=(EditText)findViewById(R.id.edtAge);
        mtxtR=(TextView)findViewById(R.id.txtR);

        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private View.OnClickListener btnOKOnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String strSex=medtSex.getText().toString();
            int iAge=Integer.parseInt(medtAge.getText().toString());

            String strSug=getString(R.string.suggestion);
            if (strSex.equals(getString(R.string.sex_male)))
                if (iAge<28)
                    strSug+=getString(R.string.sug_not_hurry);
                else if (iAge>33)
                    strSug+=getString(R.string.sug_get_married);
                else
                    strSug+=getString(R.string.sug_find_couple);
            else
            if (iAge<25)
                strSug+=getString(R.string.sug_not_hurry);
            else if (iAge>30)
                strSug+=getString(R.string.sug_get_married);
            else
                strSug+=getString(R.string.sug_find_couple);

            mtxtR.setText(strSug);
        }
    };
}
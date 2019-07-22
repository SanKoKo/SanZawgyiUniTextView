package san.zgyi.uni;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MessageView extends Activity{

int tintin=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        RadioGroup rbg = new RadioGroup(this);

        RadioButton rb1 = new RadioButton(this);
        rb1.setTag(1);
        rb1.setText("Zawgyi");
        RadioButton rb2 = new RadioButton(this);
        rb2.setText("Unicode");
        rb2.setTag(2);
        RadioButton rb3 = new RadioButton(this);
        rb3.setText("I cann't read. Use magic!");
        rb3.setTag(3);
        rbg.addView(rb1);
        rbg.addView(rb2);
        rbg.addView(rb3);
        rb1.setOnClickListener(checked);
        rb2.setOnClickListener(checked);
        rb3.setOnClickListener(checked);
        Button btn =new Button(this);
        btn.setText("Ok");

        linearLayout.addView(rbg);
        linearLayout.addView(btn);
        final SharedPreferences share = getSharedPreferences("SanFontStyleLib",MODE_PRIVATE);
        if(share.contains("sfont"))
        {
            tintin = share.getInt("sfont",1);
            checkTinTin(rb1,rb2,rb3);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = share.edit();
                editor.putInt("sfont",tintin);
                editor.apply();
                Intent mIntent = new Intent();
                setResult(RESULT_OK,mIntent);
                finish();
            }
        });
        
        this.setFinishOnTouchOutside(false);
        setContentView(linearLayout);


    }

    private void checkTinTin(RadioButton rb1, RadioButton rb2, RadioButton rb3) {
        switch (tintin)
        {
            case 1:
                rb1.setChecked(true);
                break;
            case 2:
                rb2.setChecked(true);
                break;
            case 3:
                rb3.setChecked(true);
                break;
        }
    }

    View.OnClickListener checked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
       tintin = (int) view.getTag();
        }
    };

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}

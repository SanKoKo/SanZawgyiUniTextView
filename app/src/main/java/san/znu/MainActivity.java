package san.znu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvZg = findViewById(R.id.tvZg);
        TextView tvUni = findViewById(R.id.tvUni);

        tvZg.setText("ကၽြန္ေတာ္ကေတာ့ ေဇာ္ဂ်ီပါခင္ဗ်ာ");
        tvUni.setText("ကျွန်တော်ကတော့ ယူနီပဲဖြစ်ပါတယ်ခင်ဗျာ။");


    }
}

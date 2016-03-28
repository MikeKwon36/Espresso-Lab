package kwondeveloper.com.mikekwonespressolab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NameAddressActivity extends AppCompatActivity {

    TextView mName,mAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_address);

        mName = (TextView)findViewById(R.id.name);
        mAddress = (TextView)findViewById(R.id.address);
    }
}

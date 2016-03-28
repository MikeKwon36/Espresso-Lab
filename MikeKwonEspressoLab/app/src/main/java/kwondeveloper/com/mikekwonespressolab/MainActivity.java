package kwondeveloper.com.mikekwonespressolab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView mCurrentBalance;
    int mCurrentBalanceValue;
    EditText mEnterValue;
    Button mDepositButton, mWithdrawButton, mCheckNameAddress;
    ListView mListView;
    ArrayList<String> mListOfTransactions;
    ArrayAdapter<String> mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCurrentBalance = (TextView)findViewById(R.id.currentBalanceTextView);
        mEnterValue = (EditText)findViewById(R.id.transactionValueEditText);
        mDepositButton = (Button)findViewById(R.id.addValueButton);
        mWithdrawButton = (Button)findViewById(R.id.reduceValueButton);
        mCheckNameAddress = (Button) findViewById(R.id.checkNameAddressButton);
        mListView = (ListView)findViewById(R.id.transactionsListView);

        mCurrentBalanceValue = 0;
        mListOfTransactions = new ArrayList<>();
        mListOfTransactions.add("-1");
        mArrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,mListOfTransactions);
        mListView.setAdapter(mArrayAdapter);

        mDepositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deposit = mEnterValue.getText().toString();
                mCurrentBalanceValue += mCurrentBalanceValue + Integer.parseInt(deposit);
                mCurrentBalance.setText(String.valueOf(mCurrentBalanceValue));
                mEnterValue.setText("");
                mListOfTransactions.add("+" + deposit);
                mArrayAdapter.notifyDataSetChanged();
            }
        });

        mWithdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String withdrawal = mEnterValue.getText().toString();
                mCurrentBalanceValue -= mCurrentBalanceValue + Integer.parseInt(withdrawal);
                mCurrentBalance.setText(String.valueOf(mCurrentBalanceValue));
                mEnterValue.setText("");
                mListOfTransactions.add("-" + withdrawal);
                mArrayAdapter.notifyDataSetChanged();
            }
        });

        mCheckNameAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NameAddressActivity.class);
                startActivity(intent);
            }
        });
    }
}

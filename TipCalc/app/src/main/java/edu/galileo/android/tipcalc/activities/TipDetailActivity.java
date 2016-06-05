package edu.galileo.android.tipcalc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.galileo.android.tipcalc.R;

public class TipDetailActivity extends AppCompatActivity {

    @BindView(R.id.txtBillTotal)
    TextView txtBillTotal;
    @BindView(R.id.txtTip)
    TextView txtTip;
    @BindView(R.id.txtTimeStamp)
    TextView txtTimeStamp;

    public final static String TIP_KEY = "tip";
    public final static String DATE__KEY = "timestamp";
    public final static String BILL_TOTAL_KEY = "total";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*onCreate -> ciclo de vida de la actividad */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        txtTimeStamp.setText(intent.getStringExtra(DATE__KEY));
        String strTotal = String.format(getString(R.string.tipdetail_message_bill),
                            intent.getDoubleExtra(BILL_TOTAL_KEY,0d));
        String strTip = String.format(getString(R.string.global_message_tip),
                intent.getDoubleExtra(TIP_KEY,0d));

        txtBillTotal.setText(strTotal);
        txtTip.setText(strTip);
        txtTimeStamp.setText(intent.getStringExtra(DATE__KEY));




    }
}

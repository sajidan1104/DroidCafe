package lat.pam.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] kota = { "Bandung", "Jakarta",
            "Surabaya", "Bogor",
            "Tanggerang", "Bekasi" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Spinner spino = findViewById(R.id.Kotaspinner);
        spino.setOnItemSelectedListener(this);

        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                kota);

        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        spino.setAdapter(ad);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                // Do nothing.
                break;
        }
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView,
                               View arg1,
                               int position,
                               long id) {

        Toast.makeText(getApplicationContext(),
                        kota[position],
                        Toast.LENGTH_LONG)
                .show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
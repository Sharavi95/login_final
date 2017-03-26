package info.androidhive.loginandregistration.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import info.androidhive.loginandregistration.R;

public class BookTennisActivity extends AppCompatActivity implements View.OnClickListener {

    //UI References
    private EditText sessionDate;
    private Button submitLevel;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private RadioGroup playerLevel;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_tennis);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        findViewsById();
        setDateTimeField();
        setPlayerLevel();

    }

    private void findViewsById() {
        sessionDate = (EditText) findViewById(R.id.selectDate);
        sessionDate.setInputType(InputType.TYPE_NULL);
        submitLevel = (Button) findViewById(R.id.submitLevel);
        playerLevel = (RadioGroup) findViewById(R.id.playerLevel);
    }

    private void setDateTimeField() {
        sessionDate.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                sessionDate.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void setPlayerLevel() {

        playerLevel = (RadioGroup) findViewById(R.id.playerLevel);
        submitLevel = (Button) findViewById(R.id.submitLevel);

        submitLevel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = playerLevel.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);
                Toast.makeText(BookTennisActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public void onClick(View view) {
        if (view == sessionDate) {
            datePickerDialog.show();
        }
    }
}

/*public class BookTennisActivity extends AppCompatActivity implements View.OnClickListener {

    //UI References
    private EditText sessionDate;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_tennis);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        findViewsById();
        setDateTimeField();
        submitLevel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Is the button now checked?
                boolean checked = ((RadioButton) view).isChecked();
                // Check which radio button was clicked
                switch (view.getId()) {
                    case R.id.Beginner:
                        if (checked) {
                            level = "Beginner";
                            break;
                        }
                    case R.id.Intermediate:
                        if (checked) {
                            level = "Intermediate";
                            break;
                        }
                    case R.id.Advanced:
                        if (checked) {
                            level = "Advanced";
                            break;
                        }
                }
            }
        });
    }

    private void findViewsById() {
        sessionDate = (EditText) findViewById(R.id.selectDate);
        sessionDate.setInputType(InputType.TYPE_NULL);
    }

    private void setDateTimeField() {
        sessionDate.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                sessionDate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onClick(View view) {
        if(view == sessionDate) {
            datePickerDialog.show();
        }
    }


}
*/


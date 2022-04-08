package ac.id.pnj.latihanandroid.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import ac.id.pnj.latihanandroid.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTanggal,btnJam,btnSignIn;
    TextView txtTanggal,txtJam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnTanggal = findViewById(R.id.btnTanggal);
        btnSignIn = findViewById(R.id.btnSignIn);
        txtTanggal = findViewById(R.id.txtTanggal);
        txtJam = findViewById(R.id.txtJam);
        btnJam = findViewById(R.id.btnJam);
        btnTanggal.setOnClickListener(this);
        btnJam.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Calendar calendar = Calendar.getInstance();
        switch (view.getId()){
            case R.id.btnTanggal:
                new DatePickerDialog(this, onDateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.btnJam:
                new TimePickerDialog(this,onTimeSetListener,
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),true).show();
                break;
            case R.id.btnSignIn:
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
        }
    }

    DatePickerDialog.OnDateSetListener onDateSetListener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR,i);
            calendar.set(Calendar.MONTH,i1);
            calendar.set(Calendar.DAY_OF_MONTH,i2);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
            txtTanggal.setText(simpleDateFormat.format(calendar.getTime()));
        }
    };

    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,i);
            calendar.set(Calendar.MINUTE,i1);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            txtJam.setText(simpleDateFormat.format(calendar.getTime()));
        }
    };

}
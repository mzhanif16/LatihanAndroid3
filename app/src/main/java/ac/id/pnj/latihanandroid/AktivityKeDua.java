package ac.id.pnj.latihanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AktivityKeDua extends AppCompatActivity {
    TextView txtNama,txtUmur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktivity_ke_dua);
        txtNama = findViewById(R.id.txtNama);
        txtUmur = findViewById(R.id.txtUmur);

        Bundle extras = getIntent().getExtras();

        if(extras!=null){
            txtNama.setText("Nama : "+ extras.getString("name", "-"));
            txtUmur.setText("Umur :"+extras.getInt("umur",0));
        }
    }
}
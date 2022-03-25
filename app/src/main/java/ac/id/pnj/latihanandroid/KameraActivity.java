package ac.id.pnj.latihanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KameraActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnFinish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera);
        btnFinish = findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnFinish:
                Intent intent = new Intent();
                intent.putExtra("type",1);
                intent.putExtra("data", "Kamera");
                setResult(RESULT_OK, intent);
                finish();
                break;
        }

    }
}
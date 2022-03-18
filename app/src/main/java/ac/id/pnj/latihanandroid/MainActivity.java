package ac.id.pnj.latihanandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnPindah,btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindah = findViewById(R.id.btnPindah);
        btnDialog = findViewById(R.id.btnDialog);
        Log.e("Proses : ", "onCreate");

        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AktivityKeDua.class);
                startActivity(intent);
            }
        });

        btnDialog.setOnClickListener(view -> {
            tampilDialog();
        });
    }

    void tampilDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Contoh Dialog");
        alert.setMessage("Halo Apa Kabar?");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Contoh Toast", Toast.LENGTH_SHORT).show();

                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Loading..");
                progressDialog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                    }
                }, 3000);



            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alert.show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Proses : ", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Proses : ", "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Proses : ", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Proses : ", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Proses : ", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Proses : ", "onRestart");
    }
}
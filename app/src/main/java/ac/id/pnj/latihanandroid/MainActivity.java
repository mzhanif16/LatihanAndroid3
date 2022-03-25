package ac.id.pnj.latihanandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnPindah,btnDialog,btnBrowser;
    EditText edtName,edtUmur;

    static final int REQUEST_CAMERA = 100;
    static final int REQUEST_GALERI = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindah = findViewById(R.id.btnPindah);
        btnDialog = findViewById(R.id.btnDialog);
        edtName = findViewById(R.id.edtNama);
        edtUmur = findViewById(R.id.extUmur);
        btnBrowser = findViewById(R.id.btnBrowser);


        Log.e("Proses : ", "onCreate");

        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AktivityKeDua.class);
                intent.putExtra("name", edtName.getText().toString());
                intent.putExtra("umur", Integer.parseInt(edtUmur.getText().toString()));
                startActivity(intent);
            }
        });

        btnDialog.setOnClickListener(view -> {
//            tampilDialog();
            pickImage();
        });

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://google.com"));
                startActivity(intent);
            }
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

    void pickImage(){
        AlertDialog.Builder pilihGambar = new AlertDialog.Builder(this);
        pilihGambar.setItems(new String[]{"Kamera","Galeri"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0){
                    Intent intent = new Intent(MainActivity.this, KameraActivity.class);
                    startActivityForResult(intent,REQUEST_CAMERA);
                }else {
                    Intent intent = new Intent(MainActivity.this, GaleriActivity.class);
                    startActivityForResult(intent,REQUEST_GALERI);
                }
            }
        });

        pilihGambar.show();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle datas =data.getExtras();
            if(requestCode==REQUEST_CAMERA){
                Toast.makeText(this,"Tipe : " +datas.getInt("type",
                        0)+ " Value "+ datas.getString("data"),
                        Toast.LENGTH_SHORT ).show();
            }else {
                Toast.makeText(this,"Tipe : " +datas.getInt("type",
                        0)+ " Value "+ datas.getString("data"),
                        Toast.LENGTH_SHORT ).show();
            }


        }
    }
}
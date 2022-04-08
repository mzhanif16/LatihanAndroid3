package ac.id.pnj.latihanandroid.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import ac.id.pnj.latihanandroid.R;
import ac.id.pnj.latihanandroid.adapter.AdapterProduk;

public class HomeActivity extends AppCompatActivity {

    ListView listView;
    AdapterProduk adapterProduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listView = findViewById(R.id.listview);
        adapterProduk = new AdapterProduk(this, R.layout.layout_item_list_barang);
    }
}
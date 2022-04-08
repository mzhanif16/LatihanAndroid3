package ac.id.pnj.latihanandroid.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import ac.id.pnj.latihanandroid.R;
import ac.id.pnj.latihanandroid.adapter.AdapterProduk;
import ac.id.pnj.latihanandroid.model.ProdukModel;

public class HomeActivity extends AppCompatActivity {
    //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
    ListView listView;
    AdapterProduk adapterProduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listView = findViewById(R.id.listview);
        adapterProduk = new AdapterProduk(this, R.layout.layout_item_list_barang);
        listView.setAdapter(adapterProduk);
        generateData();
    }
    void generateData(){

        ArrayList<ProdukModel> datas = new ArrayList<>();

        ProdukModel p1 = new ProdukModel();
        p1.setHarga("$250");
        p1.setImage("https://s.kaskus.id/images/2022/01/22/11076539_202201220606470145.jpg");
        p1.setName("Sendal Swallaw");
        p1.setRating(3);

        ProdukModel p2 = new ProdukModel();
        p2.setHarga("$1050");
        p2.setImage("https://awsimages.detik.net.id/content/2013/08/14/775/flipflop.jpg");
        p2.setName("Sendal Bekas Mewah");
        p2.setRating(5);

        ProdukModel p3 = new ProdukModel();
        p3.setHarga("$550");
        p3.setImage("https://www.harapanrakyat.com/wp-content/uploads/2021/03/11.-Sandal-Jepit-Ukir-Hadir-dengan-Berbagai-Rekomendasi-Menarik.jpg");
        p3.setName("Sendal Modifikasi");
        p3.setRating(4);

        datas.add(p1);
        datas.add(p2);
        datas.add(p3);

        adapterProduk.addAll(datas);
        adapterProduk.notifyDataSetChanged();
    }
}
package ac.id.pnj.latihanandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import ac.id.pnj.latihanandroid.R;
import ac.id.pnj.latihanandroid.model.ProdukModel;

public class AdapterProduk extends ArrayAdapter<ProdukModel> {
    Context context;
    int resource;


    public AdapterProduk(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder;

        ProdukModel data = getItem(position);

        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(resource,parent,false);
            holder = new Holder();
            holder.imageProduk = convertView.findViewById(R.id.imgProduk);
            holder.txtHarga = convertView.findViewById(R.id.txtHarga);
            holder.txtNama = convertView.findViewById(R.id.txtNama);
            holder.ratingBar = convertView.findViewById(R.id.rating);
            convertView.setTag(holder);
        }else {
            holder = (Holder)convertView.getTag();
        }

        Picasso.get().load(data.getImage()).into(holder.imageProduk);
        holder.txtHarga.setText(data.getHarga());
        holder.txtNama.setText(data.getName());
        holder.ratingBar.setRating(data.getRating());

        return convertView;

    }

    class Holder{
        ImageView imageProduk;
        TextView txtHarga,txtNama;
        RatingBar ratingBar;
    }
}

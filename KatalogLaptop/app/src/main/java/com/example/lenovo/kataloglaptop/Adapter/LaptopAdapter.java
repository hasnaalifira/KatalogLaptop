package com.example.lenovo.kataloglaptop.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.kataloglaptop.LayarEditLaptop;
import com.example.lenovo.kataloglaptop.Model.Laptop;
import com.example.lenovo.kataloglaptop.R;
import com.example.lenovo.kataloglaptop.Rest.ApiClient;

import java.util.List;

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.LaptopViewHolder>{
    List<Laptop> listLaptop;

    public LaptopAdapter(List<Laptop> listLaptop) {
        this.listLaptop = listLaptop;
    }

    @Override
    public LaptopAdapter.LaptopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_laptop, parent, false);
        LaptopViewHolder mHolder = new LaptopViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(LaptopAdapter.LaptopViewHolder holder, final int position) {

//        holder.mPhotoURL.setImageResource(listLaptop.get(position).getPhotoUrl());
        holder.tvIdLaptop.setText(listLaptop.get(position).getIdLaptop());
        holder.tvMerk.setText(listLaptop.get(position).getMerk());
        holder.tvTipe.setText(listLaptop.get(position).getTipe());
        holder.tvRam.setText (String.valueOf(listLaptop.get(position).getRam()));
        holder.tvProcessor.setText(listLaptop.get(position).getProcessor());
        holder.tvWarna.setText(listLaptop.get(position).getWarna());
        holder.tvHarga.setText (String.valueOf(listLaptop.get(position).getHarga()));
        if (listLaptop.get(position).getPhotoUrl() != null ){
//            Picasso.with(holder.itemView.getContext()).load(ApiClient.BASE_URL+listLaptop.get(position).getPhotoUrl())
//                    .into(holder.mPhotoURL);
            Glide.with(holder.itemView.getContext()).load(ApiClient.BASE_URL +
                    listLaptop.get(position).getPhotoUrl()).into(holder.mPhotoURL);

//            Glide.with(holder.itemView.getContext()).load(listLaptop.get
//                    (position).getPhotoUrl())
//                    .into(holder.mPhotoURL);
        } else {
//          Picasso.with(holder.itemView.getContext()).load(R.drawable.biru).into(holder
// .mPhotoURL);
            Glide.with(holder.itemView.getContext()).load(R.drawable.laptop).into(holder
                    .mPhotoURL);


        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LayarEditLaptop.class);
                intent.putExtra("id_laptop", listLaptop.get(position).getIdLaptop());
                intent.putExtra("merk", listLaptop.get(position).getMerk());
                intent.putExtra("tipe", listLaptop.get(position).getTipe());
                intent.putExtra("ram", listLaptop.get(position).getRam());
                intent.putExtra("processor", listLaptop.get(position).getProcessor());
                intent.putExtra("warna", listLaptop.get(position).getWarna());
                intent.putExtra("harga", listLaptop.get(position).getHarga());
                intent.putExtra("photo_url", listLaptop.get(position).getPhotoUrl());
                view.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listLaptop.size();
    }

    public class LaptopViewHolder extends RecyclerView.ViewHolder {
        ImageView mPhotoURL;
        TextView tvIdLaptop, tvMerk, tvTipe, tvRam, tvProcessor, tvWarna, tvHarga;

        public LaptopViewHolder(View itemView) {
            super(itemView);
            mPhotoURL = (ImageView) itemView.findViewById(R.id.imgLaptop);
            tvIdLaptop = (TextView) itemView.findViewById(R.id.tvIdLaptop);
            tvMerk = (TextView) itemView.findViewById(R.id.tvMerk);
            tvTipe = (TextView) itemView.findViewById(R.id.tvTipeContent);
            tvRam = (TextView) itemView.findViewById(R.id.tvRamContent);
            tvProcessor = (TextView) itemView.findViewById(R.id.tvProcessorContent);
            tvWarna = (TextView) itemView.findViewById(R.id.tvWarnaContent);
            tvHarga = (TextView) itemView.findViewById(R.id.tvHargaContent);
        }
    }

}

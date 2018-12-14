package com.example.nurul.userlaptop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nurul.userlaptop.Rest.ApiInterface;

import java.util.List;

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.LaptopViewHolder> {

    List<Laptop> listLaptop;
    Context mContext;
    ApiInterface mApiInterface;

    public LaptopAdapter(List<Laptop> listTiket, Context mContext) {
        this.listLaptop = listLaptop;
        this.mContext = mContext;

    }

    //    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        final Laptop laptop = listLaptop.get(position);
//        if (convertView == null) {
//            final LayoutInflater layoutInflater = LayoutInflater.from(mContex);
//            convertView = layoutInflater.inflate(R.layout.laptop_layout, null);
//        }
//        final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
//        final ImageView imageViewFavorite = (ImageView)convertView.findViewById(R.id.imageview_favorite);
//
//        Picasso.with(mContex)
//                .load(laptop.getPhotoUrl())
//                .placeholder(R.drawable.ic_placeholder)
//                .error(R.drawable.ic_error)
//                .resize(300, 500)
//                .into(imageView);
//
//        imageViewFavorite.setImageResource(
//                laptop.getIsFavorite() ? R.drawable.ic_favorite : R.drawable.ic_not_favorite);
//        return convertView;
//    }

    public LaptopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_laptop, parent, false);
        LaptopViewHolder mHolder = new LaptopViewHolder(view);
        return mHolder;
    }

    public void onBindViewHolder(LaptopViewHolder holder, int position) {

//        holder.mPhotoURL.setImageResource(listLaptop.get(position).getPhotoUrl());
        holder.tvIdLaptop.setText(listLaptop.get(position).getIdLaptop());
        holder.tvMerk.setText(listLaptop.get(position).getMerk());
        holder.tvTipe.setText(listLaptop.get(position).getTipe());
        holder.tvRam.setText (String.valueOf(listLaptop.get(position).getRam()));
        holder.tvProcessor.setText(listLaptop.get(position).getProcessor());
        holder.tvWarna.setText(listLaptop.get(position).getWarna());
        holder.tvHarga.setText (String.valueOf(listLaptop.get(position).getHarga()));
//        final ImageView imageView = (ImageView)itemView.findViewById(R.id.imageview_cover_art);
//        final ImageView imageViewFavorite = (ImageView)itemView.findViewById(R.id.imageview_favorite);
        if (listLaptop.get(position).getPhotoUrl() != null ){
//            Picasso.with(holder.itemView.getContext()).load(ApiClient.BASE_URL+listLaptop.get(position).getPhotoUrl())
//                    .into(holder.mPhotoURL);
            Glide.with(holder.itemView.getContext()).load(listLaptop.get
                    (position).getPhotoUrl())
                    .into(holder.mPhotoURL);
        } else {
//          Picasso.with(holder.itemView.getContext()).load(R.drawable.biru).into(holder
// .mPhotoURL);

            Glide.with(holder.itemView.getContext()).load(R.drawable.laptop).into(holder
                    .mPhotoURL);
//
//            imageViewFavorite.setImageResource(
//                    listLaptop.get(position).getIsFavorite()? R.drawable.ic_favorite : R.drawable.ic_not_favorite);
//            return;


        }

    }


    @Override
    public int getItemCount() {
        return listLaptop.size();
    }

    public class LaptopViewHolder extends RecyclerView.ViewHolder{
        ImageView mPhotoURL;
        TextView tvIdLaptop, tvMerk, tvTipe, tvRam, tvProcessor, tvWarna, tvHarga;

        public LaptopViewHolder(View itemView) {

            super(itemView);
//            Laptop  laptop = listLaptop.get(position);
//            if (itemView == null) {
//                final LayoutInflater layoutInflater = LayoutInflater.from(mContex);
//            }

            mPhotoURL = (ImageView) itemView.findViewById(R.id.imgLaptop);
            tvIdLaptop = (TextView) itemView.findViewById(R.id.tvIdLaptop);
            tvMerk = (TextView) itemView.findViewById(R.id.tvMerk);
            tvTipe = (TextView) itemView.findViewById(R.id.tvTipeContent);
            tvRam = (TextView) itemView.findViewById(R.id.tvRamContent);
            tvProcessor = (TextView) itemView.findViewById(R.id.tvProcessorContent);
            tvWarna = (TextView) itemView.findViewById(R.id.tvWarnaContent);
            tvHarga = (TextView) itemView.findViewById(R.id.tvHargaContent);
            final ImageView imageView = (ImageView)itemView.findViewById(R.id.imageview_cover_art);
            final ImageView imageViewFavorite = (ImageView)itemView.findViewById(R.id.imageview_favorite);

//            Picasso.with(mContex)
//                    .load(listLaptop.get(position).getPhotoUrl())
//                    .placeholder(R.drawable.ic_placeholder)
//                    .error(R.drawable.ic_error)
//                    .resize(300, 500)
//                    .into(imageView);
//
//            imageViewFavorite.setImageResource(
//                    Laptop.getIsFavorite() ? R.drawable.ic_favorite : R.drawable.ic_not_favorite);
//            return;

        }
    }

}

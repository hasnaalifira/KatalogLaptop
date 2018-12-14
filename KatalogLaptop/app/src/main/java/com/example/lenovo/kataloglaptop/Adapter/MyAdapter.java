package com.example.lenovo.kataloglaptop.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.kataloglaptop.LayarDetail;
import com.example.lenovo.kataloglaptop.Model.Suka;
import com.example.lenovo.kataloglaptop.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Suka> mSukaList;

    public MyAdapter(List<Suka> sukaList) { mSukaList = sukaList; }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextViewIdSuka.setText("Id Suka :  " + mSukaList.get(position)
                .getIdSuka());
        holder.mTextViewIdLaptop.setText("Id Laptop :  " + mSukaList.get(position)
                .getIdLaptop());
        holder.mTextViewIdUser.setText("Id User :  " + mSukaList.get(position).getIdUser
                ());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mintent = new Intent(v.getContext(), LayarDetail.class);
                mintent.putExtra("id_suka",mSukaList.get(position).getIdSuka());
                mintent.putExtra("id_laptop",mSukaList.get(position).getIdLaptop());
                mintent.putExtra("id_user",mSukaList.get(position).getIdUser());
                v.getContext().startActivity(mintent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mSukaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdSuka, mTextViewIdLaptop, mTextViewIdUser;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdSuka = (TextView) itemView.findViewById(R.id.tvIdSuka);
            mTextViewIdLaptop = (TextView) itemView.findViewById(R.id.tvIdLaptop);
            mTextViewIdUser = (TextView) itemView.findViewById(R.id.tvIdUser);

        }
    }

}

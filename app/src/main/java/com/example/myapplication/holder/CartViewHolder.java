package com.example.myapplication.holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class CartViewHolder extends RecyclerView.ViewHolder {

    public CheckBox cbProduct;
    public ImageView imgProduct;
    public TextView txtName;
    public TextView txtCategory;
    public TextView txtPrice;
    public TextView txtQuantity;
    public ImageButton btnMinus;
    public ImageButton btnPlus;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);

        cbProduct = itemView.findViewById(R.id.cbProduct);
        imgProduct = itemView.findViewById(R.id.imgProduct);
        txtName = itemView.findViewById(R.id.txtName);
        txtCategory = itemView.findViewById(R.id.txtCategory);
        txtPrice = itemView.findViewById(R.id.txtPrice);
        txtQuantity = itemView.findViewById(R.id.txtQuantity);
        btnMinus = itemView.findViewById(R.id.btnMinus);
        btnPlus = itemView.findViewById(R.id.btnPlus);
    }
}
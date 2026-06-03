package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.holder.CartViewHolder;
import com.example.myapplication.model.CartItem;

import java.util.List;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    private Context context;
    private List<CartItem> cartList;

    public CartAdapter(Context context, List<CartItem> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);

        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        CartItem item = cartList.get(position);

        holder.imgProduct.setImageResource(item.getImageResId());
        holder.txtName.setText(item.getName());
        holder.txtCategory.setText(item.getCategory());

        holder.txtPrice.setText(String.format(Locale.getDefault(), "%,.0fđ", item.getPrice()));

        holder.txtQuantity.setText(String.valueOf(item.getQuantity()));

        holder.cbProduct.setChecked(item.isSelected());

        holder.btnMinus.setOnClickListener(v -> {

            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                notifyItemChanged(position);
            }
        });

        holder.btnPlus.setOnClickListener(v -> {

            item.setQuantity(item.getQuantity() + 1);

            notifyItemChanged(position);
        });

        holder.cbProduct.setOnCheckedChangeListener(
                (buttonView, isChecked) ->
                        item.setSelected(isChecked)
        );
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }
}
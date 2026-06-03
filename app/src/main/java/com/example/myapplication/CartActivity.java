package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.CartAdapter;
import com.example.myapplication.VoucherBottomSheet;
import com.example.myapplication.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView rvCart;
    private CartAdapter adapter;
    private List<CartItem> cartList;
    private TextView txtVoucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rvCart = findViewById(R.id.rvCart);
        txtVoucher = findViewById(R.id.txtVoucher);

        loadData();

        adapter = new CartAdapter(this, cartList);

        rvCart.setLayoutManager(
                new LinearLayoutManager(this)
        );

        rvCart.setAdapter(adapter);

        txtVoucher.setOnClickListener(v -> {

            VoucherBottomSheet sheet = new VoucherBottomSheet();

            sheet.show(getSupportFragmentManager(), "voucher"
            );
        });
    }

    private void loadData() {

        cartList = new ArrayList<>();

        cartList.add(
                new CartItem(
                        R.drawable.mihaohao,
                        "Thùng 30 gói Mì Hảo Hảo",
                        "Phân loại: Tôm chua cay",
                        115000,
                        1,
                        true
                )
        );

        cartList.add(
                new CartItem(
                        R.drawable.snack,
                        "Snack khoai tây Poca",
                        "Phân loại: BBQ 68g",
                        12500,
                        2,
                        true
                )
        );

        cartList.add(
                new CartItem(
                        R.drawable.sua,
                        "Lốc 4 hộp sữa Vinamilk",
                        "Phân loại: Có đường",
                        34000,
                        1,
                        false
                )
        );
    }
}
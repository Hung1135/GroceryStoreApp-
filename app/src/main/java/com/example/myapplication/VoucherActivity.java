package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.VoucherAdapter;
import com.example.myapplication.model.Voucher;

import java.util.ArrayList;
import java.util.List;

public class VoucherActivity extends AppCompatActivity {
    private RecyclerView rvVoucher;
    private VoucherAdapter adapter;
    private List<Voucher> voucherList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        rvVoucher.findViewById(R.id.rvVoucher);
        voucherList = new ArrayList<>();
        voucherList.add(new Voucher("Giảm 20k", "Đơn từ 100k" ,2000));
        voucherList.add(new Voucher("Giảm 50k", "Đơn từ 300k" ,50000));
        adapter = new VoucherAdapter(this,voucherList);
        rvVoucher.setLayoutManager(new LinearLayoutManager(this));
        rvVoucher.setAdapter(adapter);
    }
}

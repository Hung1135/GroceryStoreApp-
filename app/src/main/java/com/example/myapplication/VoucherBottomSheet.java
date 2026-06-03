package com.example.myapplication;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.VoucherAdapter;
import com.example.myapplication.model.Voucher;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class VoucherBottomSheet extends BottomSheetDialogFragment {

    private RecyclerView rvVoucher;
    private VoucherAdapter adapter;
    private List<Voucher> voucherList;

    private ImageView imgClose;
    private MaterialButton btnConfirm;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bottomsheet_voucher, container, false);
        initView(view);
        loadData();
        setupRecyclerView();
        setupEvents();
        return view;
    }

    private void initView(View view) {
        rvVoucher = view.findViewById(R.id.rvVoucher);
        imgClose = view.findViewById(R.id.imgClose);
        btnConfirm = view.findViewById(R.id.btnConfirm);
    }

    private void loadData() {
        voucherList = new ArrayList<>();

        voucherList.add(new Voucher("Giảm 20.000đ", "Đơn từ 100.000đ", 20000));

        voucherList.add(new Voucher("Giảm 50.000đ", "Đơn từ 300.000đ", 50000));

        voucherList.add(new Voucher("Giảm 100.000đ", "Đơn từ 500.000đ", 100000));
    }

    private void setupRecyclerView() {
        adapter = new VoucherAdapter(requireContext(), voucherList);

        rvVoucher.setLayoutManager(new LinearLayoutManager(getContext()));

        rvVoucher.setAdapter(adapter);
    }

    private void setupEvents() {

        imgClose.setOnClickListener(v -> dismiss());

        btnConfirm.setOnClickListener(v -> {
            dismiss();
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            View parent = (View) view.getParent();
            parent.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
        }
    }
}
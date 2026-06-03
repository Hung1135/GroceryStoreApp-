package com.example.myapplication.holder;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class VoucherViewHolder extends RecyclerView.ViewHolder {
     TextView txtTitle;
     TextView txtDescription;
     RadioButton radioVoucher;
    public VoucherViewHolder(@NonNull View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtDescription = itemView.findViewById(R.id.txtDescription);
        radioVoucher = itemView.findViewById(R.id.radioVoucher);
    }

    public TextView getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(TextView txtTitle) {
        this.txtTitle = txtTitle;
    }

    public TextView getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(TextView txtDescription) {
        this.txtDescription = txtDescription;
    }

    public RadioButton getRadioVoucher() {
        return radioVoucher;
    }

    public void setRadioVoucher(RadioButton radioVoucher) {
        this.radioVoucher = radioVoucher;
    }
}

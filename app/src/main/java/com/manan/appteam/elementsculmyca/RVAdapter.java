package com.manan.appteam.elementsculmyca;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.DataViewHolder> {

    private List<DataObject> listItems;
    private Context context;

    public RVAdapter(List<DataObject> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView categoryName;
        ImageView categoryPhoto;

        DataViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            categoryName = (TextView) itemView.findViewById(R.id.category_name);
            categoryPhoto = (ImageView) itemView.findViewById(R.id.category_photo);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new DataViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DataViewHolder dataViewHolder, final int i) {
        DataObject listItem = listItems.get(i);

        dataViewHolder.categoryName.setText(listItem.getCategoryName());
        dataViewHolder.categoryPhoto.setImageResource(listItem.getImageResourceId());

        dataViewHolder.categoryPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Hello" + i, Toast.LENGTH_SHORT).show();    //ClickListener TODO
            }
        });
    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }
}

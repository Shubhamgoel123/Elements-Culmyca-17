package com.manan.appteam.elementsculmyca;

import android.content.Intent;
import android.support.annotation.IntRange;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.os.Build.VERSION_CODES.M;
import static java.security.AccessController.getContext;

/**
 * Created by naman on 26/01/17.
 */
public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.DataViewHolder> {

    List<EventObject> contents;


    static final int TYPE_CELL = 1;

    public TestRecyclerViewAdapter(List<EventObject> contents) {
        this.contents = contents;
    }


    public class DataViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView eventName;
        TextView eventSubtitle;
        TextView eventLocation;
        ImageView eventIcon;

        DataViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            eventName = (TextView) itemView.findViewById(R.id.event_name);
            eventLocation = (TextView) itemView.findViewById(R.id.event_location);
            eventIcon = (ImageView) itemView.findViewById(R.id.event_icon);

        }
    }

        @Override
    public int getItemViewType(int position) {

                return TYPE_CELL;

    }



        @Override
        public int getItemCount() {
            return contents.size();
        }

        @Override
        public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
                    view = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.list_item_card_small, parent, false);
                    return new DataViewHolder(view) ;

            }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {

        EventObject eventObject = contents.get(position);
        holder.eventName.setText(eventObject.getEventName());
        holder.eventLocation.setText(eventObject.getLocation());
        holder.eventIcon.setImageResource(eventObject.getImageResourceId());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // Click Listener TODO
                Toast.makeText(v.getContext(),"Hello",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext(),EventDetailActivity.class);
                v.getContext().startActivity(i);
            }
        });
    }
}
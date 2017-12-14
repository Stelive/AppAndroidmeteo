package it.itspiemonte.MeteoApp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CompitinoAdapter extends RecyclerView.Adapter<CompitinoAdapter.ArticleViewHolder> {
    private final Context context;
    private final ArrayList name;
    private final ArrayList state;
    private final ArrayList tempMax;
    private final ArrayList tempMin;

    public CompitinoAdapter(Activity activity, ArrayList name, ArrayList state, ArrayList tempMax, ArrayList tempMin) {
        this.context = activity;
        this.name = name;
        this.state = state;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        return new ArticleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, final int position) {
        holder.titleCity.setText((String) name.get(position));
        holder.stateText.setText((String) state.get(position));
        holder.tempMaxText.setText((String) "Temp Max: " + tempMax.get(position) + "°");
        holder.tempMinText.setText((String) "Temp Min: " + tempMin.get(position) + "°");
        holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.thumb));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ArticleActivity.class);
                i.putExtra("articleTitle", (String) name.get(position));
                i.putExtra("state", (String) state.get(position));
                i.putExtra("tempMax", (String) tempMax.get(position));
                i.putExtra("tempMin", (String) tempMin.get(position));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView titleCity;// init the item view's
        TextView stateText;
        TextView tempMaxText;
        TextView tempMinText;
        ImageView imageView;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            titleCity = (TextView) itemView.findViewById(R.id.title);
            stateText = (TextView) itemView.findViewById(R.id.State);
            tempMaxText = (TextView) itemView.findViewById(R.id.TempMax);
            tempMinText = (TextView) itemView.findViewById(R.id.TempMin);
            imageView = (ImageView) itemView.findViewById(R.id.thumb);
        }
    }
}

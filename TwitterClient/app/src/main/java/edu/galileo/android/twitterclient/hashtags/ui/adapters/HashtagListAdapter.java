package edu.galileo.android.twitterclient.hashtags.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.twitterclient.R;

/**
 * Created by Alex on 26-06-2016.
 */
public class HashtagListAdapter extends RecyclerView.Adapter<HashtagListAdapter.Viewholder> {
    private List<String> items;

    public HashtagListAdapter(ArrayList<String> items) {
        this.items = items;
    }


    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.content_hashtags,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        holder.txtHashtag.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class Viewholder extends RecyclerView.ViewHolder{

        @Bind(R.id.txtHashtag)
        TextView txtHashtag;


        public Viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

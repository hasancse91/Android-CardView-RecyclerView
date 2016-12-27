package co.megaminds.p1exam.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.megaminds.p1exam.Model.Popular;
import co.megaminds.p1exam.R;

/**
 * Created by hasan on 12/27/16.
 */

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder>{

    private Context mContext;
    private List<Popular> popularList;
    private View popularView;

    public HorizontalAdapter(Context context, List<Popular> populars) {
        popularList = populars;
        mContext = context;
    }


    @Override
    public HorizontalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        popularView = inflater.inflate(R.layout.populer_single_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(popularView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HorizontalAdapter.ViewHolder holder, int position) {

        Popular popular = popularList.get(position);

        //image load using Picasso

        holder.nameTextView.setText(popular.getName());

        holder.countOne.setText(popular.getCount());

        holder.loremOne.setText(popular.getType());

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public ImageView popularImage;
        public TextView nameTextView;
        public TextView countOne;
        public TextView loremOne;
        public TextView countTwo;
        public TextView loremTwo;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            popularImage = (ImageView) itemView.findViewById(R.id.popular_image);
            nameTextView = (TextView) itemView.findViewById(R.id.name);
            countOne = (TextView) itemView.findViewById(R.id.count1);
            loremOne = (TextView) itemView.findViewById(R.id.lorem1);
            countTwo = (TextView) itemView.findViewById(R.id.count2);
            loremTwo = (TextView) itemView.findViewById(R.id.lorem2);

        }
    }
}

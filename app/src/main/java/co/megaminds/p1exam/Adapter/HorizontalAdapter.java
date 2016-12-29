package co.megaminds.p1exam.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import co.megaminds.p1exam.Model.Popular;
import co.megaminds.p1exam.R;


public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.CustomViewHolder>{

    private Context mContext;
    private List<Popular> popularList;

    public HorizontalAdapter(Context context, List<Popular> populars) {
        popularList = populars;
        mContext = context;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.populer_single_item, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        Popular popular = popularList.get(position);

        Picasso.with(mContext)
                .load(popular.getImage())
                .into(holder.popularImage);

        holder.nameTextView.setText(popular.getName());
        holder.countOne.setText(String.valueOf(popular.getCount()));
        holder.loremOne.setText(popular.getType());
    }


    @Override
    public int getItemCount() {
        return (null != popularList ? popularList.size() : 0);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        ImageView popularImage;
        TextView nameTextView;
        TextView countOne;
        TextView loremOne;
        TextView countTwo;
        TextView loremTwo;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public CustomViewHolder(View itemView) {
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

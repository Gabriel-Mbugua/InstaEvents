package android.example.instaeventsv1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context mContext;
    private List<CategoryModel> mData;

    public CategoryAdapter(Context mContext, List<CategoryModel> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, final int position) {
        // holder.tv_event_title.setText(mData.get(position).getTitle());
        holder.tv_event_category.setText(mData.get(position).getCategory());
        holder.img_event_thumbnail.setImageResource(mData.get(position).getThumbnail());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Intent intent =  new Intent(mContext, Event_Activity.class);

                //passing data to the event activity
                intent.putExtra("Title",mData.get(position).getCategory());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                //start the activity
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        //  TextView tv_event_title;
        TextView tv_event_category;
        ImageView img_event_thumbnail;
        CardView mCardView;

        public ViewHolder(View itemView){
            super(itemView);

            // tv_event_title = itemView.findViewById(R.id.event_title);
            tv_event_category = itemView.findViewById(R.id.event_category);
            img_event_thumbnail = itemView.findViewById(R.id.event_image);
            mCardView = itemView.findViewById(R.id.cardview_category);
        }
    }
}

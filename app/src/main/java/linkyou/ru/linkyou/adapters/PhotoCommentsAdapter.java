package linkyou.ru.linkyou.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import linkyou.ru.linkyou.R;
import linkyou.ru.linkyou.models.photos.photo_comments.PhotoCommentsData;
import linkyou.ru.linkyou.utils.CircularTransformation;

public class PhotoCommentsAdapter extends RecyclerView.Adapter<PhotoCommentsAdapter.ViewHolder> {
    private List<PhotoCommentsData> photoCommentsDataList;
    private Context mContext;

    public PhotoCommentsAdapter(List<PhotoCommentsData> photoCommentsData) {
        this.photoCommentsDataList = photoCommentsData;
    }

    @NonNull
    @Override
    public PhotoCommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photo_comments_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoCommentsAdapter.ViewHolder holder, int position) {
        final PhotoCommentsData photoCommentsData = photoCommentsDataList.get(position);

        try {
            holder.commentTextView.setText(photoCommentsData.getUser().getName());
            holder.datetimeTextView.setText(photoCommentsData.getDatetime());



            if (photoCommentsData.getUser().isIsOnline()) {
                holder.onlineImageView.setVisibility(View.VISIBLE);
            } else {
                holder.onlineImageView.setVisibility(View.GONE);
            }

            if (photoCommentsData.getUser().isIsPremium()) {
                holder.premiumImageView.setVisibility(View.VISIBLE);
            } else {
                holder.premiumImageView.setVisibility(View.GONE);
            }

            Picasso.with(mContext)
                    .load("https:" + photoCommentsData.getUser().getAvatar().getSmall())
                    .transform(new CircularTransformation(0))
                    .into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("mData", "id: " + String.valueOf(usersDailyData.getId()));
                Toast.makeText(mContext, photoCommentsData.getUser().getName(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if (photoCommentsDataList == null) {
            return 0;
        }
        return photoCommentsDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, onlineImageView, premiumImageView;
        TextView commentTextView, datetimeTextView;
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.avatarImageView);
            onlineImageView = itemView.findViewById(R.id.onlineImageView);
            premiumImageView = itemView.findViewById(R.id.premiumImageView);
            commentTextView = itemView.findViewById(R.id.commentTextView);
            datetimeTextView = itemView.findViewById(R.id.datetimeTextView);
        }
    }
}

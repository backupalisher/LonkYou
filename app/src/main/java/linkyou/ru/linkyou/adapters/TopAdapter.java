package linkyou.ru.linkyou.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import linkyou.ru.linkyou.R;
import linkyou.ru.linkyou.models.users.top.TopData;
import linkyou.ru.linkyou.ui.users.UserPageActivity;
import linkyou.ru.linkyou.utils.CircularTransformation;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.ViewHolder> {
    private List<TopData> topDataList;
    private Context mContext;

    public TopAdapter(List<TopData> topDataList) {
        this.topDataList = topDataList;
    }

    @NonNull
    @Override
    public TopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top_list, parent, false);
        return new TopAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopAdapter.ViewHolder holder, int position) {
        final TopData topData = topDataList.get(position);

        try {
            holder.accountName.setText(topData.getName()+", "+topData.getBirthday().getAge());
            holder.professionText.setText(topData.getJob().getProfession());
            holder.occupationText.setText(topData.getJob().getOccupation());
            holder.photoText.setText(topData.getPhotosCount());
            holder.locationText.setText(topData.getLocation().getCityName());

            if (topData.isIsOnline()) {
                holder.onlineImageView.setVisibility(View.VISIBLE);
            } else {
                holder.onlineImageView.setVisibility(View.GONE);
            }

            if (topData.isIsPremium()) {
                holder.premiumImageView.setVisibility(View.VISIBLE);
            } else {
                holder.premiumImageView.setVisibility(View.GONE);
            }

            Picasso.with(mContext)
                    .load("https:" + topData.getAvatar().getSmall())
                    .transform(new CircularTransformation(0))
                    .into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("mData", "id: " + String.valueOf(usersDailyData.getId()));
                Intent intent = new Intent(mContext, UserPageActivity.class);
                intent.putExtra("id", topData.getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (topDataList == null) {
            return 0;
        }
        return topDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, onlineImageView, premiumImageView;
        TextView accountName , professionText, occupationText, photoText, locationText;
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.avatarImageView);
            onlineImageView = itemView.findViewById(R.id.onlineImageView);
            premiumImageView = itemView.findViewById(R.id.premiumImageView);
            accountName = itemView.findViewById(R.id.accountNameTextView);
            occupationText = itemView.findViewById(R.id.occupationTextView);
            professionText = itemView.findViewById(R.id.professionTextView);
            photoText = itemView.findViewById(R.id.photoTextView);
            locationText = itemView.findViewById(R.id.locationTextView);
            linearLayout = itemView.findViewById(R.id.topLinearLayout);
        }
    }
}

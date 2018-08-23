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
import linkyou.ru.linkyou.models.users.favorites.FavoritesData;
import linkyou.ru.linkyou.ui.users.UserPageActivity;
import linkyou.ru.linkyou.utils.CircularTransformation;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {
    private List<FavoritesData> favoritesDataList;
    private Context mContext;

    public FavoritesAdapter(List<FavoritesData> favoritesDataList) {
        this.favoritesDataList = favoritesDataList;
    }

    @NonNull
    @Override
    public FavoritesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favorites_list, parent, false);
        return new FavoritesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapter.ViewHolder holder, int position) {
        final FavoritesData favoritesData = favoritesDataList.get(position);

        try {
            holder.accountName.setText(favoritesData.getName()+", "+favoritesData.getBirthday().getAge());
            holder.professionText.setText(favoritesData.getJob().getProfession()+", "+favoritesData.getJob().getOccupation());
            holder.photoText.setText(favoritesData.getPhotosCount());
            holder.geoText.setText(favoritesData.getLocation().getCityName());

            if (favoritesData.isIsOnline()) {
                holder.onlineImageView.setVisibility(View.VISIBLE);
            } else {
                holder.onlineImageView.setVisibility(View.GONE);
            }

            if (favoritesData.isIsPremium()) {
                holder.premiumImageView.setVisibility(View.VISIBLE);
            } else {
                holder.premiumImageView.setVisibility(View.GONE);
            }

            Picasso.with(mContext)
                    .load("https:" + favoritesData.getAvatar().getSmall())
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
                intent.putExtra("id", favoritesData.getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (favoritesDataList == null) {
            return 0;
        }
        return favoritesDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, onlineImageView, premiumImageView;
        TextView accountName , professionText, photoText, geoText;
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.avatarImageView);
            onlineImageView = itemView.findViewById(R.id.onlineImageView);
            premiumImageView = itemView.findViewById(R.id.premiumImageView);
            accountName = itemView.findViewById(R.id.accountNameAgeTextView);
            professionText = itemView.findViewById(R.id.professionTextView);
            photoText = itemView.findViewById(R.id.photoTextView);
            geoText = itemView.findViewById(R.id.geoTextView);
            linearLayout = itemView.findViewById(R.id.favoritesLinearLayout);
        }
    }
}

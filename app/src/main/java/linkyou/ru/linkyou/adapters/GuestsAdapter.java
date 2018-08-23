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

import java.text.SimpleDateFormat;
import java.util.List;

import linkyou.ru.linkyou.R;
import linkyou.ru.linkyou.models.users.guests.GuestsData;
import linkyou.ru.linkyou.ui.users.UserPageActivity;
import linkyou.ru.linkyou.utils.CircularTransformation;

public class GuestsAdapter extends RecyclerView.Adapter<GuestsAdapter.ViewHolder> {
    private List<GuestsData> guestsDataList;
    private Context mContext;

    public GuestsAdapter(List<GuestsData> guestsDataList) {
        this.guestsDataList = guestsDataList;
    }

    @NonNull
    @Override
    public GuestsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.guests_list, parent, false);
        return new GuestsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestsAdapter.ViewHolder holder, int position) {
        final GuestsData guestsData = guestsDataList.get(position);

        try {
            holder.accountName.setText(guestsData.getUser().getName()+", "+guestsData.getUser().getBirthday().getAge());
            holder.professionText.setText(guestsData.getUser().getJob().getProfession()+", "+guestsData.getUser().getJob().getOccupation());
            holder.photoText.setText(guestsData.getUser().getPhotosCount());
            holder.geoText.setText(guestsData.getUser().getLocation().getCityName());

            SimpleDateFormat format = new SimpleDateFormat("hh:mm");
            holder.dataTime.setText((CharSequence) format.parse(guestsData.getDatetime()));

            if (guestsData.getUser().isIsOnline()) {
                holder.onlineImageView.setVisibility(View.VISIBLE);
                holder.premiumImageView.setVisibility(View.VISIBLE);
            } else {
                holder.onlineImageView.setVisibility(View.GONE);
                holder.premiumImageView.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Picasso.with(mContext)
                .load("https:" + guestsData.getUser().getAvatar().getSmall())
                .transform(new CircularTransformation(0))
                .into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("mData", "id: " + String.valueOf(guestsData.getUser().getId()));
                Intent intent = new Intent(mContext, UserPageActivity.class);
                intent.putExtra("id", guestsData.getUser().getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (guestsDataList == null) {
            return 0;
        }
        return guestsDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, onlineImageView, premiumImageView;
        TextView accountName , dataTime, professionText, photoText, likesCount, geoText;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.avatarImageView);
            onlineImageView = itemView.findViewById(R.id.onlineImageView);
            premiumImageView = itemView.findViewById(R.id.premiumImageView);
            accountName = itemView.findViewById(R.id.accountNameAgeTextView);
            dataTime = itemView.findViewById(R.id.timeTextView);
            professionText = itemView.findViewById(R.id.professionTextView);
            photoText = itemView.findViewById(R.id.photoTextView);
            likesCount = itemView.findViewById(R.id.likesCountTextView);
            geoText = itemView.findViewById(R.id.geoTextView);
            linearLayout = itemView.findViewById(R.id.guestsLinearLayout);
        }
    }
}

//public class GuestsAdapter extends RecyclerView.Adapter<GuestsAdapter.ViewHolder>{
//    private List<GuestsData> guestsDataList;
////    private List<GuestsData> guestsDataListFiltered;
////    private GuestsAdapterListener listener;
//    private Context mContext;
//
//    public GuestsAdapter(List<GuestsData> guestsDataList) {
////        this.mContext = context;
////        this.listener = listener;
//        this.guestsDataList = guestsDataList;
////        this.guestsDataListFiltered = guestsDataList;
//    }
//
////    public class MyViewHolder extends RecyclerView.ViewHolder {
////        public TextView name, phone;
////        public ImageView thumbnail;
////
////        public MyViewHolder(View view) {
////            super(view);
////            name = view.findViewById(R.id.accountNameAgeTextView);
//////            phone = view.findViewById(R.id.phone);
//////            thumbnail = view.findViewById(R.id.thumbnail);
////
////            view.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    // send selected contact in callback
////                    listener.onGuestsSelected(guestsDataList.get(getAdapterPosition()));
////                }
////            });
////        }
////    }
//
//    @NonNull
//    @Override
//    public GuestsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        mContext = parent.getContext();
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.guests_list, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull GuestsAdapter.ViewHolder holder, int position) {
//        final GuestsData guestsData = guestsDataList.get(position);
//
//        try {
//            holder.accountName.setText(guestsData.getName()+", "+guestsData.getBirthday().getAge());
//            holder.professionText.setText(guestsData.getJob().getProfession()+", "+guestsData.getJob().getOccupation());
//            holder.photoText.setText(guestsData.getPhotosCount());
//            holder.geoText.setText(guestsData.getLocation().getCityName());
//
//            if (guestsData.isIsOnline()) {
//                holder.onlineImageView.setVisibility(View.VISIBLE);
//            } else {
//                holder.onlineImageView.setVisibility(View.GONE);
//            }
//
//            if (guestsData.isIsPremium()) {
//                holder.premiumImageView.setVisibility(View.VISIBLE);
//            } else {
//                holder.premiumImageView.setVisibility(View.GONE);
//            }
//
//            Picasso.with(mContext)
//                    .load("https:" + guestsData.getAvatar().getSmall())
//                    .transform(new CircularTransformation(0))
//                    .into(holder.imageView);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Log.d("mData", "id: " + String.valueOf(usersDailyData.getId()));
//                Intent intent = new Intent(mContext, UserPageActivity.class);
//                intent.putExtra("id", guestsData.getId());
//                mContext.startActivity(intent);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        if (guestsDataList == null) {
//            return 0;
//        }
//        return guestsDataList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView imageView, onlineImageView, premiumImageView;
//        TextView accountName , dataTime, professionText, photoText, likesCount, geoText;
//        LinearLayout linearLayout;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            imageView = itemView.findViewById(R.id.avatarImageView);
//            onlineImageView = itemView.findViewById(R.id.onlineImageView);
//            premiumImageView = itemView.findViewById(R.id.premiumImageView);
//            accountName = itemView.findViewById(R.id.accountNameAgeTextView);
//            dataTime = itemView.findViewById(R.id.timeTextView);
//            professionText = itemView.findViewById(R.id.professionTextView);
//            photoText = itemView.findViewById(R.id.photoTextView);
//            likesCount = itemView.findViewById(R.id.likesCountTextView);
//            geoText = itemView.findViewById(R.id.geoTextView);
//            linearLayout = itemView.findViewById(R.id.guestsLinearLayout);
//        }
//    }
//
////    public interface GuestsAdapterListener {
////        void onGuestsSelected(GuestsData guestsData);
////    }
//}

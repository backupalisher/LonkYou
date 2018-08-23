package linkyou.ru.linkyou.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
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
import linkyou.ru.linkyou.models.users.users_daily.UsersDailyData;
import linkyou.ru.linkyou.ui.users.UserPageActivity;
import linkyou.ru.linkyou.utils.CircularTransformation;

public class UsersDailyAdapter extends RecyclerView.Adapter<UsersDailyAdapter.ViewHolder> {
    private List<UsersDailyData> usersDailyDataList;
    private Context mContext;

    public UsersDailyAdapter(List<UsersDailyData> usersDailyData) {
        this.usersDailyDataList = usersDailyData;
    }

    @NonNull
    @Override
    public UsersDailyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_daily_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersDailyAdapter.ViewHolder holder, int position) {
        final UsersDailyData usersDailyData = usersDailyDataList.get(position);

        try {
            holder.accountName.setText(usersDailyData.getName()+ ", ");
            holder.accountAge.setText(usersDailyData.getBirthday().getAge());
            holder.professionText.setText(usersDailyData.getJob().getProfession());
            holder.profAreaText.setText(usersDailyData.getJob().getOccupation());


            if (usersDailyData.isIsOnline()) {
                holder.onlineImageView.setVisibility(View.VISIBLE);
            } else {
                holder.onlineImageView.setVisibility(View.GONE);
            }

            if (usersDailyData.isIsPremium()) {
                holder.premiumImageView.setVisibility(View.VISIBLE);
            } else {
                holder.premiumImageView.setVisibility(View.GONE);
            }

            Picasso.with(mContext)
                    .load("https:" + usersDailyData.getAvatar().getSmall())
                    .transform(new CircularTransformation(0))
                    .into(holder.imageView);

            holder.photoText.setText(usersDailyData.getPhotosCount());
            holder.geoText.setText(usersDailyData.getLocation().getCityName());


        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("mData", "id: " + String.valueOf(usersDailyData.getId()));
                Intent intent = new Intent(mContext, UserPageActivity.class);
                intent.putExtra("id", usersDailyData.getId());
                mContext.startActivity(intent);
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertadd = new AlertDialog.Builder(mContext);
                LayoutInflater factory = LayoutInflater.from(mContext);
                final View view = factory.inflate(R.layout.dialog_image_view, null);
                ImageView imageView2 = (ImageView) view.findViewById(R.id.dialog_imageview);
                Picasso.with(mContext)
                        .load("https:" + usersDailyData.getAvatar().getOrigin())
                        .into(imageView2);
//                alertadd.setNeutralButton("Закрыть", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dlg, int sumthin) {
//
//                    }
//                });
                alertadd.setView(view);

                final AlertDialog dialog = alertadd.create();
                imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        if (usersDailyDataList == null) {
            return 0;
        }
        return usersDailyDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, onlineImageView, premiumImageView;
        TextView accountName , accountAge, professionText, profAreaText, photoText, geoText;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.avatarImageView);
            onlineImageView = itemView.findViewById(R.id.onlineImageView);
            premiumImageView = itemView.findViewById(R.id.premiumImageView);
            accountName = itemView.findViewById(R.id.accountNameTextView);
            accountAge = itemView.findViewById(R.id.accountAgeTextView);
            professionText = itemView.findViewById(R.id.professionTextView);
            profAreaText = itemView.findViewById(R.id.prof_areaTextView);
            photoText = itemView.findViewById(R.id.photoTextView);
            geoText = itemView.findViewById(R.id.geoTextView);
            linearLayout = itemView.findViewById(R.id.peopleDayLinearLayout);

        }
    }
}


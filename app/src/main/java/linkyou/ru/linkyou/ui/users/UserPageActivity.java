package linkyou.ru.linkyou.ui.users;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import linkyou.ru.linkyou.R;
import linkyou.ru.linkyou.api.LinkAPI;
import linkyou.ru.linkyou.models.photos.user_gallery.UserGalleryData;
import linkyou.ru.linkyou.models.users.user_id.UserDataJSON;
import linkyou.ru.linkyou.ui.photos.PhotoActivity;
import linkyou.ru.linkyou.utils.CircularTransformation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPageActivity extends AppCompatActivity {

    SharedPreferences sPref;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        final ImageView UserimageView = (ImageView) findViewById(R.id.UserimageView);
        final TextView UserNameHeadText = (TextView) findViewById(R.id.UserNameHeadText);
        final TextView professionTextView = (TextView) findViewById(R.id.professionTextView);
        final TextView professionTextView2 = (TextView) findViewById(R.id.professionTextView2);
        final TextView occupationTextView = (TextView) findViewById(R.id.occupationTextView);
        final TextView likesCountTextView = (TextView) findViewById(R.id.likesCountTextView);
        final TextView photosCountTextView = (TextView) findViewById(R.id.photosCountTextView);
        final TextView CityNameTextView = (TextView) findViewById(R.id.CityNameTextView);
        final TextView zodiacTextView = (TextView) findViewById(R.id.zodiacTextView);
        final TextView nationalityTextView = (TextView) findViewById(R.id.nationalityTextView);
        final TextView lookingTextView = (TextView) findViewById(R.id.lookingTextView);
        final TextView religionTextView = (TextView) findViewById(R.id.religionTextView);
        final TextView goalTextView = (TextView) findViewById(R.id.goalTextView);
        final TextView photosCountTextView2 = (TextView) findViewById(R.id.photosCountTextView2);
//        final TextView blogsCountTextView = (TextView)findViewById(R.id.blogsCountTextView);
        final ImageView blogAccountImageView = (ImageView) findViewById(R.id.blogAccountImageView);
        final TextView blogAccountNameTextView = (TextView) findViewById(R.id.blogAccountNameTextView);
//        final TextView blogDatesTextView = (TextView) findViewById(R.id.blogDatesTextView);
        final TextView aboutTextView = (TextView) findViewById(R.id.aboutTextView);
        final TextView heightTextView = (TextView) findViewById(R.id.heightTextView);
        final TextView relationshipTextView = (TextView) findViewById(R.id.relationshipTextView);
        final TextView orientationTextView = (TextView) findViewById(R.id.orientationTextView);
        final TextView childrenTextView = (TextView) findViewById(R.id.childrenTextView);
        final TextView smokingTextView = (TextView) findViewById(R.id.smokingTextView);
        final TextView alcoholTextView = (TextView) findViewById(R.id.alcoholTextView);
        final TextView education_typeTextView = (TextView) findViewById(R.id.education_typeTextView);
        final TextView institutionTextView = (TextView) findViewById(R.id.institutionTextView);
        final TextView specialityTextView = (TextView) findViewById(R.id.specialityTextView);
        final TextView languagesTextView = (TextView) findViewById(R.id.languagesTextView);
        final TextView prosTextView = (TextView) findViewById(R.id.prosTextView);
        final TextView consTextView = (TextView) findViewById(R.id.consTextView);
        final TextView financeTextView = (TextView) findViewById(R.id.financeTextView);



        final LinkAPI linkAPI = LinkAPI.retrofit.create(LinkAPI.class);
//        final String baerer = "Bearer NnSGgDzo19_7PRKfOQCBbGSBCl-AZJt1";

        sPref = getSharedPreferences("mSettings", MODE_PRIVATE);
        token = sPref.getString("token", "");

        final Intent intent = getIntent();
        final String userId = intent.getStringExtra("id");

        final Call<UserDataJSON> call = linkAPI.getUsersId(userId, token);

        call.enqueue(new Callback<UserDataJSON>() {
            @Override
            public void onResponse(Call<UserDataJSON> call, Response<UserDataJSON> response) {
                if (response.isSuccessful()) {

                    UserDataJSON userData = null;
                    try {
                        userData = response.body();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        Picasso.with(UserPageActivity.this)
                                .load("https:" + userData.getAvatar().getOrigin())
                                .into(UserimageView);
                        actionBar.setTitle(userData.getName());
                        UserNameHeadText.setText(userData.getName() + ", " + userData.getBirthday().getAge());
                        professionTextView.setText(userData.getJob().getProfession() + ", " + userData.getJob().getOccupation());
                        professionTextView2.setText(userData.getJob().getProfession());
                        occupationTextView.setText(userData.getJob().getOccupation());

                        CityNameTextView.setText(userData.getLocation().getCityName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        likesCountTextView.setText(userData.getLikes().getCount());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        photosCountTextView.setText(userData.getPhotosCount());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        photosCountTextView2.setText(userData.getPhotosCount() + " Фото");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    try {
//                        blogsCountTextView.setText(userData.getBlogsCount() + " записей");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                    try {
                        Picasso.with(UserPageActivity.this)
                                .load("https:" + userData.getAvatar().getSmall())
                                .transform(new CircularTransformation(0))
                                .into(blogAccountImageView);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        blogAccountNameTextView.setText(userData.getName() + ", " + userData.getBirthday().getAge());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    try {
//                        blogDatesTextView.setText(userData.getBlogs().getLast().getLastUpdate());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }


                    try {
                        if (userData.getBirthday().getZodiac().getName() != null) {
                            if (userData.getBirthday().getZodiac().getId().equals("leo")) {
                                zodiacTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_leo, 0, 0, 0);
                            } else if (userData.getBirthday().getZodiac().getId().equals("virgo")) {
                                zodiacTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_virgo, 0, 0, 0);
                            } else if (userData.getBirthday().getZodiac().getId().equals("sagittarius")) {
                                zodiacTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_sagittarius, 0, 0, 0);
                            } else if (userData.getBirthday().getZodiac().getId().equals("capricornus")) {
                                zodiacTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_capricorn, 0, 0, 0);
                            } else if (userData.getBirthday().getZodiac().getId().equals("gemini")) {
                                zodiacTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_gemini, 0, 0, 0);
                            } else if (userData.getBirthday().getZodiac().getId().equals("aries")) {
                                zodiacTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_aries, 0, 0, 0);
                            } else if (userData.getBirthday().getZodiac().getId().equals("cancer")) {
                                zodiacTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_cancer, 0, 0, 0);
                            } else if (userData.getBirthday().getZodiac().getId().equals("pisces")) {
                                zodiacTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pisces, 0, 0, 0);
                            } else if (userData.getBirthday().getZodiac().getId().equals("aquarius")) {
                                zodiacTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_aquarius, 0, 0, 0);
                            } else if (userData.getBirthday().getZodiac().getId().equals("libra")) {
                                zodiacTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_libra, 0, 0, 0);
                            } else if (userData.getBirthday().getZodiac().getId().equals("taurus")) {
                                zodiacTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_taurus, 0, 0, 0);
                            } else if (userData.getBirthday().getZodiac().getId().equals("scorpius")) {
                                zodiacTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_scorpio, 0, 0, 0);
                            }

                            SpannableString text = new SpannableString("  " + userData.getBirthday().getZodiac().getName());
                            zodiacTextView.setText(text);
                            zodiacTextView.setVisibility(View.VISIBLE);
                        } else {
                            zodiacTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        if (userData.getNationality().getName() != null) {
                            nationalityTextView.setText(userData.getNationality().getName());
                            nationalityTextView.setVisibility(View.VISIBLE);
                        } else {
                            nationalityTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        if (userData.getLookingFor().getName() != null) {
                            lookingTextView.setText("Ищу " + userData.getLookingFor().getName().toLowerCase() + " от " + userData.getAge().getFrom() + " до " + userData.getAge().getTo());
                            lookingTextView.setVisibility(View.VISIBLE);
                        } else {
                            lookingTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        if (userData.getReligion().getStatus() != null) {
                            religionTextView.setText(userData.getReligion().getStatus());
                            religionTextView.setVisibility(View.VISIBLE);
                        } else {
                            religionTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        if (userData.getGoal().getName() != null) {
                            goalTextView.setText("Цель: " + userData.getGoal().getName());
                            goalTextView.setVisibility(View.VISIBLE);
                        } else {
                            goalTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        if (userData.getAbout() != null) {
                            aboutTextView.setText(userData.getAbout());
                            aboutTextView.setVisibility(View.VISIBLE);
                        } else {
                            aboutTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        if (userData.getHeight() != null) {
                            heightTextView.setText(userData.getHeight());
                            heightTextView.setVisibility(View.VISIBLE);
                        } else {
                            heightTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        if (userData.getRelationship().getName() != null) {
                            relationshipTextView.setText(userData.getRelationship().getName());
                            relationshipTextView.setVisibility(View.VISIBLE);
                        } else {
                            relationshipTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        if (userData.getOrientation().getName() != null) {
                            orientationTextView.setText(userData.getOrientation().getName());
                            orientationTextView.setVisibility(View.VISIBLE);
                        } else {
                            orientationTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        if (userData.getChildren().getName() != null) {
                            childrenTextView.setText(userData.getChildren().getName());
                            childrenTextView.setVisibility(View.VISIBLE);
                        } else {
                            childrenTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        if (userData.getSmoking().getName() != null) {
                            smokingTextView.setText(userData.getSmoking().getName());
                            smokingTextView.setVisibility(View.VISIBLE);
                        } else {
                            smokingTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        if (userData.getAlcohol().getName() != null) {
                            alcoholTextView.setText(userData.getAlcohol().getName());
                            alcoholTextView.setVisibility(View.VISIBLE);
                        } else {
                            alcoholTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        if (userData.getInterests().getInterests() != null) {
                            for (int i = 0; i < response.body().getInterests().getInterests().size(); i++) {
                                com.google.android.flexbox.FlexboxLayout interestsLayout = (com.google.android.flexbox.FlexboxLayout) findViewById(R.id.interestsLayout);

                                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                TextView interestsTextView = new TextView(UserPageActivity.this);

                                interestsTextView.setText(userData.getInterests().getInterests().get(i).toString());
                                interestsTextView.setBackgroundResource(R.drawable.circle_button_gray);
                                interestsTextView.setPadding(10,10,10,10);
                                interestsTextView.setLayoutParams(params);

                                interestsLayout.addView(interestsTextView);

                                TextView nullTextView = new TextView(UserPageActivity.this);
                                nullTextView.setText("");
                                nullTextView.setPadding(5,10,5,20);
                                nullTextView.setLayoutParams(params);

                                interestsLayout.addView(nullTextView);

                            }

                            alcoholTextView.setText(userData.getAlcohol().getName());
                            alcoholTextView.setVisibility(View.VISIBLE);
                        } else {
                            alcoholTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        if (userData.getBooks() != null) {
                            for (int i = 0; i < userData.getBooks().size(); i++) {

                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        if (userData.getEducation() != null) {
                            education_typeTextView.setText(userData.getEducation().get(0).getEducationType().getName());
                            institutionTextView.setText(userData.getEducation().get(0).getInstitution().getName());
                            specialityTextView.setText(userData.getEducation().get(0).getSpeciality().getName());
                            education_typeTextView.setVisibility(View.VISIBLE);
                            institutionTextView.setVisibility(View.VISIBLE);
                            specialityTextView.setVisibility(View.VISIBLE);
                        } else {
                            education_typeTextView.setVisibility(View.GONE);
                            institutionTextView.setVisibility(View.GONE);
                            specialityTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        if (userData.getInterests().getInterests() != null) {
                            for (int i = 0; i < response.body().getLanguages().size(); i++) {
                                languagesTextView.append(userData.getLanguages().get(i).getLanguage().getName()+" (" +
                                                         userData.getLanguages().get(i).getLevel().getName() + ")\n");
                            }
                            languagesTextView.setVisibility(View.VISIBLE);
                        } else {
                            languagesTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        if (userData.getJob().getPros() != null) {
                            prosTextView.setText(userData.getJob().getPros());
                            prosTextView.setVisibility(View.VISIBLE);
                        } else {
                            prosTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        if (userData.getJob().getCons() != null) {
                            consTextView.setText(userData.getJob().getCons());
                            consTextView.setVisibility(View.VISIBLE);
                        } else {
                            consTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        if (userData.getJob().getFinance().getName() != null) {
                            financeTextView.setText(userData.getJob().getFinance().getName());
                            financeTextView.setVisibility(View.VISIBLE);
                        } else {
                            financeTextView.setVisibility(View.GONE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<UserDataJSON> call, Throwable t) {
                Log.i("mData", "Что-то пошло не так: " + t.getMessage());
            }
        });

        final Call<List<UserGalleryData>> callPhotos = linkAPI.getUserGallery(userId, 15, token);

        callPhotos.enqueue(new Callback<List<UserGalleryData>>() {

            @Override
            public void onResponse(Call<List<UserGalleryData>> call, Response<List<UserGalleryData>> response) {
                if (response.isSuccessful()){
                    List<UserGalleryData> userPhotosData = null;
                    try {
                        userPhotosData = response.body();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < userPhotosData.size(); i++) {
                        LinearLayout photosLayout = (LinearLayout) findViewById(R.id.photosListLayout);

                        ImageView photoImageView = new ImageView(UserPageActivity.this);
//                        LinearLayout.LayoutParams photoImageView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.120, LayoutParams.WRAP_CONTENT);

                        Picasso.with(UserPageActivity.this)
                                .load("https:" + userPhotosData.get(i).getSrc().getSmall())
                                .fit().centerCrop()
                                .into(photoImageView);

                        final String imgURL = "https:" + userPhotosData.get(i).getSrc().getOrigin();
                        final String imgId = userPhotosData.get(i).getId();
                        final String imgUserId = userPhotosData.get(i).getUserId();
                        photoImageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
//                                Log.d("mData", imgURL);
                                Intent intent1 = new Intent(UserPageActivity.this, PhotoActivity.class);
                                intent1.putExtra("url",imgURL);
                                intent1.putExtra("id",imgId);
                                intent1.putExtra("user_id",imgUserId);

                                startActivity(intent1);
//                                Log.d("mData", imgUserId);
                            }
                        });

                        LinearLayout.LayoutParams imageViewLayoutParams = new LinearLayout.LayoutParams(200, 250);
                        imageViewLayoutParams.setMargins(5,8,5,8);
                        photoImageView.setLayoutParams(imageViewLayoutParams);
//                        interestsTextView.setBackgroundResource(R.drawable.circle_button_gray);
//                        interestsTextView.setPadding(10,10,10,10);
//                        interestsTextView.setText(userData.getInterests().getInterests().get(i).toString());

                        photosLayout.addView(photoImageView);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserGalleryData>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

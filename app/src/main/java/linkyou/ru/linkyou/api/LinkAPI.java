package linkyou.ru.linkyou.api;

import java.util.List;

import linkyou.ru.linkyou.models.users.favorites.FavoritesData;
import linkyou.ru.linkyou.models.users.guests.GuestsData;
import linkyou.ru.linkyou.models.users.top.TopData;
import linkyou.ru.linkyou.models.users.user_current.UserCurrentData;
import linkyou.ru.linkyou.models.users.user_id.UserDataJSON;
import linkyou.ru.linkyou.models.users.users_daily.UsersDailyData;
import linkyou.ru.linkyou.models.photos.photo_comments.PhotoCommentsData;
import linkyou.ru.linkyou.models.photos.user_gallery.UserGalleryData;
import linkyou.ru.linkyou.models.photos.user_photo.UserPhotoData;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LinkAPI {

    //Список новых пользователей для блока Новые пользователи
    @GET("users/new")
    Call<List<UsersDailyData>> getUsersNew(@Query("city_id") String cityId,
                                           @Query("page") int page,
                                           @Query("limit") int limit,
                                           @Header("Authorization") String authToken);

    //Список всех комментариев к фотографии {photo_id}
    @GET("photo/{photo_id}/comments")
    Call<List<PhotoCommentsData>> getPhotoComments(@Path("photo_id") String userId,
                                               @Header("Authorization") String authToken);

    //Фотография детально
    @GET("photo/{photo_id}")
    Call<List<UserPhotoData>> getPhotoID(@Path("photo_id") String userId,
                                               @Header("Authorization") String authToken);

    //Список фотографий пользователя {user_id}. Параметр limit по умолчанию равен 15
    @GET("photos/{user_id}")
    Call<List<UserGalleryData>> getUserGallery(@Path("user_id") String userId,
                                               @Query("limit") int limit,
                                               @Header("Authorization") String authToken);

    //Список гостей посетивших вашу страницу
    @GET("guests")
    Call<List<GuestsData>> getGuests(@Header("Authorization") String authToken);

    //Список пользователей ТОП100
    @GET("users/top")
    Call<List<TopData>> getTop(@Query("type") String type,
                               @Header("Authorization") String authToken);

    //Список избранных пользователей
    @GET("favorites")
    Call<List<FavoritesData>> getFavorites(@Header("Authorization") String authToken);

    //Данные текущего авторизованного пользователя.
    @GET("user/current?compact=1")
    Call<UserCurrentData> getUserCurrent(@Header("Authorization") String authToken);

    //Данные пользователя. Доп. параметры работают только в включеном compact=1
    @GET("user/{user_id}")
    Call<UserDataJSON> getUsersId(@Path("user_id") String userId,
//                                         @Query("location") int location,   //Добавить местоположение
//                                         @Query("education") int education, //Добавить образование
//                                         @Query("interests") int interests, //Добавить интересы
//                                         @Query("languages") int languages, //Добавить знание языков
//                                         @Query("book") int book,           //Добавить прочитанные книги
//                                         @Query("music") int music,         //Добавить музыку
//                                         @Query("pet") int pet,             //Добавить питомцев
//                                         @Query("likes") int likes,         //Добавить лайки
//                                         @Query("favorites") int favorites, //Добавить избранных
//                                         @Query("blackList") int blackList, //Добавить черный список
//                                         @Query("rating") int rating,       //Добавить рейтинг
//                                         @Query("photos") int photos,       //Добавить фотки
//                                         @Query("blogs") int blogs,         //Добавить записи из блога
//                                         @Query("gifts") int gifts,         //Добавить подарки
                                  @Header("Authorization") String authToken);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://linkyou2.klendev.ru/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

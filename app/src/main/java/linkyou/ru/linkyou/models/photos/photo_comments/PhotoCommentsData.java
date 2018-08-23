package linkyou.ru.linkyou.models.photos.photo_comments;

import com.google.gson.annotations.SerializedName;

public class PhotoCommentsData{

	@SerializedName("datetime")
	private String datetime;

	@SerializedName("deleted")
	private int deleted;

	@SerializedName("photo_id")
	private int photoId;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("comment")
	private String comment;

	@SerializedName("id")
	private int id;

	@SerializedName("user")
	private User user;

	public void setDatetime(String datetime){
		this.datetime = datetime;
	}

	public String getDatetime(){
		return datetime;
	}

	public void setDeleted(int deleted){
		this.deleted = deleted;
	}

	public int getDeleted(){
		return deleted;
	}

	public void setPhotoId(int photoId){
		this.photoId = photoId;
	}

	public int getPhotoId(){
		return photoId;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setComment(String comment){
		this.comment = comment;
	}

	public String getComment(){
		return comment;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}
}
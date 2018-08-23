package linkyou.ru.linkyou.models.photos.user_photo;

import com.google.gson.annotations.SerializedName;

public class UserPhotoData{

	@SerializedName("datetime")
	private String datetime;

	@SerializedName("deleted")
	private int deleted;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("src")
	private Src src;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private String id;

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

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setSrc(Src src){
		this.src = src;
	}

	public Src getSrc(){
		return src;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}
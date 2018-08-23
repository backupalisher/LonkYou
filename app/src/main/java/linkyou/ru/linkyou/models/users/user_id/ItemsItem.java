package linkyou.ru.linkyou.models.users.user_id;

import com.google.gson.annotations.SerializedName;

public class ItemsItem{

	@SerializedName("is_private")
	private boolean isPrivate;

	@SerializedName("datetime")
	private String datetime;

	@SerializedName("shown")
	private boolean shown;

	@SerializedName("src")
	private String src;

	@SerializedName("name")
	private String name;

	@SerializedName("comment")
	private String comment;

	@SerializedName("id")
	private int id;

	@SerializedName("from_user_id")
	private int fromUserId;

	public void setIsPrivate(boolean isPrivate){
		this.isPrivate = isPrivate;
	}

	public boolean isIsPrivate(){
		return isPrivate;
	}

	public void setDatetime(String datetime){
		this.datetime = datetime;
	}

	public String getDatetime(){
		return datetime;
	}

	public void setShown(boolean shown){
		this.shown = shown;
	}

	public boolean isShown(){
		return shown;
	}

	public void setSrc(String src){
		this.src = src;
	}

	public String getSrc(){
		return src;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
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

	public void setFromUserId(int fromUserId){
		this.fromUserId = fromUserId;
	}

	public int getFromUserId(){
		return fromUserId;
	}
}
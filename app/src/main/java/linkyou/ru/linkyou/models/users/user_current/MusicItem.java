package linkyou.ru.linkyou.models.users.user_current;

import com.google.gson.annotations.SerializedName;

public class MusicItem{

	@SerializedName("datetime")
	private String datetime;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("link")
	private String link;

	@SerializedName("id")
	private int id;

	@SerializedName("source")
	private String source;

	public void setDatetime(String datetime){
		this.datetime = datetime;
	}

	public String getDatetime(){
		return datetime;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}
}
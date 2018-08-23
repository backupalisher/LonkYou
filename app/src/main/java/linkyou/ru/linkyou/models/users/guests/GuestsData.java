package linkyou.ru.linkyou.models.users.guests;

import com.google.gson.annotations.SerializedName;

public class GuestsData{

	@SerializedName("datetime")
	private String datetime;

	@SerializedName("user")
	private User user;

	public void setDatetime(String datetime){
		this.datetime = datetime;
	}

	public String getDatetime(){
		return datetime;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}
}
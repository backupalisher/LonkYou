package linkyou.ru.linkyou.models.users.user_current;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Interests{

	@SerializedName("id")
	private int id;

	@SerializedName("interests")
	private List<String> interests;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setInterests(List<String> interests){
		this.interests = interests;
	}

	public List<String> getInterests(){
		return interests;
	}
}
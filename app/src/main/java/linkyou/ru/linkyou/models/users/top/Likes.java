package linkyou.ru.linkyou.models.users.top;

import com.google.gson.annotations.SerializedName;

public class Likes{

	@SerializedName("count")
	private String count;

	@SerializedName("is_liked")
	private boolean isLiked;

	public void setCount(String count){
		this.count = count;
	}

	public String getCount(){
		return count;
	}

	public void setIsLiked(boolean isLiked){
		this.isLiked = isLiked;
	}

	public boolean isIsLiked(){
		return isLiked;
	}
}
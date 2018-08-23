package linkyou.ru.linkyou.models.users.user_current;

import com.google.gson.annotations.SerializedName;

public class Likes{

	@SerializedName("count")
	private int count;

	@SerializedName("is_liked")
	private boolean isLiked;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setIsLiked(boolean isLiked){
		this.isLiked = isLiked;
	}

	public boolean isIsLiked(){
		return isLiked;
	}
}
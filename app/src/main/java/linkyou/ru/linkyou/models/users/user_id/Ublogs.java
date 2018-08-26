package linkyou.ru.linkyou.models.users.user_id;

import com.google.gson.annotations.SerializedName;

public class Ublogs{

	@SerializedName("last")
	private Last last;

	@SerializedName("count")
	private int count;

	public void setLast(Last last){
		this.last = last;
	}

	public Last getLast(){
		return last;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}
}
package linkyou.ru.linkyou.models.users.user_id;

import com.google.gson.annotations.SerializedName;

public class Age{

	@SerializedName("from")
	private int from;

	@SerializedName("to")
	private int to;

	public void setFrom(int from){
		this.from = from;
	}

	public int getFrom(){
		return from;
	}

	public void setTo(int to){
		this.to = to;
	}

	public int getTo(){
		return to;
	}
}
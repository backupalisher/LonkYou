package linkyou.ru.linkyou.models.users.user_id_short;

import com.google.gson.annotations.SerializedName;

public class Avatar{

	@SerializedName("small")
	private String small;

	@SerializedName("default")
	private String jsonMemberDefault;

	@SerializedName("origin")
	private String origin;

	public void setSmall(String small){
		this.small = small;
	}

	public String getSmall(){
		return small;
	}

	public void setJsonMemberDefault(String jsonMemberDefault){
		this.jsonMemberDefault = jsonMemberDefault;
	}

	public String getJsonMemberDefault(){
		return jsonMemberDefault;
	}

	public void setOrigin(String origin){
		this.origin = origin;
	}

	public String getOrigin(){
		return origin;
	}
}
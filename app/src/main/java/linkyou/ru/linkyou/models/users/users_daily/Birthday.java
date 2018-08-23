package linkyou.ru.linkyou.models.users.users_daily;

import com.google.gson.annotations.SerializedName;

public class Birthday{

	@SerializedName("age")
	private String age;

	public void setAge(String age){
		this.age = age;
	}

	public String getAge(){
		return age;
	}
}
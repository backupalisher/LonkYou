package linkyou.ru.linkyou.models.users.user_id_short;

import com.google.gson.annotations.SerializedName;

public class Birthday{

	@SerializedName("age")
	private int age;

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}
}
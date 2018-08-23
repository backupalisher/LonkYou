package linkyou.ru.linkyou.models.photos.photo_comments;

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
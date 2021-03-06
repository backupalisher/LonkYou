package linkyou.ru.linkyou.models.users.user_current;

import com.google.gson.annotations.SerializedName;

public class Birthday{

	@SerializedName("age")
	private String age;

	@SerializedName("date")
	private String date;

	@SerializedName("zodiac")
	private Zodiac zodiac;

	public void setAge(String age){
		this.age = age;
	}

	public String getAge(){
		return age;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setZodiac(Zodiac zodiac){
		this.zodiac = zodiac;
	}

	public Zodiac getZodiac(){
		return zodiac;
	}
}
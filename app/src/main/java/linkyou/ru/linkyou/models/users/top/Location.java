package linkyou.ru.linkyou.models.users.top;

import com.google.gson.annotations.SerializedName;

public class Location{

	@SerializedName("city_name")
	private String cityName;

	@SerializedName("country_name")
	private String countryName;

	public void setCityName(String cityName){
		this.cityName = cityName;
	}

	public String getCityName(){
		return cityName;
	}

	public void setCountryName(String countryName){
		this.countryName = countryName;
	}

	public String getCountryName(){
		return countryName;
	}
}
package linkyou.ru.linkyou.models.users.user_id_short;

import com.google.gson.annotations.SerializedName;

public class Job{

	@SerializedName("profession")
	private String profession;

	@SerializedName("occupation")
	private String occupation;

	public void setProfession(String profession){
		this.profession = profession;
	}

	public String getProfession(){
		return profession;
	}

	public void setOccupation(String occupation){
		this.occupation = occupation;
	}

	public String getOccupation(){
		return occupation;
	}
}
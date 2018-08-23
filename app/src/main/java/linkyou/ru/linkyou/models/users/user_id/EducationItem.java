package linkyou.ru.linkyou.models.users.user_id;

import com.google.gson.annotations.SerializedName;

public class EducationItem{

	@SerializedName("speciality")
	private Speciality speciality;

	@SerializedName("institution")
	private Institution institution;

	@SerializedName("deleted")
	private boolean deleted;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("last_update")
	private String lastUpdate;

	@SerializedName("active")
	private boolean active;

	@SerializedName("id")
	private int id;

	@SerializedName("education_type")
	private EducationType educationType;

	public void setSpeciality(Speciality speciality){
		this.speciality = speciality;
	}

	public Speciality getSpeciality(){
		return speciality;
	}

	public void setInstitution(Institution institution){
		this.institution = institution;
	}

	public Institution getInstitution(){
		return institution;
	}

	public void setDeleted(boolean deleted){
		this.deleted = deleted;
	}

	public boolean isDeleted(){
		return deleted;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setLastUpdate(String lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdate(){
		return lastUpdate;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEducationType(EducationType educationType){
		this.educationType = educationType;
	}

	public EducationType getEducationType(){
		return educationType;
	}
}
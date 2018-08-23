package linkyou.ru.linkyou.models.users.user_current;

import com.google.gson.annotations.SerializedName;

public class Job{

	@SerializedName("profession")
	private String profession;

	@SerializedName("pros")
	private String pros;

	@SerializedName("achievements")
	private String achievements;

	@SerializedName("occupation")
	private String occupation;

	@SerializedName("profession_id")
	private String professionId;

	@SerializedName("company_name")
	private String companyName;

	@SerializedName("occupation_id")
	private String occupationId;

	@SerializedName("id")
	private int id;

	@SerializedName("finance")
	private Finance finance;

	@SerializedName("cons")
	private String cons;

	public void setProfession(String profession){
		this.profession = profession;
	}

	public String getProfession(){
		return profession;
	}

	public void setPros(String pros){
		this.pros = pros;
	}

	public String getPros(){
		return pros;
	}

	public void setAchievements(String achievements){
		this.achievements = achievements;
	}

	public String getAchievements(){
		return achievements;
	}

	public void setOccupation(String occupation){
		this.occupation = occupation;
	}

	public String getOccupation(){
		return occupation;
	}

	public void setProfessionId(String professionId){
		this.professionId = professionId;
	}

	public String getProfessionId(){
		return professionId;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return companyName;
	}

	public void setOccupationId(String occupationId){
		this.occupationId = occupationId;
	}

	public String getOccupationId(){
		return occupationId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setFinance(Finance finance){
		this.finance = finance;
	}

	public Finance getFinance(){
		return finance;
	}

	public void setCons(String cons){
		this.cons = cons;
	}

	public String getCons(){
		return cons;
	}
}
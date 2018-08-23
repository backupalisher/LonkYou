package linkyou.ru.linkyou.models.users.user_id;

import com.google.gson.annotations.SerializedName;

public class LanguagesItem{

	@SerializedName("deleted")
	private boolean deleted;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("level")
	private Level level;

	@SerializedName("last_update")
	private String lastUpdate;

	@SerializedName("language")
	private Language language;

	@SerializedName("id")
	private int id;

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

	public void setLevel(Level level){
		this.level = level;
	}

	public Level getLevel(){
		return level;
	}

	public void setLastUpdate(String lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdate(){
		return lastUpdate;
	}

	public void setLanguage(Language language){
		this.language = language;
	}

	public Language getLanguage(){
		return language;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}
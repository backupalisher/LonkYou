package linkyou.ru.linkyou.models.users.user_current;

import com.google.gson.annotations.SerializedName;

public class BooksItem{

	@SerializedName("deleted")
	private boolean deleted;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("author")
	private String author;

	@SerializedName("last_update")
	private String lastUpdate;

	@SerializedName("name")
	private String name;

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

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setLastUpdate(String lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdate(){
		return lastUpdate;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}
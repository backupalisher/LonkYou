package linkyou.ru.linkyou.models.users.user_id;

import com.google.gson.annotations.SerializedName;

public class Language{

	@SerializedName("deleted")
	private boolean deleted;

	@SerializedName("sorting")
	private int sorting;

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

	public void setSorting(int sorting){
		this.sorting = sorting;
	}

	public int getSorting(){
		return sorting;
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
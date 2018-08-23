package linkyou.ru.linkyou.models.users.user_id;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Gifts{

	@SerializedName("free_gifts")
	private int freeGifts;

	@SerializedName("count")
	private int count;

	@SerializedName("items")
	private List<ItemsItem> items;

	public void setFreeGifts(int freeGifts){
		this.freeGifts = freeGifts;
	}

	public int getFreeGifts(){
		return freeGifts;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}
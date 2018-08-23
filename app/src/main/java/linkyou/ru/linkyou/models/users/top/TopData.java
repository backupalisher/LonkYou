package linkyou.ru.linkyou.models.users.top;

import com.google.gson.annotations.SerializedName;

public class TopData{

	@SerializedName("birthday")
	private Birthday birthday;

	@SerializedName("role")
	private int role;

	@SerializedName("is_vip")
	private boolean isVip;

	@SerializedName("avatar")
	private Avatar avatar;

	@SerializedName("is_premium")
	private boolean isPremium;

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private Location location;

	@SerializedName("id")
	private String id;

	@SerializedName("is_top100")
	private boolean isTop100;

	@SerializedName("is_online")
	private boolean isOnline;

	@SerializedName("job")
	private Job job;

	@SerializedName("likes")
	private Likes likes;

	@SerializedName("photos_count")
	private String photosCount;

	public void setBirthday(Birthday birthday){
		this.birthday = birthday;
	}

	public Birthday getBirthday(){
		return birthday;
	}

	public void setRole(int role){
		this.role = role;
	}

	public int getRole(){
		return role;
	}

	public void setIsVip(boolean isVip){
		this.isVip = isVip;
	}

	public boolean isIsVip(){
		return isVip;
	}

	public void setAvatar(Avatar avatar){
		this.avatar = avatar;
	}

	public Avatar getAvatar(){
		return avatar;
	}

	public void setIsPremium(boolean isPremium){
		this.isPremium = isPremium;
	}

	public boolean isIsPremium(){
		return isPremium;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setIsTop100(boolean isTop100){
		this.isTop100 = isTop100;
	}

	public boolean isIsTop100(){
		return isTop100;
	}

	public void setIsOnline(boolean isOnline){
		this.isOnline = isOnline;
	}

	public boolean isIsOnline(){
		return isOnline;
	}

	public void setJob(Job job){
		this.job = job;
	}

	public Job getJob(){
		return job;
	}

	public void setLikes(Likes likes){
		this.likes = likes;
	}

	public Likes getLikes(){
		return likes;
	}

	public void setPhotosCount(String photosCount){
		this.photosCount = photosCount;
	}

	public String getPhotosCount(){
		return photosCount;
	}
}
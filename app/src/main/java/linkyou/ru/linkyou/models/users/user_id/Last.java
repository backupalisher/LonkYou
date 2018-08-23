package linkyou.ru.linkyou.models.users.user_id;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Last{

	@SerializedName("text_short")
	private String textShort;

	@SerializedName("sort")
	private int sort;

	@SerializedName("photos")
	private List<Object> photos;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("likes_count")
	private int likesCount;

	@SerializedName("video_link")
	private Object videoLink;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("audio_link")
	private Object audioLink;

	@SerializedName("comments_count")
	private int commentsCount;

	@SerializedName("last_update")
	private String lastUpdate;

	@SerializedName("id")
	private int id;

	@SerializedName("text")
	private String text;

	@SerializedName("views_count")
	private int viewsCount;

	@SerializedName("user")
	private User user;

	@SerializedName("is_liked")
	private int isLiked;

	public void setTextShort(String textShort){
		this.textShort = textShort;
	}

	public String getTextShort(){
		return textShort;
	}

	public void setSort(int sort){
		this.sort = sort;
	}

	public int getSort(){
		return sort;
	}

	public void setPhotos(List<Object> photos){
		this.photos = photos;
	}

	public List<Object> getPhotos(){
		return photos;
	}

	public void setTags(List<Object> tags){
		this.tags = tags;
	}

	public List<Object> getTags(){
		return tags;
	}

	public void setLikesCount(int likesCount){
		this.likesCount = likesCount;
	}

	public int getLikesCount(){
		return likesCount;
	}

	public void setVideoLink(Object videoLink){
		this.videoLink = videoLink;
	}

	public Object getVideoLink(){
		return videoLink;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setAudioLink(Object audioLink){
		this.audioLink = audioLink;
	}

	public Object getAudioLink(){
		return audioLink;
	}

	public void setCommentsCount(int commentsCount){
		this.commentsCount = commentsCount;
	}

	public int getCommentsCount(){
		return commentsCount;
	}

	public void setLastUpdate(String lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdate(){
		return lastUpdate;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setViewsCount(int viewsCount){
		this.viewsCount = viewsCount;
	}

	public int getViewsCount(){
		return viewsCount;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setIsLiked(int isLiked){
		this.isLiked = isLiked;
	}

	public int getIsLiked(){
		return isLiked;
	}
}
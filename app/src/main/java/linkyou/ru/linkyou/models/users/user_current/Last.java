package linkyou.ru.linkyou.models.users.user_current;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Last{

	@SerializedName("text_short")
	private String textShort;

	@SerializedName("photos")
	private List<Object> photos;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("likes_count")
	private int likesCount;

	@SerializedName("datetime")
	private String datetime;

	@SerializedName("video_link")
	private String videoLink;

	@SerializedName("audio_link")
	private String audioLink;

	@SerializedName("comments_count")
	private int commentsCount;

	@SerializedName("id")
	private int id;

	@SerializedName("text")
	private String text;

	@SerializedName("views_count")
	private int viewsCount;

	@SerializedName("user")
	private User user;

	@SerializedName("is_liked")
	private boolean isLiked;

	public void setTextShort(String textShort){
		this.textShort = textShort;
	}

	public String getTextShort(){
		return textShort;
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

	public void setDatetime(String datetime){
		this.datetime = datetime;
	}

	public String getDatetime(){
		return datetime;
	}

	public void setVideoLink(String videoLink){
		this.videoLink = videoLink;
	}

	public String getVideoLink(){
		return videoLink;
	}

	public void setAudioLink(String audioLink){
		this.audioLink = audioLink;
	}

	public String getAudioLink(){
		return audioLink;
	}

	public void setCommentsCount(int commentsCount){
		this.commentsCount = commentsCount;
	}

	public int getCommentsCount(){
		return commentsCount;
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

	public void setIsLiked(boolean isLiked){
		this.isLiked = isLiked;
	}

	public boolean isIsLiked(){
		return isLiked;
	}
}
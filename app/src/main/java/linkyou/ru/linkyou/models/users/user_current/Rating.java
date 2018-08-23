package linkyou.ru.linkyou.models.users.user_current;

import com.google.gson.annotations.SerializedName;

public class Rating{

	@SerializedName("score")
	private double score;

	@SerializedName("code")
	private String code;

	@SerializedName("views")
	private int views;

	@SerializedName("likes")
	private int likes;

	public void setScore(double score){
		this.score = score;
	}

	public double getScore(){
		return score;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setViews(int views){
		this.views = views;
	}

	public int getViews(){
		return views;
	}

	public void setLikes(int likes){
		this.likes = likes;
	}

	public int getLikes(){
		return likes;
	}
}
package linkyou.ru.linkyou.models.users.user_current;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserCurrentData{

	@SerializedName("birthday")
	private Birthday birthday;

	@SerializedName("pets")
	private List<PetsItem> pets;

	@SerializedName("is_favorited")
	private boolean isFavorited;

	@SerializedName("ublogs")
	private Ublogs ublogs;

	@SerializedName("role")
	private int role;

	@SerializedName("education")
	private List<EducationItem> education;

	@SerializedName("gender")
	private Gender gender;

	@SerializedName("about")
	private String about;

	@SerializedName("rating")
	private Rating rating;

	@SerializedName("last_auth")
	private String lastAuth;

	@SerializedName("music")
	private List<MusicItem> music;

	@SerializedName("children")
	private Children children;

	@SerializedName("smoking")
	private Smoking smoking;

	@SerializedName("id")
	private int id;

	@SerializedName("is_online")
	private boolean isOnline;

	@SerializedName("is_top100")
	private boolean isTop100;

	@SerializedName("relationship")
	private Relationship relationship;

	@SerializedName("height")
	private int height;

	@SerializedName("likes")
	private Likes likes;

	@SerializedName("gifts")
	private Gifts gifts;

	@SerializedName("photos_count")
	private int photosCount;

	@SerializedName("alcohol")
	private Alcohol alcohol;

	@SerializedName("orientation")
	private Orientation orientation;

	@SerializedName("ublogs_count")
	private int ublogsCount;

	@SerializedName("goal")
	private Goal goal;

	@SerializedName("languages")
	private List<LanguagesItem> languages;

	@SerializedName("is_stealth")
	private boolean isStealth;

	@SerializedName("is_invisible")
	private boolean isInvisible;

	@SerializedName("is_vip")
	private boolean isVip;

	@SerializedName("weight")
	private int weight;

	@SerializedName("is_blacklisted")
	private boolean isBlacklisted;

	@SerializedName("end_premium")
	private String endPremium;

	@SerializedName("avatar")
	private Avatar avatar;

	@SerializedName("religion")
	private Religion religion;

	@SerializedName("is_premium")
	private boolean isPremium;

	@SerializedName("books")
	private List<BooksItem> books;

	@SerializedName("nationality")
	private Nationality nationality;

	@SerializedName("looking_for")
	private LookingFor lookingFor;

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private Location location;

	@SerializedName("job")
	private Job job;

	@SerializedName("interests")
	private Interests interests;

	@SerializedName("age")
	private Age age;

	public void setBirthday(Birthday birthday){
		this.birthday = birthday;
	}

	public Birthday getBirthday(){
		return birthday;
	}

	public void setPets(List<PetsItem> pets){
		this.pets = pets;
	}

	public List<PetsItem> getPets(){
		return pets;
	}

	public void setIsFavorited(boolean isFavorited){
		this.isFavorited = isFavorited;
	}

	public boolean isIsFavorited(){
		return isFavorited;
	}

	public void setUblogs(Ublogs ublogs){
		this.ublogs = ublogs;
	}

	public Ublogs getUblogs(){
		return ublogs;
	}

	public void setRole(int role){
		this.role = role;
	}

	public int getRole(){
		return role;
	}

	public void setEducation(List<EducationItem> education){
		this.education = education;
	}

	public List<EducationItem> getEducation(){
		return education;
	}

	public void setGender(Gender gender){
		this.gender = gender;
	}

	public Gender getGender(){
		return gender;
	}

	public void setAbout(String about){
		this.about = about;
	}

	public String getAbout(){
		return about;
	}

	public void setRating(Rating rating){
		this.rating = rating;
	}

	public Rating getRating(){
		return rating;
	}

	public void setLastAuth(String lastAuth){
		this.lastAuth = lastAuth;
	}

	public String getLastAuth(){
		return lastAuth;
	}

	public void setMusic(List<MusicItem> music){
		this.music = music;
	}

	public List<MusicItem> getMusic(){
		return music;
	}

	public void setChildren(Children children){
		this.children = children;
	}

	public Children getChildren(){
		return children;
	}

	public void setSmoking(Smoking smoking){
		this.smoking = smoking;
	}

	public Smoking getSmoking(){
		return smoking;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setIsOnline(boolean isOnline){
		this.isOnline = isOnline;
	}

	public boolean isIsOnline(){
		return isOnline;
	}

	public void setIsTop100(boolean isTop100){
		this.isTop100 = isTop100;
	}

	public boolean isIsTop100(){
		return isTop100;
	}

	public void setRelationship(Relationship relationship){
		this.relationship = relationship;
	}

	public Relationship getRelationship(){
		return relationship;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	public void setLikes(Likes likes){
		this.likes = likes;
	}

	public Likes getLikes(){
		return likes;
	}

	public void setGifts(Gifts gifts){
		this.gifts = gifts;
	}

	public Gifts getGifts(){
		return gifts;
	}

	public void setPhotosCount(int photosCount){
		this.photosCount = photosCount;
	}

	public int getPhotosCount(){
		return photosCount;
	}

	public void setAlcohol(Alcohol alcohol){
		this.alcohol = alcohol;
	}

	public Alcohol getAlcohol(){
		return alcohol;
	}

	public void setOrientation(Orientation orientation){
		this.orientation = orientation;
	}

	public Orientation getOrientation(){
		return orientation;
	}

	public void setUblogsCount(int ublogsCount){
		this.ublogsCount = ublogsCount;
	}

	public int getUblogsCount(){
		return ublogsCount;
	}

	public void setGoal(Goal goal){
		this.goal = goal;
	}

	public Goal getGoal(){
		return goal;
	}

	public void setLanguages(List<LanguagesItem> languages){
		this.languages = languages;
	}

	public List<LanguagesItem> getLanguages(){
		return languages;
	}

	public void setIsStealth(boolean isStealth){
		this.isStealth = isStealth;
	}

	public boolean isIsStealth(){
		return isStealth;
	}

	public void setIsInvisible(boolean isInvisible){
		this.isInvisible = isInvisible;
	}

	public boolean isIsInvisible(){
		return isInvisible;
	}

	public void setIsVip(boolean isVip){
		this.isVip = isVip;
	}

	public boolean isIsVip(){
		return isVip;
	}

	public void setWeight(int weight){
		this.weight = weight;
	}

	public int getWeight(){
		return weight;
	}

	public void setIsBlacklisted(boolean isBlacklisted){
		this.isBlacklisted = isBlacklisted;
	}

	public boolean isIsBlacklisted(){
		return isBlacklisted;
	}

	public void setEndPremium(String endPremium){
		this.endPremium = endPremium;
	}

	public String getEndPremium(){
		return endPremium;
	}

	public void setAvatar(Avatar avatar){
		this.avatar = avatar;
	}

	public Avatar getAvatar(){
		return avatar;
	}

	public void setReligion(Religion religion){
		this.religion = religion;
	}

	public Religion getReligion(){
		return religion;
	}

	public void setIsPremium(boolean isPremium){
		this.isPremium = isPremium;
	}

	public boolean isIsPremium(){
		return isPremium;
	}

	public void setBooks(List<BooksItem> books){
		this.books = books;
	}

	public List<BooksItem> getBooks(){
		return books;
	}

	public void setNationality(Nationality nationality){
		this.nationality = nationality;
	}

	public Nationality getNationality(){
		return nationality;
	}

	public void setLookingFor(LookingFor lookingFor){
		this.lookingFor = lookingFor;
	}

	public LookingFor getLookingFor(){
		return lookingFor;
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

	public void setJob(Job job){
		this.job = job;
	}

	public Job getJob(){
		return job;
	}

	public void setInterests(Interests interests){
		this.interests = interests;
	}

	public Interests getInterests(){
		return interests;
	}

	public void setAge(Age age){
		this.age = age;
	}

	public Age getAge(){
		return age;
	}
}
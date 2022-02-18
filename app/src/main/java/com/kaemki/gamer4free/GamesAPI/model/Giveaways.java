package com.kaemki.gamer4free.GamesAPI.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Giveaways implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("worth")
    @Expose
    private String worth;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("instructions")
    @Expose
    private String instructions;
    @SerializedName("open_giveaway_url")
    @Expose
    private String openGiveawayUrl;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("platforms")
    @Expose
    private String platforms;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("users")
    @Expose
    private Integer users;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("gamerpower_url")
    @Expose
    private String gamerpowerUrl;
    @SerializedName("open_giveaway")
    @Expose
    private String openGiveaway;
    private final static long serialVersionUID = -2793284148543311817L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Giveaways() {
    }

    /**
     *
     * @param image
     * @param instructions
     * @param thumbnail
     * @param endDate
     * @param description
     * @param title
     * @param type
     * @param gamerpowerUrl
     * @param users
     * @param worth
     * @param platforms
     * @param openGiveaway
     * @param id
     * @param openGiveawayUrl
     * @param publishedDate
     * @param status
     */
    public Giveaways(Integer id, String title, String worth, String thumbnail, String image, String description, String instructions, String openGiveawayUrl, String publishedDate, String type, String platforms, String endDate, Integer users, String status, String gamerpowerUrl, String openGiveaway) {
        super();
        this.id = id;
        this.title = title;
        this.worth = worth;
        this.thumbnail = thumbnail;
        this.image = image;
        this.description = description;
        this.instructions = instructions;
        this.openGiveawayUrl = openGiveawayUrl;
        this.publishedDate = publishedDate;
        this.type = type;
        this.platforms = platforms;
        this.endDate = endDate;
        this.users = users;
        this.status = status;
        this.gamerpowerUrl = gamerpowerUrl;
        this.openGiveaway = openGiveaway;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWorth() {
        return worth;
    }

    public void setWorth(String worth) {
        this.worth = worth;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getOpenGiveawayUrl() {
        return openGiveawayUrl;
    }

    public void setOpenGiveawayUrl(String openGiveawayUrl) {
        this.openGiveawayUrl = openGiveawayUrl;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGamerpowerUrl() {
        return gamerpowerUrl;
    }

    public void setGamerpowerUrl(String gamerpowerUrl) {
        this.gamerpowerUrl = gamerpowerUrl;
    }

    public String getOpenGiveaway() {
        return openGiveaway;
    }

    public void setOpenGiveaway(String openGiveaway) {
        this.openGiveaway = openGiveaway;
    }

}

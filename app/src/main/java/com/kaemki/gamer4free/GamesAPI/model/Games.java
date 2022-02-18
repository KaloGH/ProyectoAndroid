
package com.kaemki.gamer4free.GamesAPI.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Games implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("game_url")
    @Expose
    private String gameUrl;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("developer")
    @Expose
    private String developer;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("freetogame_profile_url")
    @Expose
    private String freetogameProfileUrl;
    private final static long serialVersionUID = -6004784781240286399L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Games() {
    }

    /**
     *
     * @param thumbnail
     * @param releaseDate
     * @param genre
     * @param publisher
     * @param gameUrl
     * @param developer
     * @param id
     * @param shortDescription
     * @param title
     * @param platform
     * @param freetogameProfileUrl
     */
    public Games(Integer id, String title, String thumbnail, String shortDescription, String gameUrl, String genre, String platform, String publisher, String developer, String releaseDate, String freetogameProfileUrl) {
        super();
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.shortDescription = shortDescription;
        this.gameUrl = gameUrl;
        this.genre = genre;
        this.platform = platform;
        this.publisher = publisher;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.freetogameProfileUrl = freetogameProfileUrl;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFreetogameProfileUrl() {
        return freetogameProfileUrl;
    }

    public void setFreetogameProfileUrl(String freetogameProfileUrl) {
        this.freetogameProfileUrl = freetogameProfileUrl;
    }



}
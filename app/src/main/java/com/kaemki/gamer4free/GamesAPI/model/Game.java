
package com.kaemki.gamer4free.GamesAPI.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
// ==========================  GAME CLASS ===============================
public class Game implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("description")
    @Expose
    private String description;
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
    @SerializedName("minimum_system_requirements")
    @Expose
    private MinimumSystemRequirements minimumSystemRequirements;
    @SerializedName("screenshots")
    @Expose
    private List<Screenshot> screenshots = null;
    private final static long serialVersionUID = -2854593118300629203L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Game() {}

    /**
     *
     * @param thumbnail
     * @param releaseDate
     * @param description
     * @param gameUrl
     * @param shortDescription
     * @param title
     * @param platform
     * @param screenshots
     * @param genre
     * @param publisher
     * @param developer
     * @param id
     * @param freetogameProfileUrl
     * @param status
     * @param minimumSystemRequirements
     */
    public Game(Integer id, String title, String thumbnail, String status, String shortDescription, String description, String gameUrl, String genre, String platform, String publisher, String developer, String releaseDate, String freetogameProfileUrl, MinimumSystemRequirements minimumSystemRequirements, List<Screenshot> screenshots) {
        super();
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.status = status;
        this.shortDescription = shortDescription;
        this.description = description;
        this.gameUrl = gameUrl;
        this.genre = genre;
        this.platform = platform;
        this.publisher = publisher;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.freetogameProfileUrl = freetogameProfileUrl;
        this.minimumSystemRequirements = minimumSystemRequirements;
        this.screenshots = screenshots;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public MinimumSystemRequirements getMinimumSystemRequirements() {
        return minimumSystemRequirements;
    }

    public void setMinimumSystemRequirements(MinimumSystemRequirements minimumSystemRequirements) {
        this.minimumSystemRequirements = minimumSystemRequirements;
    }

    public List<Screenshot> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(List<Screenshot> screenshots) {
        this.screenshots = screenshots;
    }

    //==============================================================================================
    // ==========================  MINIMUM SYSTEM REQUIREMENTS CLASS ===============================

    public class MinimumSystemRequirements implements Serializable {

        @SerializedName("os")
        @Expose
        private String os;
        @SerializedName("processor")
        @Expose
        private String processor;
        @SerializedName("memory")
        @Expose
        private String memory;
        @SerializedName("graphics")
        @Expose
        private String graphics;
        @SerializedName("storage")
        @Expose
        private String storage;
        private final static long serialVersionUID = -2425176103478595261L;

        /**
         * No args constructor for use in serialization
         *
         */
        public MinimumSystemRequirements() {
        }

        /**
         *
         * @param memory
         * @param os
         * @param graphics
         * @param storage
         * @param processor
         */
        public MinimumSystemRequirements(String os, String processor, String memory, String graphics, String storage) {
            super();
            this.os = os;
            this.processor = processor;
            this.memory = memory;
            this.graphics = graphics;
            this.storage = storage;
        }

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getProcessor() {
            return processor;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
        }

        public String getMemory() {
            return memory;
        }

        public void setMemory(String memory) {
            this.memory = memory;
        }

        public String getGraphics() {
            return graphics;
        }

        public void setGraphics(String graphics) {
            this.graphics = graphics;
        }

        public String getStorage() {
            return storage;
        }

        public void setStorage(String storage) {
            this.storage = storage;
        }

    }
    //==============================================================================================
    // ============================== SCREENSHOT CLASS ============================================
    public class Screenshot implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("image")
        @Expose
        private String image;
        private final static long serialVersionUID = -6949196945997983336L;

        /**
         * No args constructor for use in serialization
         *
         */
        public Screenshot() {}

        /**
         *
         * @param image
         * @param id
         */
        public Screenshot(Integer id, String image) {
            super();
            this.id = id;
            this.image = image;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    }
    //==============================================================================================
}



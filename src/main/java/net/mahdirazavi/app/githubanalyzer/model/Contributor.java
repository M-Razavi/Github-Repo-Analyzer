package net.mahdirazavi.app.githubanalyzer.model;

import java.io.Serializable;

/**
 * <h1>Contributor</h1>
 * The Contributor who commit changes to {@link org.eclipse.egit.github.core.Repository}
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 6/13/2019
 */


public class Contributor implements Serializable {
    private int contributions;
    private int id;
    private String avatarUrl;
    private String login;
    private String name;
    private String type;
    private String url;
    private String email;
    private String date;

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets contributions.
     *
     * @return the contributions
     */
    public int getContributions() {
        return this.contributions;
    }

    /**
     * Sets contributions.
     *
     * @param contributions the contributions
     * @return the contributions
     */
    public Contributor setContributions(int contributions) {
        this.contributions = contributions;
        return this;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     * @return the id
     */
    public Contributor setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Gets avatar url.
     *
     * @return the avatar url
     */
    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    /**
     * Sets avatar url.
     *
     * @param avatarUrl the avatar url
     * @return the avatar url
     */
    public Contributor setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Sets login.
     *
     * @param login the login
     * @return the login
     */
    public Contributor setLogin(String login) {
        this.login = login;
        return this;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     * @return the name
     */
    public Contributor setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     * @return the type
     */
    public Contributor setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     * @return the url
     */
    public Contributor setUrl(String url) {
        this.url = url;
        return this;
    }
}

package net.mahdirazavi.app.githubanalyzer.model;



import java.io.Serializable;
import java.util.List;

/**
 * <h1>Commit</h1>
 * The Commit of {@link Contributor} for {@link org.eclipse.egit.github.core.Repository}
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 6/13/2019
 */

public class Commit implements Serializable {
    private Contributor author;
    private Contributor committer;
    private int commentCount;
    private List<Commit> parents;
    private String message;
    private String sha;
    private String url;
    private Commit commit;

    /**
     * Gets author.
     *
     * @return the author
     */
    public Contributor getAuthor() {
        return this.author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     * @return the author
     */
    public Commit setAuthor(Contributor author) {
        this.author = author;
        return this;
    }

    /**
     * Gets committer.
     *
     * @return the committer
     */
    public Contributor getCommitter() {
        return this.committer;
    }

    /**
     * Sets committer.
     *
     * @param committer the committer
     * @return the committer
     */
    public Commit setCommitter(Contributor committer) {
        this.committer = committer;
        return this;
    }

    /**
     * Gets comment count.
     *
     * @return the comment count
     */
    public int getCommentCount() {
        return this.commentCount;
    }

    /**
     * Sets comment count.
     *
     * @param commentCount the comment count
     * @return the comment count
     */
    public Commit setCommentCount(int commentCount) {
        this.commentCount = commentCount;
        return this;
    }

    /**
     * Gets parents.
     *
     * @return the parents
     */
    public List<Commit> getParents() {
        return this.parents;
    }

    /**
     * Sets parents.
     *
     * @param parents the parents
     * @return the parents
     */
    public Commit setParents(List<Commit> parents) {
        this.parents = parents;
        return this;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     * @return the message
     */
    public Commit setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Gets sha.
     *
     * @return the sha
     */
    public String getSha() {
        return this.sha;
    }

    /**
     * Sets sha.
     *
     * @param sha the sha
     * @return the sha
     */
    public Commit setSha(String sha) {
        this.sha = sha;
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
    public Commit setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets commit.
     *
     * @return the commit
     */
    public Commit getCommit() {
        return commit;
    }

    /**
     * Sets commit.
     *
     * @param commit the commit
     */
    public void setCommit(Commit commit) {
        this.commit = commit;
    }
}

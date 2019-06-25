package net.mahdirazavi.app.githubanalyzer.model;

import org.eclipse.egit.github.core.Repository;

import java.util.Set;


/**
 * <h1>RepositorySearchResult</h1>
 * The result of searching repositories on Github
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 6/13/2019
 */
public class RepositorySearchResult {
    private int total_count;
    /**
     * The Incomplete results.
     */
    boolean incomplete_results;
    /**
     * The Items.
     */
    Set<Repository> items;

    /**
     * Gets total count.
     *
     * @return the total count
     */
    public int getTotal_count() {
        return total_count;
    }

    /**
     * Sets total count.
     *
     * @param total_count the total count
     */
    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    /**
     * Is incomplete results boolean.
     *
     * @return the boolean
     */
    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    /**
     * Sets incomplete results.
     *
     * @param incomplete_results the incomplete results
     */
    public void setIncomplete_results(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public Set<Repository> getItems() {
        return items;
    }

    /**
     * Sets items.
     *
     * @param items the items
     */
    public void setItems(Set<Repository> items) {
        this.items = items;
    }
}

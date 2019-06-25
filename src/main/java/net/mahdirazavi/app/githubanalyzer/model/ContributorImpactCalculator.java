package net.mahdirazavi.app.githubanalyzer.model;

import java.util.Collection;

/**
 * The interface Contributor impact calculator.
 */
public interface ContributorImpactCalculator {

    /**
     * Calculate contributor impact collection.
     *
     * @param contributors the contributors
     * @param commits      the commits
     * @return the collection
     */
    Collection<ContributorImpact> calculateContributorImpact(Collection<Contributor> contributors, Collection<Commit> commits);
}

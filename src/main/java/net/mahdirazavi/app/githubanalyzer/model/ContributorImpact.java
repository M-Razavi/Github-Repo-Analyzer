package net.mahdirazavi.app.githubanalyzer.model;

import org.eclipse.egit.github.core.Repository;

/**
 * <h1>ContributorImpact</h1>
 * The number of commit that each {@link Contributor} perform on {@link Repository} during a period.
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 6/13/2019
 */
public class ContributorImpact implements ImpactCalculator {
    private int defaultCommitCount = 100;
    private Contributor contributor;
    private int impact;

    /**
     * Instantiates a new Contributor impact.
     *  @param contributor the contributor
     * @param contributeCount the commit count
     * @param commitCount
     */
    public ContributorImpact(Contributor contributor, int contributeCount, int commitCount) {
        this.contributor = contributor;
        if(commitCount < defaultCommitCount){
            defaultCommitCount = commitCount;
        }
        this.impact = calculatedImpact(contributeCount, defaultCommitCount);
    }


    /**
     * Gets impact.
     *
     * @return the impact
     */
    public int getImpact() {
        return impact;
    }

    public int calculatedImpact(int commitCount, int commitSize) {
        return (int) (commitCount / (float)commitSize * 100);
    }

    /**
     * Gets contributor.
     *
     * @return the contributor
     */
    public Contributor getContributor() {
        return contributor;
    }
}

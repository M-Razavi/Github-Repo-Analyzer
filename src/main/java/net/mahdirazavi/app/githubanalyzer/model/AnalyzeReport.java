package net.mahdirazavi.app.githubanalyzer.model;

import java.util.*;

/**
 * <h1>AnalyzeReport</h1>
 * The AnalyzeReport to model the result of analyze
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 6/13/2019
 */
public class AnalyzeReport implements ContributorImpactCalculator {
    private final Collection<Contributor> contributors;
    private final Collection<ContributorImpact> contributorImpacts;
    private final ContributionTimeline contributionTimeline;

    /**
     * Instantiates a new Analyze report.
     *
     * @param contributors the contributors
     * @param commits      the commits
     */
    public AnalyzeReport(Collection<Contributor> contributors, Collection<Commit> commits) {
        this.contributors = contributors;
        contributorImpacts = calculateContributorImpact(contributors, commits);
        this.contributionTimeline = new ContributionTimeline(commits);

    }

    /**
     * Gets contributors.
     *
     * @return the contributors
     */
    public Collection<Contributor> getContributors() {
        return Collections.unmodifiableCollection(contributors);
    }

    /**
     * Gets contributor impacts.
     *
     * @return the contributor impacts
     */
    public Collection<ContributorImpact> getContributorImpacts() {
        return Collections.unmodifiableCollection(contributorImpacts);
    }

    /**
     * Gets contribution timeline.
     *
     * @return the contribution timeline
     */
    public ContributionTimeline getContributionTimeline() {
        return contributionTimeline;
    }

    public Collection<ContributorImpact> calculateContributorImpact(Collection<Contributor> contributors, Collection<Commit> commits) {
        Set<ContributorImpact> contributorImpactSet = new HashSet<>();
        contributors.parallelStream().forEach(contributor -> {
            int contributeCount = (int) (commits.parallelStream().filter(commit -> commit.getAuthor().getLogin().equalsIgnoreCase(contributor.getLogin())).count());
            if (contributeCount > 0) {
                contributorImpactSet.add(new ContributorImpact(contributor, contributeCount,commits.size()));
            }
        });
        return  contributorImpactSet;
    }
}

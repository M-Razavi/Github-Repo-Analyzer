package net.mahdirazavi.app.githubanalyzer.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <h1>ContributionTimeline</h1>
 * The Timeline of all commits per day
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 6 /13/2019
 */
public class ContributionTimeline implements TimeLineCalculator {
    private Map<String, Long> timeLine;

    /**
     * Instantiates a new Contribution timeline.
     *
     * @param commits the commits
     */
    public ContributionTimeline(Collection<Commit> commits) {
        this.timeLine = calculateTimeLine(commits);
    }

    /**
     * Calculate TimeLine with given commits
     * @param commits the commits
     * @return
     */
    public Map<String, Long> calculateTimeLine(Collection<Commit> commits) {
        return commits.parallelStream()
                .map(Commit::getCommit)
                .map(Commit::getAuthor)
                .map(Contributor::getDate)
                .collect(
                        Collectors.groupingBy(
                                t -> LocalDateTime.ofInstant(Instant.parse(t),
                                        ZoneOffset.UTC).toLocalDate().toString(),
                                Collectors.counting()));
    }

    /**
     * Gets time line.
     *
     * @return the time line
     */
    public Map<String, Long> getTimeLine() {
        return Collections.unmodifiableMap(timeLine);
    }
}

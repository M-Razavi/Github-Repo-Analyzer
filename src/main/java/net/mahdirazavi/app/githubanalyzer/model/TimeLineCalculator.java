package net.mahdirazavi.app.githubanalyzer.model;

import java.util.Collection;
import java.util.Map;

/**
 * The interface Time line calculator.
 */
public interface TimeLineCalculator {

    /**
     * Calculate time line map.
     *
     * @param commits the commits
     * @return the map
     */
    Map<String, Long> calculateTimeLine(Collection<Commit> commits);
}

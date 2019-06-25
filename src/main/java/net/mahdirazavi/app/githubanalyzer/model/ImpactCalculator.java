package net.mahdirazavi.app.githubanalyzer.model;

/**
 * The interface Impact calculator.
 */
public interface ImpactCalculator {

    /**
     * Calculated impact int.
     *
     * @param commitCount the commit count
     * @param commitSize  the commit size
     * @return the int
     */
    int calculatedImpact(int commitCount, int commitSize);
}

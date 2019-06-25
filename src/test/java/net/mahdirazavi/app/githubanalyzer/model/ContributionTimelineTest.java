package net.mahdirazavi.app.githubanalyzer.model;

import com.fasterxml.jackson.core.type.TypeReference;
import net.mahdirazavi.app.githubanalyzer.ParentTest;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ContributionTimelineTest extends ParentTest {

    @Test
    public void getTimeLine_calculateCommitTimes_success() throws IOException {
        String commitsJson = IOUtils.toString(
                this.getClass().getResourceAsStream("commits.json"),
                "UTF-8"
        );
        List<Commit> commits = jsonMapper.readValue(commitsJson, new TypeReference<List<Commit>>() {
        });
        ContributionTimeline contributionTimeline = new ContributionTimeline(commits);
        Map<String, Long> timeLine = contributionTimeline.getTimeLine();
        long sum = timeLine.values().stream().mapToLong(i -> i).sum();

        Assert.assertEquals(100, sum);
    }
}
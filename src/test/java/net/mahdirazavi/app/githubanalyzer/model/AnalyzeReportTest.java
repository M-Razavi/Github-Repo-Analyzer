package net.mahdirazavi.app.githubanalyzer.model;

import com.fasterxml.jackson.core.type.TypeReference;
import net.mahdirazavi.app.githubanalyzer.ParentTest;
import org.apache.commons.io.IOUtils;
import org.eclipse.egit.github.core.Repository;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnalyzeReportTest extends ParentTest {

    static Collection<Commit> commits;
    static Collection<Contributor> contributors;
    static Repository repository;


    @BeforeClass
    public static void setupData() throws IOException {
        String commitsJson = IOUtils.toString(
                AnalyzeReportTest.class.getResourceAsStream("commits.json"),
                "UTF-8"
        );
        String contributorsJson = IOUtils.toString(
                AnalyzeReportTest.class.getResourceAsStream("contributors.json"),
                "UTF-8"
        );
        String sampleRepoJson = IOUtils.toString(
                AnalyzeReportTest.class.getResourceAsStream("sample_repository.json"),
                "UTF-8"
        );
        commits = jsonMapper.readValue(commitsJson, new TypeReference<List<Commit>>() {
        });
        contributors = jsonMapper.readValue(contributorsJson, new TypeReference<List<Contributor>>() {
        });
        repository = jsonMapper.readValue(sampleRepoJson, new TypeReference<Repository>() {
        });
    }

    @Test
    public void getAnalyze_checkContributorImpact_success() throws IOException {
        AnalyzeReport analyzeReport = new AnalyzeReport(contributors, commits);
        Collection<ContributorImpact> contributorImpacts = analyzeReport.getContributorImpacts();

        contributorImpacts.stream().forEach(contributorImpact -> {
            long count = commits.stream().filter(commit -> commit.getAuthor().getLogin().equalsIgnoreCase(contributorImpact.getContributor().getLogin())).count();
            assertEquals(count,contributorImpact.getImpact());

        });
    }
}
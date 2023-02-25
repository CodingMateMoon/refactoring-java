package moon.codingmate._01_smell_mysterious_name._03_rename_field;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudyDashboard {

    /*    private Set<String> reviewers = new HashSet<>();
        private Set<String> reviews = new HashSet<>();*/
    private Set<StudyReview> studyReviews = new HashSet<>();

    /**
     * 스터디 리뷰 이슈에 작성되어 있는 리뷰어 목록과 리뷰를 읽어옵니다.
     * @throws IOException
     */
    private void loadReviews() throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(30);

        List<GHIssueComment> reviews = issue.getComments();
        for (GHIssueComment review : reviews) {
            StudyReview studyReview = new StudyReview(review.getUserName(), review.getBody());
//            System.out.println(studyReview.reviewer());
//            System.out.println(studyReview.review());
            studyReviews.add(studyReview);
            // review.getUser().getLogin(); // github API 한번 더 호출하기 때문에 오래걸려서 getUserName 바로 가져오도록 사용했습니다.
        }
    }

    public Set<StudyReview> getStudyReviews() {
        return studyReviews;
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.loadReviews();
//        studyDashboard.getStudyReviews().forEach(studyReview -> System.out.println(studyReview));
        studyDashboard.getStudyReviews().forEach(System.out::println);
        // 출력 : StudyReview[reviewer=asqwklop12, review=솔직히 저는 스스로 자바를 어느정도 잘 안다고 생각했습니다.
    }
}

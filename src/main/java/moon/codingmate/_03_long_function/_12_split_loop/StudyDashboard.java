package moon.codingmate._03_long_function._12_split_loop;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudyDashboard {

    private final int totalNumberOfEvents;
    private final List<Participant> participants;
    private final Participant[] firstParticipantsForEachEvent;

    public StudyDashboard(int totalNumberOfEvents) {
        this.totalNumberOfEvents = totalNumberOfEvents;
        participants = new CopyOnWriteArrayList<>();
        firstParticipantsForEachEvent = new Participant[this.totalNumberOfEvents];
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        StudyDashboard studyDashboard = new StudyDashboard(15);
        studyDashboard.print();
    }

    private void print() throws IOException, InterruptedException {

        
        /*
        멀티스레드 프로그래밍 - 이슈 하나와 그 이슈에 달린 commment 최대 400개를 읽어오는 경우 이슈 15개에 대해 하나의 스레드로 진행하기에는 컴퓨터 리소스가 많이 남고 시간이 오래 걸립니다. 그래서 8개의 스레드를 동시에 돌릴 수 있고  스레드 풀은 8개. 풀에 들어있는 스레드를 가지고 총 15개 스레드를 만든다음 15개의 스레드가 끝날 때마다 countDownLatch 낮추다 다 될때까지 기다렸다가 ExecutorService를 정리하고 print 작업을 합니다.
        List<Participant> participants = new CopyOnWriteArrayList<>();
        동시성 concurrency 여러 스레드에서 하나의 리스트를 수정 - new Participant add . concurrent modification 여러 스레드에서 동시에 변경하면 해당 이슈가 발생가능. concurrent 작업에서 새로운 엘리먼트가 추가될 때 기존에 있는 것을 copy해서 만들기 때문에 concurrent에 안전한 List 입니다.
         */
        checkGithubIssues(getGhRepository());
        new StudyPrinter(this.totalNumberOfEvents, this.participants).execute();
        printFirstParticipants();
    }

    private void checkGithubIssues(GHRepository ghRepository) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(8);
        CountDownLatch latch = new CountDownLatch(totalNumberOfEvents);

        for (int index = 1 ; index <= totalNumberOfEvents ; index++) {
            int eventId = index;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        GHIssue issue = ghRepository.getIssue(eventId);
                        // github API를 쓰기 때문에 성능의 bottleneck
                        List<GHIssueComment> comments = issue.getComments();
                        //for문 내에서 하나의 작업만 하도록 분리, 관련 있는 필드와 구현들을 묶고 해당 반복문을 메서드로 추출 -> checkHomework, findFirst
                        checkHomework(comments, eventId);
                        firstParticipantsForEachEvent[eventId - 1] = findFirst(comments);
                        latch.countDown();
                    } catch (IOException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            });
        }

        latch.await();
        service.shutdown();
    }

    private Participant findFirst(List<GHIssueComment> comments) throws IOException {
        Date firstCreatedAt = null;
        Participant first = null;
        for (GHIssueComment comment : comments) {
            // bottleNeck from github API
            Participant participant = findParticipant(comment.getUserName(), participants);
            if (firstCreatedAt == null || comment.getCreatedAt().before(firstCreatedAt)) {
                firstCreatedAt = comment.getCreatedAt();
                first = participant;
            }
        }
        return first;
    }

    private void checkHomework(List<GHIssueComment> comments, int eventId) {
        for (GHIssueComment comment : comments) {
            // bottleNeck from github API
            Participant participant = findParticipant(comment.getUserName(), participants);
            participant.setHomeworkDone(eventId);
        }
    }

    private void printFirstParticipants() {
        Arrays.stream(this.firstParticipantsForEachEvent).forEach(p -> System.out.println(p.username()));
    }

    private GHRepository getGhRepository() throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        return repository;
    }

    private Participant findParticipant(String username, List<Participant> participants) {
        return isNewParticipant(username, participants) ?
                createNewParticipant(username, participants) :
                findExistingParticipant(username, participants);
    }

    private Participant findExistingParticipant(String username, List<Participant> participants) {
        Participant participant;
        participant = participants.stream().filter(p -> p.username().equals(username)).findFirst().orElseThrow();
        return participant;
    }

    private Participant createNewParticipant(String username, List<Participant> participants) {
        Participant participant;
        participant = new Participant(username);
        participants.add(participant);
        return participant;
    }

    private boolean isNewParticipant(String username, List<Participant> participants) {
        return participants.stream().noneMatch(p -> p.username().equals(username));
    }

}

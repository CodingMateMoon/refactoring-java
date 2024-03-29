package moon.codingmate._13_loop._33_replace_loop_with_pipeline;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorTest {

    @Test
    void twitterHandler() {
        Author keesun = new Author("ms", null);
        Author whiteship = new Author("naver", "whiteship");
        assertEquals(List.of("whiteship"), Author.TwitterHandles(List.of(keesun, whiteship), "naver"));
    }

}
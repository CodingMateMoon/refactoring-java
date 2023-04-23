package moon.codingmate._13_loop._33_replace_loop_with_pipeline;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Author {

    private String company;

    private String twitterHandle;

    public Author(String company, String twitterHandle) {
        this.company = company;
        this.twitterHandle = twitterHandle;
    }

    /*
    collection pipeline operation. collection을 처리하는 operation 위주로 의미를 파악할 수 있어서 명확해집니다.
     */
    static public List<String> TwitterHandles(List<Author> authors, String company) {
        // filter 내 요소 Author는 좁은 scope 이기 때문에 변수의 이름은 author->a 임의로 바꾸고 지정할 수 있습니다.
        return authors.stream().filter(a -> a.company.equals(company))
                // Author-> Author의 필드 twitterHandle로 변환
                .map(author-> author.twitterHandle)
                // twitterHandle -> 문자열이 null이 아닌 경우 필터 .filter(handle -> handle != null)
                .filter(Objects::nonNull)
                // 해당값들 수집
                .collect(Collectors.toList());

        /*
        authors.stream().filter(new Predicate<Author>() {
            @Override
            public boolean test(Author author) {
                return author.company.equals(company);
            }
        })
         */

        /*
        var result = new ArrayList<String> ();
        for (Author a : authors) {
            if (a.company.equals(company)) {
                var handle = a.twitterHandle;
                if (handle != null)
                    result.add(handle);
            }
        }
        return result;
         */
    }

}

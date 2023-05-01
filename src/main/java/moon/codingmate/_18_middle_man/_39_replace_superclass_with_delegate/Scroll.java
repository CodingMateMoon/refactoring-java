package moon.codingmate._18_middle_man._39_replace_superclass_with_delegate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

// 스크롤 주기적 청소. 아이템이지 카테고리는 아닙니다. 더 이상 상속 구조를 유지하기 어렵겠다고 판단할 경우
//public class Scroll extends CategoryItem {
public class Scroll  {

    private LocalDate dateLastCleaned;

    //상위 타입을 필드로 선언
    private CategoryItem categoryItem;

    public Scroll(Integer id, String title, List<String> tags, LocalDate dateLastCleaned) {
        //super(id, title, tags);
        this.dateLastCleaned = dateLastCleaned;
        this.categoryItem = new CategoryItem(id, title, tags);
    }

    public long daysSinceLastCleaning(LocalDate targetDate) {
        return this.dateLastCleaned.until(targetDate, ChronoUnit.DAYS);
    }
}

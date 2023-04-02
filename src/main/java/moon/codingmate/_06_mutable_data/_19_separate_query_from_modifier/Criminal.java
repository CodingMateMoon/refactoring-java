package moon.codingmate._06_mutable_data._19_separate_query_from_modifier;

import java.util.List;

public class Criminal {

    // Don, John 찾으면 알람만 끄기 : Modifier
    public void alertForMiscreant(List<Person> people) {
        if(!findMiscreant(people).isBlank())
            setOffAlarms();
    }

    // 조회 : Query
    public String findMiscreant(List<Person> people) {
        for (Person p : people) {
            if (p.getName().equals("Don")) {
                setOffAlarms();
                return "Don";
            }

            if (p.getName().equals("John")) {
                setOffAlarms();
                return "John";
            }
        }

        return "";
    }

    private void setOffAlarms() {
        System.out.println("set off alarm");
    }
}

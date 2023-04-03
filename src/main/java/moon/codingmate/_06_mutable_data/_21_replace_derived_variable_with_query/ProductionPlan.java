package moon.codingmate._06_mutable_data._21_replace_derived_variable_with_query;

import java.util.ArrayList;
import java.util.List;

public class ProductionPlan {

    private double production;
    private List<Double> adjustments = new ArrayList<>();

    public void applyAdjustment(double adjustment) {
        this.adjustments.add(adjustment);
//        this.production += adjustment;
    }

    /* (1) this.production += adjustment+ 로 production값을 구하는 방식을 calculatedProduction 함수로 구하도록 변경
    public double getProduction() {
        assert this.production == calculatedProduction();
        return this.production;
    }

    private double calculatedProduction() {
        // identity 초기값이 있고 2개의 값을 받아서 합을 계산.
        //return this.adjustments.stream().reduce((double) 0, (a, b) -> a + b);
//        return this.adjustments.stream().reduce((double) 0, Double::sum);
        return this.adjustments.stream().mapToDouble(Double::valueOf).sum();
    }
     */
    // (2) Inline Method(CTLR+ALT+N) : calculatedProduction 계산 함수 호출값 return에서 람다식 return 방식으로 변경
    public double getProduction() {
        // identity 초기값이 있고 2개의 값을 받아서 합을 계산.
        //return this.adjustments.stream().reduce((double) 0, (a, b) -> a + b);
//        return this.adjustments.stream().reduce((double) 0, Double::sum);
        // derived variable -> 값을 리턴하는 함수, 조회하는 함수 query로 변환
        return this.adjustments.stream().mapToDouble(Double::valueOf).sum();
    }
}

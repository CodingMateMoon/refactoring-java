package moon.codingmate._18_middle_man._40_replace_subclass_with_delegate;

import java.time.LocalDateTime;

public class PremiumBooking extends Booking {

    private PremiumExtra extra;

    public PremiumBooking(Show show, LocalDateTime time, PremiumExtra extra) {
        super(show, time);
        this.extra = extra;
    }

    /*
    @Override
    public boolean hasTalkback() {
//        return this.show.hasOwnProperty("talkback");
        // 실제 로직은 전부 PremiumDelegate에서 수행하고 있습니다.
        return this.premiumDelegate.hasTalkback();
    }
     */

    /*
    @Override
    public double basePrice() {
        return Math.round(super.basePrice() + this.extra.getPremiumFee());
    }
     */

    /* Pull Members Up1
    public boolean hasDinner() {
        return this.extra.hasOwnProperty("dinner") && !this.isPeakDay();
    }
     */

}

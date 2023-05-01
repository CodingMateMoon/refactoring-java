package moon.codingmate._18_middle_man._40_replace_subclass_with_delegate;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Booking {

    protected Show show;

    protected LocalDateTime time;

    protected PremiumDelegate premiumDelegate;

    public Booking(Show show, LocalDateTime time) {
        this.show = show;
        this.time = time;
    }

    /*
    생성자 메서드의 경우 클래스의 이름과 같아야하고 다양하게 표현이 어렵습니다. static한 factory 메서드의 경우 자유롭게 이름을 표현하는 것이 가능합니다.
    return하는 객체 타입이 더 자유롭습니다. Booking 뿐만 아니라 서브클래스인 PremiumBooking을 return하는 것이 가능합니다.
     */
    public static Booking createBooking(Show show, LocalDateTime time) {
        return new Booking(show, time);
    }

    public static Booking createPremiumBooking(Show show, LocalDateTime time, PremiumExtra extra) {
        Booking booking = createBooking(show, time);
//        PremiumBooking booking = new PremiumBooking(show, time, extra);
        booking.premiumDelegate = new PremiumDelegate(booking, extra);
        return booking;
    }

    public boolean hasTalkback() {

        return (this.premiumDelegate != null) ? this.premiumDelegate.hasTalkback() : this.show.hasOwnProperty("talkback") && !this.isPeakDay();
    }

    protected boolean isPeakDay() {
        DayOfWeek dayOfWeek = this.time.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public double basePrice() {
        double result = this.show.getPrice();
        if (this.isPeakDay()) result += Math.round(result * 0.15);
        return (this.premiumDelegate != null) ? this.premiumDelegate.extendBasePrice(result) : result;
    }

    public boolean hasDinner() {
        //return this.extra.hasOwnProperty("dinner") && !this.isPeakDay();
        return this.premiumDelegate != null && this.premiumDelegate.hasDinner();
    }
}

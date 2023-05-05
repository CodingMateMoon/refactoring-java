package moon.codingmate._21_alternative_classes_with_different_interfaces;

public class OrderAlerts {

//    private AlertService alertService;

    // 어떤 NotificationSerivce를 넘겨주냐에 따라 핸드폰, 이메일 등 알림 전송
    public OrderAlerts(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    private NotificationService notificationService;

    // order 만들면 Noti. OrderProcessor와 비슷한 API. AlertService는 add() EmailService는 sendEmail() 메서드를 사용하는 인터페이스
    public void alertShipped(Order order) {
        Notification notification = Notification.newNotification(order.toString() + " is shipped")
                .receiver(order.getEmail());
        notificationService.sendNotification(notification);
    }

}

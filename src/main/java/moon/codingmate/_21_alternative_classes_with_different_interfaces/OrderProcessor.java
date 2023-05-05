package moon.codingmate._21_alternative_classes_with_different_interfaces;

public class OrderProcessor {

//    private EmailService emailService;
    private NotificationService notificationService;

    public OrderProcessor(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // 이메일 보내서 shipping 정보 전송
    public void notifyShipping(Shipping shipping) {
        Notification notification = Notification.newNotification(shipping.getOrder() + " is shipped")
                .receiver(shipping.getEmail())
                .sender("no-reply@whiteship.com");
        notificationService.sendNotification(notification);
    }

}

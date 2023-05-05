package moon.codingmate._21_alternative_classes_with_different_interfaces;

// 추상화를 하나 더 올린 것. 기존의 다른 두 인터페이스 비슷한 기능을 제공하는 부분에 대해 NoticationService라는 인터페이스의 구현체로 감싸기.
public class EmailNotificationService implements NotificationService{

    private  EmailService emailService;
    @Override
    public void sendNotification(Notification notification) {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTitle(notification.getTitle());
        emailMessage.setTo(notification.getReceiver());
        emailMessage.setFrom(notification.getSender());
        emailService.sendEmail(emailMessage);
    }
}

package moon.codingmate._21_alternative_classes_with_different_interfaces;

public interface NotificationService {
    // 추상 계층을 하나 만들어 기존 API를 감싸기
    public void sendNotification(Notification notification);
}

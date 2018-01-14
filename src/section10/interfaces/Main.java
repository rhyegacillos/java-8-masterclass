package section10.interfaces;

public class Main {
    public static void main(String[] args) {
        ITelephone timsPhone = new DeskPhone(12324343);
        timsPhone.powerOn();
        timsPhone.callPhone(12324343);
        timsPhone.answer();

        timsPhone = new MobilePhone(123456);
        timsPhone.powerOn();
        timsPhone.callPhone(123456);
        timsPhone.answer();
    }
}

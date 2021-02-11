package food2door.supplier.service;

public interface InformationService {

    void sendOrderConfirmation(UserInterface user);

    void sendRejectInformation(UserInterface user);
}

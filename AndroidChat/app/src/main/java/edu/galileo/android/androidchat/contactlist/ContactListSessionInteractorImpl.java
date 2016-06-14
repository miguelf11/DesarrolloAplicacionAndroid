package edu.galileo.android.androidchat.contactlist;

/**
 * Created by Alex on 14-06-2016.
 */
public class ContactListSessionInteractorImpl implements ContactListSessionInteractor {

    ContactListRepository repository;

    public ContactListSessionInteractorImpl() {
        repository = new ContactListRepositoryImpl();
    }

    @Override
    public void signOff() {
        repository.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return repository.getCurrentUserEmail();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        repository.changeConnectionStatus(online);

    }
}

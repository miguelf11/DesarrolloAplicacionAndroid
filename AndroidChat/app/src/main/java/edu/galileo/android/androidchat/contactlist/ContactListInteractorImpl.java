package edu.galileo.android.androidchat.contactlist;

/**
 * Created by Alex on 14-06-2016.
 */
public class ContactListInteractorImpl implements ContactListInteractor {

    ContactListRepository repository;

    public ContactListInteractorImpl() {
        repository = new ContactListRepositoryImpl();
    }

    @Override
    public void subscribe() {
        repository.subscribeToContactListEvents();
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribeToContactListEvents();
    }

    @Override
    public void destroyListener() {
        repository.destroyListener();
    }

    @Override
    public void removeContact(String email) {
        repository.removeContact(email);
    }
}

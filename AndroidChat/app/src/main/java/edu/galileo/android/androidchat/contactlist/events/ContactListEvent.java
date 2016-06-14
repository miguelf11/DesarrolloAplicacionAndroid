package edu.galileo.android.androidchat.contactlist.events;

import edu.galileo.android.androidchat.entities.User;

/**
 * Created by Alex on 12-06-2016.
 */
public class ContactListEvent {
    public final static int onContactAdded = 0;
    public final static int onContactChanged = 1;
    public final static int onContactRemoved = 2;

    private User user;
    private int evenType;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEvenType() {
        return evenType;
    }

    public void setEvenType(int evenType) {
        this.evenType = evenType;
    }


}

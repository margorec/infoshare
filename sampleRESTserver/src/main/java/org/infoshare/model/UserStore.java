package org.infoshare.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class UserStore {

    private Logger LOG = LoggerFactory.getLogger(UserStore.class);

    public Map<Integer, User> getBase() {
        return base;
    }

    Map<Integer, User> base;

    public UserStore() {
        base = new HashMap<Integer, User>();
        User user1 = new User("Adam", "Iksinski", null);
        User user2 = new User("Karol", "Ygrekowski", null);
        base.put(user1.getId(), user1);
        base.put(user2.getId(), user2);
    }

    public void add(User user) {
        LOG.info("Adding to store: " + user.toString());
        base.put(user.getId(), user);

    }
}

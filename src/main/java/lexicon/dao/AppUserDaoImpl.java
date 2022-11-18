package lexicon.dao;

import lexicon.dao.AppUserDao;
import lexicon.model.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserDaoImpl implements AppUserDao {

    private final List<AppUser> userStorage;

    public AppUserDaoImpl() {
        userStorage = new ArrayList<>();
    }

    @Override
    public AppUser create(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("App user was null");
        AppUser result = findByUserName(appUser.getUsername());
        if (result != null) throw new IllegalArgumentException("username was duplicate");
        userStorage.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findByUserName(String username) {
        if (username == null) throw new IllegalArgumentException("username was null");
        for (AppUser user : userStorage)
            if (user.getUsername().equalsIgnoreCase(username))
                return user;
        return null;
    }

    @Override
    public List<AppUser> findAll() {
        return userStorage;
    }
}

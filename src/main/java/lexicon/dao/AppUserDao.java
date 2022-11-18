package lexicon.dao;

import lexicon.model.AppUser;

import java.util.List;

public interface AppUserDao {

    AppUser create(AppUser appUser);

    AppUser findByUserName(String username);

    List<AppUser> findAll();
}

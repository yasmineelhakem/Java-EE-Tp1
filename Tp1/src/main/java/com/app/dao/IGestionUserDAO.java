package com.app.dao;

import com.app.metier.User;

public interface IGestionUserDAO {
    User getUserByUsername(String username);
}

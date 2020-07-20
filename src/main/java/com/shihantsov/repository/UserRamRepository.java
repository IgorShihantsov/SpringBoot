package com.shihantsov.repository;

import com.shihantsov.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRamRepository {
    List<User> users = new ArrayList();

    int lastUserId = 0;

    public void addOrUpdate(User user) {
        if (user.getId() == null) {
            lastUserId++;
            user.setId(lastUserId);
            users.add(user);
        } else {
            for (User userFromList : users) {
                if (userFromList.getId().equals(user.getId())) ;
                userFromList.setName(user.getName());
                userFromList.setAge(user.getAge());
                
            }
        }
    }

    public List<User> getAll() {
        return users;
    }

    public void removeByUser(String name) {
        for (int i = 0; i < users.size(); i++)
            if (name.equals(users.get(i).getName()))
                users.remove(i);
    }

    public User getById(Integer id) {
        for (User user : users) {
            if (user.getId().equals(id))
                return user;
        }
        return null;
    }
}

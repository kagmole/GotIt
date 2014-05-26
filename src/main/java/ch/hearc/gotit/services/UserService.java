package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.UserDao;
import ch.hearc.gotit.entities.UserEntity;

public interface UserService extends BasicService<UserEntity, Integer>, UserDao {
}

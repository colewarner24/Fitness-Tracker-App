package fitnesstracker.service;

import fitnesstracker.mapper.UserMapper;
import fitnesstracker.model.User;

public class UserService extends BaseService<User, Integer, UserMapper> {

    @Override
    protected Class<UserMapper> getMapperClass() {
        return UserMapper.class;
    }
}

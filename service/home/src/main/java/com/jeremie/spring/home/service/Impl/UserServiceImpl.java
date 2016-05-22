package com.jeremie.spring.home.service.Impl;

import com.jeremie.spring.home.dao.UserRepository;
import com.jeremie.spring.home.entity.User;
import com.jeremie.spring.home.service.UserService;
import com.jeremie.spring.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guanhong 15/9/10 下午10:11.
 */
@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUserList(int page,int size) throws Exception {
        Pageable pageable = new PageRequest(page,size);
        return userRepository.findAll(pageable).getContent();
    }

    public User save(User user) throws Exception  {
        return userRepository.save(user);
    }

    public User getById(Long id) throws Exception  {
        return userRepository.getOne(id);
    }

    //@Transactional(readOnly = false)
    public void updateUserById(String username,Long id) throws Exception {
        userRepository.update(username, id);
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        userRepository.invalid(id);
    }
}

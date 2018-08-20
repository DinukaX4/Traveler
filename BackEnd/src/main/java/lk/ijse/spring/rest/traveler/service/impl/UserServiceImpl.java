package lk.ijse.spring.rest.traveler.service.impl;

import lk.ijse.spring.rest.traveler.dto.UserDTO;
import lk.ijse.spring.rest.traveler.dto.UserProfileDTO;
import lk.ijse.spring.rest.traveler.entity.User;
import lk.ijse.spring.rest.traveler.entity.UserProfile;
import lk.ijse.spring.rest.traveler.entity.UserProfile_PK;
import lk.ijse.spring.rest.traveler.repository.UserProfileRepository;
import lk.ijse.spring.rest.traveler.repository.UserRepository;
import lk.ijse.spring.rest.traveler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserProfileRepository profileRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean save(UserDTO userDTO) throws Exception {
        User user = new User(userDTO.getUserName(), userDTO.getPassword(), userDTO.getEmail());
        repository.save(user);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean canAuthenticate(String userName, String password) throws Exception {
        User user = repository.findById(userName).get();

        UserProfile profile = profileRepository.findById(new UserProfile_PK(userName)).get();
        if (profile != null) {
            profile.setOnline(true);
            profileRepository.save(profile);
        }
        return password.equals(user.getPassword());

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean logOut(String userName) throws Exception {
        UserProfile profile = profileRepository.findById(new UserProfile_PK(userName)).get();
        profile.setOnline(false);
        return true;
    }

}

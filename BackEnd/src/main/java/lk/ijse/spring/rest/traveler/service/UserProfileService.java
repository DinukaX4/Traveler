package lk.ijse.spring.rest.traveler.service;

import lk.ijse.spring.rest.traveler.dto.OnlineUsersDTO;
import lk.ijse.spring.rest.traveler.dto.UserProfileDTO;

import java.util.ArrayList;

public interface UserProfileService {

    public boolean createProfileForUser(UserProfileDTO dto) throws Exception;

    public ArrayList<OnlineUsersDTO> onlineUsers() throws Exception;
}

package lk.ijse.spring.rest.traveler.service;

import lk.ijse.spring.rest.traveler.dto.UserDTO;

public interface UserService {

    public boolean save(UserDTO userDTO) throws Exception;

    public boolean canAuthenticate(String userName, String password) throws Exception;

    public boolean logOut(String userName) throws Exception;
}

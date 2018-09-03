package com.imokhonko.DAO.interfaces;

import com.imokhonko.User;
import java.util.List;

public interface IUserDAO {

    List<User> selectAll();
    User selectUserByAddress(String address);

}

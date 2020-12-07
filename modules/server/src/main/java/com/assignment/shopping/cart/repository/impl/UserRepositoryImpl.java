package com.assignment.shopping.cart.repository.impl;

import com.assignment.shopping.cart.entity.User;
import com.assignment.shopping.cart.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private Logger logger= LoggerFactory.getLogger(UserRepository.class);

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<User> getUserList() {
        User usr = new User();
        usr.setFirstName("FIrst");
        ArrayList<User> listUser = new ArrayList<>();
        listUser.add(usr);
        return listUser;
    }

    @Override
    public void createUser(User user) {
        try {

            logger.debug("Creating User");

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("user_id", user.getUserId());
            parameters.put("first_name", user.getFirstName());
            parameters.put("last_name", user.getLastName());
            parameters.put("nic", user.getNic());
            parameters.put("date_of_birth", user.getDateOfBirth());
            parameters.put("gender_id", user.getGenderId());
            parameters.put("msisdn", user.getMsisdn());
            parameters.put("email", user.getEmail());
            parameters.put("bank_id", user.getBankId());
            parameters.put("account_number", user.getAccountNumber());

            String[] columnsList = parameters.keySet().toArray(new String[]{});

            SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                    .withTableName("user")
                    .usingColumns(columnsList);

            insert.execute(parameters);
        } catch (Exception e){
            logger.error("An exception [{}] occurred while creating the user [{}]", e, user.getUserId());
        }
    }

}

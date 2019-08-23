package com.dfbz.day41;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    //创建模板对象
    private JdbcTemplate template = new JdbcTemplate(DataSourceUtil.getDataSource());

    public User findUser(String username, String password) {
        /*
        这里不捕捉DataAccessException的话，当results（数据库中没有该数据时）为空时，就会抛出EmptyResultDataAccessException异常，
        Spring这样做的目的是为了防止程序员不对空值进行判断，保证了程序的健壮性
        * */
        try {
            return template.queryForObject("select * from user where username=? and password=?",
                    new BeanPropertyRowMapper<>(User.class), username, password);
        } catch (DataAccessException e) {
            return null;
        }
    }
}

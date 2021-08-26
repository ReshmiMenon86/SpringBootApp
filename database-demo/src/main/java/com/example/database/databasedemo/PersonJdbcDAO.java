package com.example.database.databasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Person> findAll()
    {
        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<Person>(Person.class));
    }
    public Person findById(int id)
    {
        String sql = "select * from person where id=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<Person>(Person.class));

    }
    public int deleteById(int id)
    {
        String sql = "delete from person where id=?";
        return jdbcTemplate.update(sql,new Object[]{id});

    }
    public int insert(Person person)
    {
        String sql = "insert into person (id, name, location, birth_date)" +
        "values(?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBithDate().getTime())});

    }
    public int update(Person person)
    {
        String sql = "update person" +
                " set name =?, location=?, birth_date=? where id=?";
        return jdbcTemplate.update(sql,new Object[]{person.getName(),person.getLocation(),new Timestamp(person.getBithDate().getTime()),person.getId()});

    }

}

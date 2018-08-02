package com.example.mapper;

import com.example.entity.Person;
import com.example.vo.PersonVo;

import java.util.List;

/**
 * @author bestrow
 * @date 2018/8/1 21:44
 */
public interface PersonMapper {
    public Person querypersonbyid(int id);

    public List<Person> querypersonbyname(String name);

    public void insertperson(Person person);

    public void deletepersonbyid(int id);

    public void updatepersonbyid(Person person);

    public List<Person> querypersonbyvo(PersonVo personVo);
}

package cn.libo.msproject.dao;

import cn.libo.msproject.entity.Person;

public interface PersonDao {

    public Person querypersonbyid(int id);

    public void insertperson(Person person);
}

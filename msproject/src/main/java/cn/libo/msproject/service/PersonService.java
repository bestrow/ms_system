package cn.libo.msproject.service;

import cn.libo.msproject.dao.PersonDao;
import cn.libo.msproject.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public Person querypersonbyid(int id){
        return  personDao.querypersonbyid(id);
    }

    public void insertperson(Person person){
        personDao.insertperson(person);
    }

}

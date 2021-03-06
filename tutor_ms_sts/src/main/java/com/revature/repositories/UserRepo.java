package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.AccountType;
import com.revature.beans.Course;
import com.revature.beans.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	List<User> findByCoursesToTutor(Course course);

	User findBySchoolEmailAndPassword(String schoolEmail, String password);

	List<User> findByAccountType(AccountType at);
	
}

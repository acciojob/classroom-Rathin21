package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    public void addStudenttoDb(Student s){

        studentRepository.addStudenttoMap(s);
    }

    public void addTeachertoDb(Teacher t){
        
        studentRepository.addTeachertoMap(t);
    }

    public void addStudentandTeacher(String s,String t){

        studentRepository.addPairs(s, t);
    }

    public Student getStudentfromDb(String sName){

        return studentRepository.getStudentfromMap(sName);
    }

    public Teacher getTeacherfromDb(String tName){

        return studentRepository.getTeacherfromMap(tName);
    }

    public List<String> getStudentListfromDb(){

        return studentRepository.getStudentListfromMap();
    }

    public List<String> getStudentsFromTeacher(String tName){

        return studentRepository.getStudentsOfTeacher(tName);
    }

    public void deleteTeacherFromDb(String tName){

        studentRepository.deleteTeacherfromMap(tName);
    }

    public void deleteAllTeacherFromDb(){

        studentRepository.deleteAllTeachersfromMap();
    }
}

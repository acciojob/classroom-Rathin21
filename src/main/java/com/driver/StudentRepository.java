package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    
    HashMap<String,Student> studentMap = new HashMap<>();
    HashMap<String,Teacher> teacherMap = new HashMap<>();
    ArrayList<Pair> pairs = new ArrayList<>();

    public void addStudenttoMap(Student s){
        studentMap.put(s.getName(),s);
    }

    public Student getStudentfromMap(String name){
        return studentMap.get(name);
    }

    public void addTeachertoMap(Teacher t){
        teacherMap.put(t.getName(),t);
    }

    public Teacher getTeacherfromMap(String name){

        return teacherMap.get(name);
    }

    public void addPairs(String s,String t){
        
        if(studentMap.containsKey(s) && teacherMap.containsKey(t))
            pairs.add(new Pair(s,t));
    }

    public List<String> getStudentListfromMap(){

        List<String> StudentList = new ArrayList<>();
        for(String name:studentMap.keySet())
            StudentList.add(name);

        return StudentList;
    }

    public List<String> getStudentsOfTeacher(String tname){

        List<String> TeachersStudent= new ArrayList<>();

        for(int i=0;i<pairs.size();i++){
            if(pairs.get(i).T.equals(tname))
            TeachersStudent.add(pairs.get(i).S);
        }

        return TeachersStudent;
    }

    public void deleteTeacherfromMap(String dname){

        for(int i=0;i<pairs.size();i++){
            if(pairs.get(i).T.equals(dname)){
                if(studentMap.containsKey(pairs.get(i).S))
                    studentMap.remove(pairs.get(i).S);
                if(teacherMap.containsKey(dname))
                    teacherMap.remove(pairs.get(i).T);
            }
        }
        
    }

    public void deleteAllTeachersfromMap(){

        for(int i=0;i<pairs.size();i++){
            if(studentMap.containsKey(pairs.get(i).S))
                    studentMap.remove(pairs.get(i).S);
            
            if(teacherMap.containsKey(pairs.get(i).T))
                    teacherMap.remove(pairs.get(i).T);
            
                
        }
        pairs.clear();
    }
}
class Pair{
    String S;
    String T;
    Pair(String S,String T){
        this.S=S;
        this.T=T;
    }
}

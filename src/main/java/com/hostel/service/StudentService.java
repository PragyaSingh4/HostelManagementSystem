package com.hostel.service;

import com.hostel.entity.Student;
import java.util.List;
import java.util.Optional;
import com.hostel.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Integer id, Student updatedStudent) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setPhone(updatedStudent.getPhone());
        existingStudent.setGender(updatedStudent.getGender());
        existingStudent.setCourse(updatedStudent.getCourse());
        existingStudent.setYear(updatedStudent.getYear());
        existingStudent.setAddress(updatedStudent.getAddress());
        existingStudent.setRoom(updatedStudent.getRoom());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Integer id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        studentRepository.delete(student);
    }

}

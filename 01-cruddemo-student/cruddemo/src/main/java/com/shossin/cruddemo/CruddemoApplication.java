package com.shossin.cruddemo;

import com.shossin.cruddemo.dao.StudentDAO;
import com.shossin.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
			
//			readStudent(studentDAO);
			
//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

			deleteAllStudent(studentDAO);
		};

		
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleting All the students");
		int numRowsDeleted = studentDAO.deletedAll();
		System.out.println(" Deleting row count: " + numRowsDeleted );
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId = 1;
		// retrieve student based on the id: primary kry
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Scooby"
		System.out.println("Update the student....");
		myStudent.setLastName("Hossin");

		//update the student
		studentDAO.update(myStudent);

		//display the update student
		System.out.println("Update student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Hossin ");

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Md Sajjad", "Hossin", "sajjadcse207@gmail.com");
		// save the student
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple student here
		System.out.println("Creating the student object....");
		Student tempStudent1 = new Student("MD Sajid", "Hossin", "sajid@gmail.com");
		Student tempStudent2 = new Student("MD Asif", "Iquball", "asif@gmail.com");
		Student tempStudent3 = new Student("MD Fahim", "Ahmed", "fahim@gmail.com");
		Student tempStudent4 = new Student("MD Shakil", "Ahmed", "shakil@gmail.com");
		Student tempStudent5 = new Student("MD Tanvir", "Ahmed", "tanvir@gmail.com");
		Student tempStudent6 = new Student("MD Sani", "Mollah", "sani@gmail.com");
		Student tempStudent7 = new Student("MD Sujon", "Shorder", "sujon@gmail.com");
		//save the student objects
		System.out.println("Saving the students objets");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
		studentDAO.save(tempStudent5);
		studentDAO.save(tempStudent6);
		studentDAO.save(tempStudent7);
		//display id of the saved student

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating the student object....");
		Student tempStudent = new Student("MD Sajjad", "Hossin", "sajjadcse207@gmail.com");

		//save the student object
		System.out.println("Saving the student object");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId()   );

	}
}

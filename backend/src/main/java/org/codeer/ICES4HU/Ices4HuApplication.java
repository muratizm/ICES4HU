package org.codeer.ICES4HU;

import java.sql.Date;

import org.codeer.ICES4HU.Authentication.AuthenticationService;
import org.codeer.ICES4HU.Entity.AcademicPersonnel;
import org.codeer.ICES4HU.Entity.Department;
import org.codeer.ICES4HU.Entity.Semester;
import org.codeer.ICES4HU.Entity.Student;
import org.codeer.ICES4HU.Service.AcademicPersonnelService;
import org.codeer.ICES4HU.Service.DepartmentService;
import org.codeer.ICES4HU.Service.MailService;
import org.codeer.ICES4HU.Service.SemesterService;
import org.codeer.ICES4HU.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ices4HuApplication implements CommandLineRunner {

	@Autowired
	private AuthenticationService authenticationService;
	@Autowired
	private SemesterService semesterService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private AcademicPersonnelService academicPersonnelService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private MailService mailService;

	public static void main(String[] args) {
		SpringApplication.run(Ices4HuApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		mailService.sendMail("from@example.com", "to@example.com", "mail subject", "mail body");

		// Admin is inserted on auth_user and auth_token tables with same tokens
		// Admin tokens do not change
		// Admin token:
		// eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4NDc5NjQ2NywiZXhwIjoxNjkzNDM2NDY3fQ.EsMsz5VOrmhNaDRydw-XiFoyUtg8zO4fpjWMPSFzxB8
		var authResponse = authenticationService.registerAdmin();
		System.out.println("Admin tokens: \n" + authResponse.getAccessToken() + "\n" + authResponse.getRefreshToken());

		// Add semesters
		Semester fall2022 = new Semester();
		fall2022.setName("2022 Fall");
		fall2022.setStart_date(Date.valueOf("2022-09-12"));
		fall2022.setEnd_date(Date.valueOf("2022-12-20"));
		semesterService.addSemester(fall2022);

		Semester spring2022 = new Semester();
		spring2022.setName("2022 Spring");
		spring2022.setStart_date(Date.valueOf("2023-01-05"));
		spring2022.setEnd_date(Date.valueOf("2023-06-20"));
		semesterService.addSemester(spring2022);

		Semester summer2022 = new Semester();
		summer2022.setName("2022 Summer");
		summer2022.setStart_date(Date.valueOf("2023-06-23"));
		summer2022.setEnd_date(Date.valueOf("2023-08-28"));
		semesterService.addSemester(summer2022);

		// Add departments
		Department physics = new Department();
		physics.setName("Physics");
		departmentService.addDepartment(physics);

		Department mathematics = new Department();
		mathematics.setName("Mathematics");
		departmentService.addDepartment(mathematics);

		Department computerEngineering = new Department();
		computerEngineering.setName("Computer Engineering");
		departmentService.addDepartment(computerEngineering);

		// Add academic personnel
		AcademicPersonnel ap1 = new AcademicPersonnel();
		ap1.setName("Ali");
		ap1.setSurname("Taner");
		ap1.setUsername("ali.taner");
		ap1.setEmail("ali.taner@example.com");
		ap1.setDepartment(mathematics);
		academicPersonnelService.addAcademicPersonnel(ap1, "123456");

		AcademicPersonnel ap2 = new AcademicPersonnel();
		ap2.setName("Ayşe");
		ap2.setSurname("Can");
		ap2.setUsername("ayse.can");
		ap2.setEmail("ayse.can@example.com");
		ap2.setDepartment(physics);
		academicPersonnelService.addAcademicPersonnel(ap2, "123456");

		AcademicPersonnel ap3 = new AcademicPersonnel();
		ap3.setName("Ada");
		ap3.setSurname("Tanık");
		ap3.setUsername("ada.tanik");
		ap3.setEmail("ada.tanik@example.com");
		ap3.setDepartment(computerEngineering);
		ap3.setManagerOf(computerEngineering);
		academicPersonnelService.addAcademicPersonnel(ap3, "123456");

		// Add students
		Student s1 = new Student();
		s1.setName("Cemal");
		s1.setSurname("Demir");
		s1.setUsername("cemal.demir");
		s1.setEmail("cemal.demir@example.com");
		s1.setDepartment(computerEngineering);
		studentService.addStudent(s1, "123456");

		Student s2 = new Student();
		s2.setName("Neşe");
		s2.setSurname("Budak");
		s2.setUsername("nesebudak");
		s2.setEmail("nese.budak@example.com");
		s2.setDepartment(computerEngineering);
		studentService.addStudent(s2, "123456");

		Student s3 = new Student();
		s3.setName("Ahmet");
		s3.setSurname("Cem");
		s3.setUsername("ahmetcem");
		s3.setEmail("ahmet.cem@example.com");
		s3.setDepartment(mathematics);
		studentService.addStudent(s3, "123456");

		mailService.sendMail("from@example.com", "to@example.com", "mail subject", "mail body");
	}
}
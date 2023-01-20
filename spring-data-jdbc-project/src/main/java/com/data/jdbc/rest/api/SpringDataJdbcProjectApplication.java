package com.data.jdbc.rest.api;

import com.data.jdbc.rest.api.entity.*;
import com.data.jdbc.rest.api.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@SpringBootApplication
public class SpringDataJdbcProjectApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final BranchRepository branchRepository;
    private final SubjectRepository subjectRepository;

    private final BranchesRepository branchesRepository;

    private static Student getStudent1() {
        Student student = new Student();
        student.setFirstName("Rosy");
        student.setLastName("Larsen");
        student.setContactNo("+1-408-575-1317");
        return student;
    }
    private static Student getStudent2() {
        Student student = new Student();
        student.setFirstName("Rosy");
        student.setLastName("Larsen");
        student.setContactNo("+1-408-575-1219");
        return student;
    }

    private static Subject getSubject1() {
        Subject subject = new Subject();
        subject.setSubjectName("Software Engineering");
        subject.setSubjectDesc(
                "Apply key aspects of software engineering processes for the development of a complex software system");

        return subject;
    }

    private static Subject getSubject2() {
        Subject subject = new Subject();
        subject.setSubjectName("Distributed System");
        subject.setSubjectDesc("Explore recent advances in distributed computing systems");

        return subject;
    }

    private static Subject getSubject3() {
        Subject subject = new Subject();
        subject.setSubjectName("Business Analysis and Optimization");
        subject.setSubjectDesc("understand the Internal and external factors that impact the business strategy");

        return subject;
    }

    private static Branches getBranch1() {
        Branches branch = new Branches();
        branch.setBranchName("Computer Science and Engineering");
        branch.setBranchShortName("CSE");
        branch.setDescription(
                "CSE department offers courses under ambitious curricula in computer science and computer engineering..");

        return branch;
    }

    private static Branches getBranch2() {
        Branches branch = new Branches();
        branch.setBranchName("Information Technology");
        branch.setBranchShortName("IT");
        branch.setDescription(
                "IT is the business side of computers - usually dealing with databases, business, and accounting");

        return branch;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Address address = new Address();
        address.setBuilding("102, North Wing, Lotus Avenue");
        address.setStreet("Parklane, Los Angeles");
        address.setState("California");
        address.setCountry("United States");
        address.setZipcode("90011");

        Customer customer = new Customer();
        customer.setName("Peter");
        customer.setMembership("FREE");
        customer.setAddress(address);

        this.customerRepository.save(customer);

        Branch branch = new Branch();
        branch.setBranchShortName("CSE");
        branch.setBranchName("Computer Science and Engineering");
        branch.setDescription("CSE department offers courses under ambitious curriculam in computer science and computer engineering..");

        Set<Student> students = new HashSet<>();
        students.add(getStudent1());
        students.add(getStudent2());

        branch.setStudents(students);

        this.branchRepository.save(branch);


        Subject subj1 = subjectRepository.save(getSubject1());
        Subject subj2 = subjectRepository.save(getSubject2());
        Subject subj3 = subjectRepository.save(getSubject3());

        Branches branch1 = getBranch1();
        branch1.addSubject(subj1);
        branch1.addSubject(subj2);

        Branches createdBranch1 = branchesRepository.save(branch1);

        Branches branch2 = getBranch2();
        branch2.addSubject(subj1);
        branch2.addSubject(subj3);

        Branches createdBranch2 = branchesRepository.save(branch2);

        //branchesRepository.delete(branch1);

        branchesRepository.findAll().forEach(b -> System.err.println(b));

    }
}

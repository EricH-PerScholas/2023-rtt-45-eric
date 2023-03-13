package hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers") 
public class Customer {
	
	// Blockbuster Video Rental
	// Create 3 tables each with its own PK and appropriate FKs : User, Movie, and Movie Rental
	// create a schema and the tables and FKs using workbench and set hibernate to validate 
	// use business sense to figure out data types and which columns should be not null and default values
	// create a hibernate.cfg.xml
	// user table : first name, last name, email, password, create date (TIMESTAMP)  @Temporal
	// movie table : name, year released, rating, and rental price, late fee
	// movie rental table : movie id, user id, checkout date (TIMESTAMP), checkin date (TIMESTAMP)
	// add 2 movies and 2 users to the database with an SQL insert statement in workbench
	// can add another 1 or 2 user and move using hibernate
	// create a changePassword( UserId, Password ) function that updates the user ( not in the DAO )
	// create a checkOut( Movie, User ) and checkIn ( Movie, User )  ( not in the DAO )
	// create a function that will show the list movies that are checked out and the users that have them checked out ( not in the DAO )
	// BONUS .. add a due date to the movie rental table and a function double calculateLateFee(User, Movie, FutureDate)
	// DOUBLE SECRET BONUS - hook it up to a menu with the scanner
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "contact_lastname")
	private String contactLastname;

	@Column(name = "contact_firstname")
	private String contactFirstname;

	@Column(name = "phone")
	private String phone;

	@Column(name = "address_line1")
	private String addressLine1;

	@Column(name = "address_line2")
	private String addressLine2;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "country")
	private String country;

	// ****** ERROR MESSAGE : Repeated column in mapping for entity: hibernate.Customer column: salesRepEmployeeNumber (should be mapped with insert="false" update="false")
	// this essentially makes this a read only variable in this entity object
	// we add the insertable = false and updatable = false 
	// because we are using a @ManyToOne mapping that is on this same column
	// the other option is to simply delete these 2 lines.
	@Column(name = "salesRepEmployeeNumber", insertable=false, updatable=false)
	private Integer salesRepEmployeeNumber;

	// salesRepEmployeeNumber allows for null values and since this is a foreign key we need to set
	// optional = true and nullable = true to tell hibernate that null values are okay
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "salesRepEmployeeNumber", nullable = true)
    private Employee employee;
	

	@Column(name = "credit_limit", columnDefinition="decimal", precision=10, scale=2)
	private Double creditLimit;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Payment> payments = new ArrayList<Payment>();
	
}

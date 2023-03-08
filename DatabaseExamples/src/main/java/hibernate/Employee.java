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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "office_id")
	private Integer officeId;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "extension")
	private String extension;

	@Column(name = "email")
	private String email;

	@Column(name = "reports_to")
	private Integer reportsTo;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "vacation_hours")
	private Integer vacationHours;

	@ToString.Exclude
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Customer> customers = new ArrayList<Customer>();
		
}

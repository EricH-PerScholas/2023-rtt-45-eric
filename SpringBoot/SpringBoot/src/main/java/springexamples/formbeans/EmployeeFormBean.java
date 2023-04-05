package springexamples.formbeans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeFormBean {

    // we add this as a way to pass the id to and from the controller using a hidden form input field
    private Integer id;

    private String email;

    private String firstName;

    private String lastName;

    private String jobTitle;

    private String extension;

    private String profileImage;

    private Integer vacationHours;

    private Integer officeId;


}

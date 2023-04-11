package springexamples.formbeans;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import springexamples.validation.EmailUnique;

@Getter
@Setter
@ToString
public class EmployeeFormBean {

    // we add this as a way to pass the id to and from the controller using a hidden form input field
    private Integer id;

    // @NotNull is valid if the value is not null or if the value is ""
    // @NotEmpty is valid if the value is not null and if the value is not "" and if the value length > 0

    @NotEmpty(message = "Email address is required.")
    @Length(max = 20, message= "Email can not be longer than 20 characters")
    @Pattern(regexp=".+@.+\\.[a-z]+", message = "Invalid email format")
    @EmailUnique(message= "Email already exists in database")
    private String email;

    @NotEmpty(message = "First name is required.")
    @Length(max = 40, message= "First name can not be longer than 40 characters")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    private String lastName;

    private String jobTitle;

    private String extension;

    private String profileImage;

    @Max(value=100, message="You can not have more than 100 vacation hours")
    @Min(value=0, message="You can not have less than 0 vacation hours")
    private Integer vacationHours;

    private Integer officeId;


}

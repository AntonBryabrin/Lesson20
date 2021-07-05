
package dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonSerialize;


@Data
@AllArgsConstructor
@Builder
@JsonSerialize



public class UserOtus {

    private String Email;

    private String FirstName;

    private Long Id;

    private String LastName;

    private String Password;

    private String Phone;

    private Long UserStatus;

    private String Username;



}

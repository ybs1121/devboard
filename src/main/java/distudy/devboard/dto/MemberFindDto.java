package distudy.devboard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberFindDto {
    private String email;
    private String findPasswordAnswer;
}

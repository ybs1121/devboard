package distudy.devboard.Entity;

import distudy.devboard.dto.MemberDto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String findPasswordAnswer;



}

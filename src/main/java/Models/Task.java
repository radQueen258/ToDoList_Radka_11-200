package Models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Task {
    private long TaskId;
    private String TaskName;
    private String TaskDescription;
    private Date TaskDeadline;
}

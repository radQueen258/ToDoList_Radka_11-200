package Models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class File {
    private long FileId;
    private String FileName;
    private String FileType;
    private String FileContent;
    private Date FileUploadDate;
}

package modals;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Setter
@Getter
public class BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)

    private Date createdAt;

    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)

    private Date modifyAt;

}

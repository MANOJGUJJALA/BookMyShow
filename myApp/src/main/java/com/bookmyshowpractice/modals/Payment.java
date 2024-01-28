package modals;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseClass{


    private int amount;
    private long refno;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private PaymentType paymentType;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private PamentStatus pamentStatus;
}

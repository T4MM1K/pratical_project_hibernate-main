package model;

import javax.persistence.*;

@Entity
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    private String amount;
    private String invoice;

    @OneToOne(mappedBy = "payment")
    private Bookings booking;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "amount='" + amount + '\'' +
                ", invoice='" + invoice + '\'' +
                '}';
    }
}

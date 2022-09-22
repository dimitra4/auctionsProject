package pms.di.uoa.ecommerce.auctions.modeldb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Bids {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bid_id", nullable = false)
    private long bidId;
    @Basic
    @Column(name = "date_of_bid", nullable = false)
    private Date dateOfBid;
    @Basic
    @Column(name = "amount_of_bid", nullable = false, precision = 5)
    private BigDecimal amountOfBid;
    @JsonIgnoreProperties("Bids")
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "bidder_user_id", referencedColumnName = "user_id", nullable = false, insertable=false, updatable=false)
    private Users user;

    @JsonIgnoreProperties("Bids")
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "itm_id", nullable = false, insertable=false, updatable=false)
    private Items item;

    public long getBidId() {
        return bidId;
    }

    public void setBidId(long bidId) {
        this.bidId = bidId;
    }

    public Date getDateOfBid() {
        return dateOfBid;
    }

    public void setDateOfBid(Date dateOfBid) {
        this.dateOfBid = dateOfBid;
    }

    public BigDecimal getAmountOfBid() {
        return amountOfBid;
    }

    public void setAmountOfBid(BigDecimal amountOfBid) {
        this.amountOfBid = amountOfBid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bids bids = (Bids) o;
        return bidId == bids.bidId && Objects.equals(dateOfBid, bids.dateOfBid) && Objects.equals(amountOfBid, bids.amountOfBid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bidId, dateOfBid, amountOfBid);
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }
}

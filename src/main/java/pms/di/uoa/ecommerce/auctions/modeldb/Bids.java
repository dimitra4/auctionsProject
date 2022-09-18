package pms.di.uoa.ecommerce.auctions.modeldb;

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
    @Column(name = "item_id", nullable = false)
    private long itemId;
    @Basic
    @Column(name = "bidder_user_id", nullable = false)
    private long bidderUserId;
    @Basic
    @Column(name = "date_of_bid", nullable = false)
    private Date dateOfBid;
    @Basic
    @Column(name = "amount_of_bid", nullable = false, precision = 5)
    private BigDecimal amountOfBid;
    @ManyToOne
    @JoinColumn(name = "bidder_user_id", referencedColumnName = "user_id", nullable = false, insertable=false, updatable=false)
    private Users usersByBidderUserId;

    public long getBidId() {
        return bidId;
    }

    public void setBidId(long bidId) {
        this.bidId = bidId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getBidderUserId() {
        return bidderUserId;
    }

    public void setBidderUserId(long bidderUserId) {
        this.bidderUserId = bidderUserId;
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
        return bidId == bids.bidId && itemId == bids.itemId && bidderUserId == bids.bidderUserId && Objects.equals(dateOfBid, bids.dateOfBid) && Objects.equals(amountOfBid, bids.amountOfBid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bidId, itemId, bidderUserId, dateOfBid, amountOfBid);
    }

    public Users getUsersByBidderUserId() {
        return usersByBidderUserId;
    }

    public void setUsersByBidderUserId(Users usersByBidderUserId) {
        this.usersByBidderUserId = usersByBidderUserId;
    }
}

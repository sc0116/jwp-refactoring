package kitchenpos.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_group_id")
    private TableGroup tableGroup;

    @Column(nullable = false)
    private int numberOfGuests;

    @Column(nullable = false)
    private boolean empty;

    protected OrderTable() {
    }

    public OrderTable(final int numberOfGuests, final boolean empty) {
        this.numberOfGuests = numberOfGuests;
        this.empty = empty;
    }

    public OrderTable(final Long id, final int numberOfGuests, final boolean empty) {
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.empty = empty;
    }

    public void changeEmpty(final boolean empty) {
        verifyIsAlreadyGroupedTable("이미 단체로 지정된 테이블은 테이블 상태를 변경할 수 없습니다.");
        this.empty = empty;
    }

    public void changeNumberOfGuests(final int numberOfGuests) {
        verifyNumberOfGuestsToChangeIsLessThanZero(numberOfGuests);
        verifyIsEmptyTable();
        this.numberOfGuests = numberOfGuests;
    }

    public void groupTable(final TableGroup tableGroup) {
        verifyIsOrderTable();
        verifyIsAlreadyGroupedTable("이미 단체로 지정된 테이블은 새로 단체를 지정할 수 없습니다.");
        this.tableGroup = tableGroup;
        this.empty = false;
    }

    public void ungroupTable() {
        this.tableGroup = null;
        this.empty = false;
    }

    private void verifyIsAlreadyGroupedTable(final String message) {
        if (Objects.nonNull(this.tableGroup)) {
            throw new IllegalArgumentException(message);
        }
    }

    private void verifyNumberOfGuestsToChangeIsLessThanZero(final int numberOfGuests) {
        if (numberOfGuests < 0) {
            throw new IllegalArgumentException("손님 수는 0명 미만으로 변경할 수 없습니다.");
        }
    }

    private void verifyIsEmptyTable() {
        if (this.empty) {
            throw new IllegalArgumentException("빈 테이블은 손님 수를 변경할 수 없습니다.");
        }
    }

    private void verifyIsOrderTable() {
        if (!empty) {
            throw new IllegalArgumentException("주문 테이블은 단체로 지정할 수 없습니다.");
        }
    }

    public Long getId() {
        return id;
    }

    public Long getTableGroupId() {
        return tableGroup.getId();
    }

    public TableGroup getTableGroup() {
        return tableGroup;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public boolean isEmpty() {
        return empty;
    }
}

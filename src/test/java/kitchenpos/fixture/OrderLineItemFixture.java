package kitchenpos.fixture;

import kitchenpos.domain.OrderLineItem;

public class OrderLineItemFixture {

    public static OrderLineItem 주문_항목_생성(final Long menuId, final long quantity) {
        return new OrderLineItem(menuId, quantity);
    }
}

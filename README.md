# 키친포스

## 요구 사항

### 상품
- [x] 상품을 등록할 수 있다.
  - [x] 상품 가격이 올바르지 않으면 등록할 수 없다.
    - [x] 상품 가격은 반드시 있어야 한다.
    - [x] 상품 가격은 0원 이상이어야 한다.
- [x] 상품 목록을 조회할 수 있다.

### 메뉴 그룹
- [x] 메뉴 그룹을 등록할 수 있다.
- [x] 메뉴 그룹 목록을 조회할 수 있다.

### 메뉴
- [x] 메뉴를 등록할 수 있다.
  - [x] 메뉴 가격이 올바르지 않으면 등록할 수 없다.
    - [x] 메뉴 가격은 반드시 있어야 한다.
    - [x] 메뉴 가격은 0원 이상이어야 한다.
  - [x] 해당 메뉴가 속한 메뉴 그룹이 존재하지 않으면 등록할 수 없다.
  - [x] 해당 메뉴에 속한 메뉴 상품이 존재하지 않으면 등록할 수 없다.
  - [x] 메뉴의 가격이 해당 메뉴에 속한 메뉴 상품들의 가격의 총합과 다르면 등록할 수 없다.
- [x] 메뉴 목록을 조회할 수 있다.

### 주문
- [x] 주문을 등록할 수 있다.
  - [x] 주문 생성 시 주문 항목이 비어있으면 등록할 수 없다.
  - [x] 주문 항목에 쓰여진 메뉴가 존재하지 않으면 등록할 수 없다.
  - [x] 해당 주문이 속한 주문 테이블이 존재하지 않으면 등록할 수 없다.
  - [x] 해당 주문이 속한 주문 테이블이 빈 테이블이면 등록할 수 없다.
- [x] 주문 목록을 조회할 수 있다.
- [x] 주문 상태를 변경할 수 있다.
  - [x] 주문이 존재하지 않으면 변경할 수 없다.
  - [x] 주문이 계산 완료 상태면 변경할 수 없다.

### 단체 지정
- [x] 테이블을 단체로 지정할 수 있다.
  - [x] 단체로 지정할 테이블 목록이 비어있으면 단체로 지정할 수 없다.
  - [x] 두 개 미만의 테이블이면 단체로 지정할 수 없다.
  - [x] 존재하지 않는 주문 테이블이 있으면 단체로 지정할 수 없다.
  - [x] 빈 테이블이 아니거나 이미 단체로 지정되어 있으면 단체로 지정할 수 없다.
- [x] 단체 지정을 해제할 수 있다.
  - [x] 계산 완료되지 않은 주문 테이블이 존재하는 단체를 해제할 수 없다.

### 테이블
- [x] 테이블을 등록할 수 있다.
- [x] 테이블 목록을 조회할 수 있다.
- [ ] 빈 테이블로 변경할 수 있다.
  - [ ] 변경할 주문 테이블이 존재하지 않으면 변경할 수 없다.
  - [ ] 변경할 주문 테이블이 단체로 지정되어 있으면 변경할 수 없다.
  - [ ] 변경할 주문 테이블이 계산 완료 상태가 아니면 변경할 수 없다.
- [ ] 손님 수를 변경할 수 있다.
  - [ ] 손님 수를 0명 미만으로 변경할 수 없다.
  - [ ] 손님 수를 변경할 주문 테이블이 존재하지 않으면 변경할 수 없다.
  - [ ] 빈 테이블이면 변경할 수 없다.

## 용어 사전

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
| 상품 | product | 메뉴를 관리하는 기준이 되는 데이터 |
| 메뉴 그룹 | menu group | 메뉴 묶음, 분류 |
| 메뉴 | menu | 메뉴 그룹에 속하는 실제 주문 가능 단위 |
| 메뉴 상품 | menu product | 메뉴에 속하는 수량이 있는 상품 |
| 금액 | amount | 가격 * 수량 |
| 주문 테이블 | order table | 매장에서 주문이 발생하는 영역 |
| 빈 테이블 | empty table | 주문을 등록할 수 없는 주문 테이블 |
| 주문 | order | 매장에서 발생하는 주문 |
| 주문 상태 | order status | 주문은 조리 ➜ 식사 ➜ 계산 완료 순서로 진행된다. |
| 방문한 손님 수 | number of guests | 필수 사항은 아니며 주문은 0명으로 등록할 수 있다. |
| 단체 지정 | table group | 통합 계산을 위해 개별 주문 테이블을 그룹화하는 기능 |
| 주문 항목 | order line item | 주문에 속하는 수량이 있는 메뉴 |
| 매장 식사 | eat in | 포장하지 않고 매장에서 식사하는 것 |

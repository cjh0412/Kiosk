# 개요
키오스크 프로젝트

<b>목표</b> :  사용자가 선택한 메뉴를 장바구니에 추가/삭제/주문이 가능한 프로그램 

## 키오스크 LV1
- [x] 햄버거 메뉴 출력 및 선택
    - [x] 여러 햄버거 메뉴를 출력(`Scanner` 사용 )
    - [x] 제시된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행
    - [x] 특정 숫자 `0`이 입력되면 프로그램을 종료

## 키오스크 LV2
- [x] `MenuItem` 클래스 생성하기 : 햄버거 메뉴를 관리
    - [x] 클래스는 `이름`, `가격`, `설명` 필드 생성
    - [x] `main` 함수에서 `MenuItem` 클래스를 활용하여 햄버거 메뉴를 출력


- [x] `MenuItem` 객체 생성을 통해 `이름`, `가격`, `설명`을 세팅
    - [x] 키워드: `new`
    - [x] `List`를 선언하여 여러 `MenuItem`을 추가합니다.
    - [x] `List<MenuItem> menuItems = new ArrayList<>();`
    - [x] 반복문을 활용해 `menuItems`를 탐색하면서 하나씩 접근

## 키오스크 LV3
- [x] `Kiosk` 클래스 : 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리
    - [x]  `MenuItem`을 관리하는 리스트 생성
    - [x]  `start` 함수를 만들어 입력과 반복문 로직을 관리
    - [x]  `List<MenuItem> menuItems` 는 `Kiosk` 클래스 생성자를 통해 값을 할당

## 키오스크 LV4, 5
- [x] LV4
    - [x] `Menu` 클래스 : MenuItem 클래스를 관리
        - [x] `List<MenuItem>`는 Menu 클래스가 관리하도록 변경
        - [x] 상위 개념 ‘버거’ 같은 `카테고리 이름` 필드 생성
        - [x] 메뉴 카테고리 이름을 반환하는 메서드가 구현.

-[X] LV5
    - [x]  `MenuItem`, `Menu` 그리고 `Kiosk` 클래스의 필드에 직접 접근하지 못하도록 설정
    - [x]  Getter와 Setter 메서드를 사용해 데이터를 관리

- [x] 요구사항에 부합하는지 검토
  - [x]  콘솔에 햄버거 메뉴를 출력
  - [x]  사용자의 입력을 받아 메뉴를 선택하거나 프로그램을 종료
  - [x]  유효하지 않은 입력에 대해 오류 메시지를 출력
  - [x]  `0`을 입력하면 프로그램이 ‘뒤로가기’ 또는 ‘종료’

## 키오스크 LV6
- [x] 장바구니 생성 및 관리 기능
    - [x] 사용자가 선택한 메뉴를 장바구니에 추가할 수 있는 기능을 제공
    - [x] 장바구니는 메뉴명, 수량, 가격 정보를 저장, 항목을 동적으로 추가 및 조회 가능
    - [x] 사용자가 잘못된 선택을 했을 경우 예외를 처리합니다(예: 유효하지 않은 메뉴 번호 입력)


- [x] 장바구니 출력 및 금액 계산
    - [x] 사용자가 결제를 시도하기 전에, 장바구니에 담긴 모든 메뉴와 총 금액을 출력
    - [x] 출력 예시
        - [x] 각 메뉴의 이름, 수량, 가격, 설명
        - [x] 총 금액 합계


- [x] 장바구니 담기 기능
    - [x] 메뉴를 클릭하면 장바구니에 추가할 지 물어보고, 입력값에 따라 “추가”, “취소” 처리
        - [x] 메뉴는 한 번에 1개만 추가 가능
    - [x] 장바구니에 담은 목록을 출력


- [x] 주문 기능
    - [x] 장바구니에 담긴 모든 항목을 출력
    - [x] 합산하여 총 금액을 계산하고, “주문하기”를 누르면 장바구니를 초기화


- [x] Enum을 활용한 사용자 유형별 할인율 관리
    - [x]  사용자 유형의 Enum 정의 및 각 사용자 유형에 따른 할인율 적용 (예시 : 군인, 학생, 일반인)
    - [x]  주문 시, 사용자 유형에 맞는 할인율 적용해 총 금액 계산
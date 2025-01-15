package com.example.level6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    final Order order = new Order();
    final List<Menu> mainCategory  = new ArrayList<>() ;
    public void add(Menu menu){
        mainCategory.add(menu);
    }
    final Menu menu = new Menu(mainCategory);

    public void start() {
        // 스캐너 선언
        Scanner scanner = new Scanner(System.in);

        // 반복문 시작
        while (true){
            try {
                // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
                System.out.println("[MAIN MENU]");
                menu.printMainMenu();
                System.out.println("0. 종료   |종료");

                // 장바구니 값이 존재할 경우 : 확인, 취소까지 +2,  존재x : mainCategory의 크기값 체크
                int index = (order.getOrderList().isEmpty()) ? mainCategory.size()-1 :mainCategory.size()+2;

                if(!order.getOrderList().isEmpty()){
                    System.out.println("[ ORDER MENU ]");
                    System.out.println(index-1 +   ". Orders  | 장바구니를 확인 후 주문합니다.");
                    System.out.println(index + ". Cancel  | 장바구니 주문을 취소합니다.");
                }

                // 숫자 입력 받기
                int choiceCategory = Integer.parseInt(scanner.nextLine());

                // 장바구니 확인 하기
                if(index-1 == choiceCategory && !order.getOrderList().isEmpty()){
                    System.out.println("아래와 같이 주문하시겠습니까?");
                    order.printOrderList();

                    System.out.println("[ Total ]");
                    double sumPrice = order.totalOrderPrice();
                    System.out.println("W " + sumPrice);

                    System.out.println("1. 주문      2. 메뉴판");
                    int choiceOrder = Integer.parseInt(scanner.nextLine());
                    if(choiceOrder == 1){
                        System.out.println("주문이 완료되었습니다. 금액은 W " +sumPrice + " 입니다.");
                        break;
                    }
                    continue;
                }

                if(choiceCategory == 0){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                //리스트 index값보다 크거나 choiceMenu가 음수인 경우
                if (choiceCategory < 0 || choiceCategory > index) {
                    throw new RuntimeException("유효하지 않은 번호를 입력하셨습니다.");
                }

                // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                // List<Menu>에 인덱스로 접근하면 Menu만 추출할 수 있겠죠?
                // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
                List<MenuItem> subCategory = mainCategory.get(choiceCategory - 1).getMenuItemList();
                menu.printSubMenu(choiceCategory);
                System.out.println("0. 뒤로가기");

                // 숫자 입력 받기
                int choiceMenu = Integer.parseInt(scanner.nextLine());
                if(choiceMenu == 0){
                    continue;
                }

                //리스트 index값보다 크거나 choiceItem이 음수인 경우
                // 상위 카테고리로 돌려보내기
                if (choiceMenu < 0 || choiceMenu > subCategory.size() - 1) {
                    System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요..");
                    continue;
                }

                // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                // menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다.
                // 선택한 메뉴 : 이름, 가격, 설명
                System.out.println("선택한 메뉴 : " + subCategory.get(choiceMenu - 1).toString());
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인      2. 취소");
                int orderYn = Integer.parseInt(scanner.nextLine());
                if(orderYn == 1) {
                    order.addOrderList(subCategory.get(choiceMenu - 1));
                }
            }
            catch (NumberFormatException e) {
                System.out.println("입력된 값이 숫자가 아닙니다.");
                break;
            }
        }
    }
}
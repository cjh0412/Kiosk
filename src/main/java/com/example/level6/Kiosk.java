package com.example.level6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    final List<Menu> mainCategory  = new ArrayList<>() ;
    final Menu menu = new Menu(mainCategory);
    final Order order = new Order();

    Scanner scanner = new Scanner(System.in);

    public void add(Menu menu){
        mainCategory.add(menu);
    }

    public void start() {
        // 반복문 시작
        while (true){
            try {
                // 상위메뉴 출력
                printMainCategory();
                // 숫자 입력 받기
                int choiceUser = choiceUser();
                System.out.println();
                // 주문
                if((mainCategory.size()+1 == choiceUser) && !order.getMenuItemMap().isEmpty()) {
                    orderProcess();
                    continue;
                }
                
                // 주문취소
                if((mainCategory.size()+2 == choiceUser) && !order.getMenuItemMap().isEmpty()) {
                    order.cancelOrder();
                    continue;
                }

                if(choiceUser == 0){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                //리스트 index값보다 크거나 choiceMenu가 음수인 경우
                if (choiceUser < 0 || choiceUser > mainCategory.size()) {
                    throw new RuntimeException("유효하지 않은 번호를 입력하셨습니다.");
                }
                // 선택한 상위메뉴의 하위메뉴
                choiceSubCategory(choiceUser);
            }
            catch (NumberFormatException e) {
                System.out.println("입력된 값이 숫자가 아닙니다.");
                break;
            }
        }
    }

    // 메인 메뉴 출력
    private void printMainCategory(){
        System.out.println("[MAIN MENU]");
        menu.printMainMenu();
        System.out.println("0. 종료   |종료");
        // 장바구니 값이 있을 경우
        order.isEmptyOrderMap(mainCategory.size());
    }

    // 번호 선택
    private int choiceUser(){
        return Integer.parseInt(scanner.nextLine());
    }

    // 장바구니
    private void orderProcess(){
            System.out.println("아래와 같이 주문하시겠습니까?");
            order.printTotalOrder();

            System.out.println("[ Total ]");
            double sumPrice = order.totalOrderPrice();
            System.out.println("W " + sumPrice);

            System.out.println("1. 주문      2. 메뉴판");
            int choiceOrder = choiceUser();
            if(choiceOrder == 1){
                order.printDiscountInfo();

                int discount = choiceUser();
                System.out.println("주문이 완료되었습니다. 금액은 W "
                        +sumPrice * (1-(DiscountType.chkDiscount(discount))) + " 입니다." + "\n");
                // 주문완료시 장바구니 비우기
                order.completeOrder();
            }
    }


    // 하위 메뉴 선택
    private void choiceSubCategory(int choiceUser){
        List<MenuItem> subCategory = mainCategory.get(choiceUser - 1).getMenuItemList();

        // 서브메뉴 출력
        menu.printSubMenu(choiceUser);

        // 숫자 입력 받기
        int choiceMenu = choiceUser();
        
        // 0. 뒤로가기 : 상위메뉴로 돌려보내기
        if(choiceMenu == 0){
            return;
        }

        //리스트 index값보다 크거나 choiceItem이 음수인 경우
        // 상위 카테고리로 돌려보내기
        if (choiceMenu < 0 || choiceMenu > subCategory.size()) {
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요..");
            return;
        }
        
        // 선택한 메뉴 : 이름, 가격, 설명
        System.out.println("선택한 메뉴 : " + subCategory.get(choiceMenu - 1).toString());
        // 주문 추가 여부
        addOrderYn(subCategory, choiceMenu);
    }

    // 주문추가여부
    public void addOrderYn(List<MenuItem> subCategory, int choiceMenu){
        System.out.println("\n" + subCategory.get(choiceMenu - 1).toString());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인      2. 취소");
        int orderYn = choiceUser();
        if(orderYn == 1) {
            order.addOrderList(subCategory.get(choiceMenu - 1), 1);
        }
    }
}
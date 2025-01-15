package com.example.level6;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> menuItemList = new ArrayList<>();

    public List<MenuItem> getOrderList(){
        return menuItemList;
    }

    // 서브 메뉴 정보 리스트 저장
    public void addOrderList(MenuItem subMenu){
        menuItemList.add(subMenu);
        printMenuName();
    }

    // 가장 최근 장바구니에 저장된 메뉴 명 출력
    public void printMenuName(){
        System.out.println(menuItemList.get(menuItemList.size()-1).getName() + "이 장바구니에 추가되었습니다.");
    }
    
    // 장바구니 확인하기
    public void printOrderList(){
        getOrderList().stream()
                .forEach(order -> System.out.println(order.toString()));
    }

    // 주문 총액 체크
    public Double totalOrderPrice(){
        return getOrderList().stream()
                .mapToDouble(order-> Double.parseDouble(order.getPrice().replaceAll("[^\\d.]", "")))
                .sum();

    }

}

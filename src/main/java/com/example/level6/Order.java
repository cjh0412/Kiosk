package com.example.level6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    // 수량 추가를 위해 Map 추가
    // key : MenuItem, value = 수량
    Map<MenuItem, Integer> menuItemMap = new HashMap<>();

    public Map<MenuItem, Integer> getMenuItemMap() {
        return menuItemMap;
    }

    // 서브 메뉴 정보 저장
    public void addOrderList(MenuItem menuItem, int quantity) {
        // 저장된 menuItem이 없다면 새로 추가, 존재할 경우 +1
        menuItemMap.put(menuItem, menuItemMap.getOrDefault(menuItem, 0) + quantity);
        printMenuName(menuItem);
    }

    // 가장 최근 장바구니에 저장된 메뉴 명 출력
    public void printMenuName(MenuItem menuItem) {
        System.out.println(menuItem.getName() + " 장바구니에 추가되었습니다.");
    }

    // 전체 장바구니 목록 출력
    public void printTotalOrder() {
        getMenuItemMap().forEach((menuItem, quantity)
                -> System.out.println(menuItem.toString() + " 수량 : " + quantity));
    }

    // 주문 총액 체크
    public Double totalOrderPrice() {
        return getMenuItemMap().entrySet()
                .stream()
                .mapToDouble(menuMap -> {
                    double price = Double.parseDouble(menuMap.getKey().getPrice().replaceAll("[^\\d.]", "")); // 
                    return price * menuMap.getValue();  // 금액 * 수량
                })
                .sum();
    }

    // 할인율 추가
    public void printDiscountInfo() {
        System.out.println("할인 정보를 입력해주세요");
        for (DiscountType value : DiscountType.values()) {
            System.out.println(value.ordinal() + 1 + ". " + value.toString());
        }
    }

    // orderMap
    public void isEmptyOrderMap(List<Menu> mainCategory) {
        if (!getMenuItemMap().isEmpty()) {
            int index = mainCategory.size() + 2;

            System.out.println("[ ORDER MENU ]");
            System.out.println(index - 1 + ". Orders  | 장바구니를 확인 후 주문합니다.");
            System.out.println(index + ". Cancel  | 장바구니 주문을 취소합니다.");
        }
    }

}

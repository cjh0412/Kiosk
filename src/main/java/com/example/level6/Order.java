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
        System.out.println(menuItem.getName() + " 장바구니에 추가되었습니다." + "\n");
    }

    // 전체 장바구니 목록 출력
    public void printTotalOrder() {
        // 고정 폭 설정
        int width = 15;
        System.out.println("\n" + "[ Orders ]");
        getMenuItemMap().forEach((menuItem, quantity)
                -> System.out.println(
                        String.format("%-" + width + "s| 수량:  %-" + (width-5) + "s| %-" + width + "s| %-" + width + "s",
                                menuItem.getName(), quantity , menuItem.getPrice(), menuItem.getText())));
        System.out.println();
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

        System.out.println("\n" +"할인 정보를 입력해주세요");
        for (DiscountType value : DiscountType.values()) {
            System.out.println(value.ordinal() + 1 + ". " + value.toString());
        }
    }

    // 장바구니 값 존재시
    public void isEmptyOrderMap(int index) {
        if (!getMenuItemMap().isEmpty()) {
            System.out.println("\n" + "[ ORDER MENU ]");
            System.out.println(index + 1 + ". Orders  | 장바구니를 확인 후 주문합니다.");
            System.out.println(index + 2 + ". Cancel  | 장바구니 주문을 취소합니다.");
        }
    }

    // 주문완료
    public void completeOrder(){
        menuItemMap.clear();
    }

    // 주문취소
    public void cancelOrder(){
        // 키값 찾기
        MenuItem item = menuItemMap.keySet().stream().reduce((a, b) ->b ).orElse(null);
        System.out.println("가장 마지막에 추가하신 메뉴 " + item + "가 삭제되었습니다.");
        menuItemMap.remove(item);
    }

}

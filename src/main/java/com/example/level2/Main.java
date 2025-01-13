package com.example.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // List 선언 및 초기화
        List<MenuItem> menuList = new ArrayList();

        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        menuList.add(new MenuItem("ShackBurger", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("SmokeShack", "W 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Cheeseburger", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Hamburger", "W 5.9", "비프패티를 기반으로 야채가 들어간 기본버거"));
        menuList.add(new MenuItem("종료", "종료"));
        // Scanner 선언
        Scanner scanner = new Scanner(System.in);

        // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
        System.out.println("[ SHAKESHACK MENU ]");
        for (MenuItem menuItem : menuList) {
            if (!menuItem.getName().contains("종료")) {
                System.out.println(menuList.indexOf(menuItem) + 1 + ". " + menuItem.getName() + " |" + menuItem.getPrice() + " |" + menuItem.getText());
            }
        }
        System.out.println("0. " + menuList.get(menuList.size() - 1).getName() + " |" + menuList.get(menuList.size() - 1).getText());

        while (true) {
            // 숫자를 입력 받기
            int inputNum = scanner.nextInt();

            // 입력된 숫자에 따른 처리
            // 프로그램을 종료
            if (inputNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            // 선택한 메뉴 : 이름, 가격, 설명
            System.out.println(menuList.get(inputNum - 1).getName() + " |" + menuList.get(inputNum - 1).getPrice() + " |" + menuList.get(inputNum - 1).getText());
        }
    }
}
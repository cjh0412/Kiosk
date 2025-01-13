package com.example.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> menuList = new ArrayList<>();
        System.out.println("[ SHAKESHACK MENU ]");
        menuList.add("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menuList.add("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menuList.add("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menuList.add("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
        menuList.add("0. 종료      | 종료");

        for (String s : menuList) {
            System.out.println(s);
        }

        while(true){
            try {
                // 메뉴 번호 입력 , 잘못된 값(문자)등을 체크하기 위해 nextLine으로 입력받음
                int choiceMenu = Integer.parseInt(scanner.nextLine());

                // 0인 경우 종료
                if(choiceMenu == 0){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                // 0보다 작거나 번호보다 큰 경우
                if(choiceMenu < 0 || choiceMenu >= menuList.size()){
                    System.out.println("유효하지 않은 번호를 입력하셨습니다.");
                    break;
                }

                System.out.println(menuList.get(choiceMenu - 1));                 
            }catch (NumberFormatException e){
                //choiceMenu가 문자를 입력받는경우
                System.out.println("숫자가 아닙니다.");
            }

        }
    }
}
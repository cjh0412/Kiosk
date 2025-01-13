package com.example.level3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // List 선언 및 초기화
    private List<MenuItem> menuList;

    // 생성자
    public Kiosk(List<MenuItem> menuList) {
        this.menuList = menuList;
    }

    // start메서드
    public void start() {
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
            try {
                // 숫자를 입력 받기
                int choiceMenu = Integer.parseInt(scanner.nextLine());
                // 입력된 숫자에 따른 처리
                // 프로그램을 종료
                if (0 == choiceMenu) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
                //리스트 index값보다 크거나 choiceMenu가 음수인 경우
                if (choiceMenu < 0 || choiceMenu > menuList.size() - 1) {
                    throw new RuntimeException("유효하지 않은 번호를 입력하셨습니다.");
                }

                // 선택한 메뉴 : 이름, 가격, 설명
                System.out.println("선택한 메뉴 : " + menuList.get(choiceMenu - 1).getName() + " |" + menuList.get(choiceMenu - 1).getPrice() + " |" + menuList.get(choiceMenu - 1).getText());

            }
            catch (NumberFormatException e) {
                System.out.println("입력된 값이 숫자가 아닙니다.");
            }
        }
    }
}
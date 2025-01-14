package com.example.level5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    final List<Menu> mainCategory  = new ArrayList<>() ;

    public void add(Menu menu){
        mainCategory.add(menu);
    }

    public void start() {
        // 스캐너 선언
        Scanner scanner = new Scanner(System.in);

        // 반복문 시작
        while (true){
            try {
                // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
                System.out.println("[MAIN MENU]");
                for (Menu menu : mainCategory) {
                    System.out.println(mainCategory.indexOf(menu)+1+". "+ menu.getMainMenu());
                }
                System.out.println("0. 종료   |종료");

                // 숫자 입력 받기
                int choiceCategory = Integer.parseInt(scanner.nextLine());

                if(choiceCategory == 0){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                //리스트 index값보다 크거나 choiceMenu가 음수인 경우
                if (choiceCategory < 0 || choiceCategory > mainCategory.size() - 1) {
                    throw new RuntimeException("유효하지 않은 번호를 입력하셨습니다.");
                }

                // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                // List<Menu>에 인덱스로 접근하면 Menu만 추출할 수 있겠죠?
                // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
                List<MenuItem> subCategory = mainCategory.get(choiceCategory - 1).getMenuItemList();
                // [ main카데고리 + 메뉴 ] 출력
                System.out.println("[ "+mainCategory.get(choiceCategory-1).getMainMenu().toUpperCase()+" MENU ]");
                for (MenuItem menuItem : subCategory) {
                    System.out.println(subCategory.indexOf(menuItem) + 1 + ". "
                            + menuItem.getName() + " |"
                            + menuItem.getPrice() + " |"
                            + menuItem.getText());
                }
                System.out.println("0. 뒤로가기");

                // 숫자 입력 받기
                int choiceMenu = Integer.parseInt(scanner.nextLine());

                if(choiceMenu == 0){
                    continue;
                }

                //리스트 index값보다 크거나 choiceItem이 음수인 경우
                if (choiceMenu < 0 || choiceMenu > subCategory.size() - 1) {
                    throw new RuntimeException("유효하지 않은 번호를 입력하셨습니다.");
                }

                // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                // menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다.
                // 선택한 메뉴 : 이름, 가격, 설명
                System.out.println("선택한 메뉴 : "
                        + subCategory.get(choiceMenu - 1).getName()
                        + " |" + subCategory.get(choiceMenu - 1).getPrice()
                        + " |" + subCategory.get(choiceMenu - 1).getText()
                );
            }
            catch (NumberFormatException e) {
                System.out.println("입력된 값이 숫자가 아닙니다.");
                break;
            }
        }
    }
}
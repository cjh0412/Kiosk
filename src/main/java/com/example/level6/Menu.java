package com.example.level6;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // MenuItem 클래스를 List로 관리
    private List<MenuItem> menuItemList = new ArrayList<>();
    private List<Menu> mainList = new ArrayList<>();
    private String mainMenu;

    Menu(List<Menu> mainList) {
        this.mainList = mainList;
    }

    Menu(String mainMenu) {
        this.mainMenu = mainMenu;
    }

    public String getMainMenu() {
        return mainMenu;
    }

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    // List를 리턴하는 함수
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    // 서브 메뉴 정보 리스트 저장
    public void addMenuItemList(MenuItem subMenu) {
        menuItemList.add(subMenu);
    }

    // 메인메뉴 리스트 출력
    public void printMainMenu() {
        mainList.stream()
                .forEach(menu ->
                        System.out.println(mainList.indexOf(menu) + 1 + ". " + menu.mainMenu));
    }

    // 서브메뉴 리스트 출력
    public void printSubMenu(int choiceCategory) {
        // [ main카데고리 + 메뉴 ] 출력
        System.out.println("[ " + mainList.get(choiceCategory - 1).getMainMenu().toUpperCase() + " MENU ]");
        // 리스트 출력
        List<MenuItem> subCategory = mainList.get(choiceCategory - 1).getMenuItemList();
        subCategory.stream()
                .forEach(menuItem ->
                        System.out.println(subCategory.indexOf(menuItem) + 1 + ". " + menuItem.toString()));
        System.out.println("0. 뒤로가기");
    }
}

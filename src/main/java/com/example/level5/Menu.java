package com.example.level5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // MenuItem 클래스를 List로 관리
    private List<MenuItem> menuItemList = new ArrayList<>();
    private String mainMenu;

    Menu(String mainMenu){
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
    public void addMenuItemList(MenuItem subMenu){
        menuItemList.add(subMenu);
    }

    

}

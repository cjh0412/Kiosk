package com.example.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<MenuItem> menuList = new ArrayList<>();
        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        menuList.add(new MenuItem("ShackBurger", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("SmokeShack", "W 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Cheeseburger", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Hamburger", "W 5.9", "비프패티를 기반으로 야채가 들어간 기본버거"));
        menuList.add(new MenuItem("종료", "종료"));

        // kiosk 값을 넘김
        Kiosk kiosk  = new Kiosk(menuList);
        kiosk.start();
    }
}
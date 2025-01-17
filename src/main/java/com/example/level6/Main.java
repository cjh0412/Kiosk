package com.example.level6;

public class Main {

    public static void main(String[] args) {
        // Menu 객체 생성을 통해 이름 설정
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        Menu burgers = new Menu("Burgers");
        burgers.addMenuItemList(new MenuItem("ShackBurger", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItemList(new MenuItem("SmokeShack", "W 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItemList(new MenuItem("Cheeseburger", "W 6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addMenuItemList(new MenuItem("Hamburger", "W 5.9", "비프패티를 기반으로 야채가 들어간 기본버거"));

        //add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        Menu drinks = new Menu("Drink");
        drinks.addMenuItemList(new MenuItem("Lemonade", "W 3.9", "매장에서 직접 만드는 상큼한 레몬에이드"));
        drinks.addMenuItemList(new MenuItem("FreshBrewedIcedAde", "W 3.4", "직접 유기농 홍차를 우려낸 아이스티"));
        drinks.addMenuItemList(new MenuItem("BottleWater", "W 1.5", "지리산 암반내수층으로 만든 생수"));
        drinks.addMenuItemList(new MenuItem("Fifty", "W 3.5", "레몬에이드와 아이스티의 만남"));

        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        Menu deserts = new Menu("Desert");
        deserts.addMenuItemList(new MenuItem("HoneyButterCrunch", "W 5.9", "바닐라 커스터드에 허니 버터 소스와 슈가 콘이 달콤하게 블랜딩된 콘크리트"));
        deserts.addMenuItemList(new MenuItem("ShackAttack", "W 5.9", "진한 초콜릿 커스터드에 퍼지 소스와 세 가지 초콜렛 토핑이 블렌딩된 쉐이크쉑 대표 콘크리트"));
        deserts.addMenuItemList(new MenuItem("Fries", "W 3.9", "바삭한 크링클컷 감자튀김"));
        deserts.addMenuItemList(new MenuItem("CheeseFries", "W 3.9", "쉐이크쉑만의 특별한 체다치즈와 아메리칸 치즈가 올려진 감자 튀김"));

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk();
        kiosk.add(burgers);
        kiosk.add(drinks);
        kiosk.add(deserts);

        // Kiosk 내 시작하는 함수 호출
        kiosk.start();
    }
}
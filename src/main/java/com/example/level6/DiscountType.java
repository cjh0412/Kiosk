package com.example.level6;

public enum DiscountType {
    NATIONAL_MERIT( "국가유공자", 0.1),
    ARMY( "군인", 0.05),
    STUDENT("학생", 0.03),
    ORDINARY("일반", 0);

    private final String type;
    private final double discount;

    DiscountType(String type, double discount) {
        this.type = type;
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return type + ": " + (int)(discount*100) +"%";
    }

    // 할인율 체크
    public static double chkDiscount(int index) {
        return DiscountType.values()[index-1].getDiscount();
    }
}

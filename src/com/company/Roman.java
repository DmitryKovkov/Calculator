package com.company;

public enum Roman {
    I(1), II(2);
    private int translation;

    Roman (int translation) {
        this.translation = translation;
    }

    public int getTranslation() {
        return translation;
    }


}

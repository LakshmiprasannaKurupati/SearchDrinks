package com.example.apsdc.capstoneproject;

class CockTailModel {
    String drinkThumb;
    String ids;

    public CockTailModel(String drinkThumb, String ids) {
        this.drinkThumb = drinkThumb;
        this.ids = ids;
    }

    public String getDrinkThumb() {
        return drinkThumb;
    }

    public void setDrinkThumb(String drinkThumb) {
        this.drinkThumb = drinkThumb;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}

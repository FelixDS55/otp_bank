package helpers;

public enum MainMenu {
    CREDITS("Кредиты"), BANK_CARD("Банковские карты");

    private String translation;

    MainMenu(String translation) {
        this.translation = translation;
    }

    public String getTranslation(){
        return translation;
    }
}

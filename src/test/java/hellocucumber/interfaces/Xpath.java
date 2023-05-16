package hellocucumber.interfaces;

public interface Xpath {
    String search_text_box = "//textarea[@name='q']";
    String search_button = "(//input[@value='Tìm trên Google'])[2]";
    String equal = "//h3[contains(text(),'%s')]";
}

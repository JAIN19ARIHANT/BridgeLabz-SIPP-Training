import java.util.ArrayList;
import java.util.List;

public class City {
    List<Store> cityStoreList;

    public City() {
        cityStoreList = new ArrayList<>();
    }

    public List<Store> getCityStoreList() { return cityStoreList; }

    public void setCityStoreList(List<Store> cityStoreList) {
        this.cityStoreList = cityStoreList;
    }
}
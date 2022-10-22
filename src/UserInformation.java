import java.util.ArrayList;

public class UserInformation {
    int userType;
    String name;
    ArrayList<String> selectedItems = new ArrayList<>();

    public UserInformation(String name){
        this.name = name;
    }

}

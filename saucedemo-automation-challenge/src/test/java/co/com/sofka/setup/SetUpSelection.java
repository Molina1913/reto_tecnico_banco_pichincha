package co.com.sofka.setup;

import static co.com.sofka.Constants.VALID_OPTION;
import static co.com.sofka.setup.SetUpChrome.actorSetUpTheBrowserChrome;

public class SetUpSelection {
    public static void setUpSelection(int driverType) {
        switch (driverType) {
            case 1:
                actorSetUpTheBrowserChrome();
                break;
            case 2:
                //actorSetUpTheBrowserFirefox();
                break;
            default:
                System.out.println(VALID_OPTION);
                break;
        }
    }
}

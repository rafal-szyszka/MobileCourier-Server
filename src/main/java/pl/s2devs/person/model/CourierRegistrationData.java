package pl.s2devs.person.model;

/**
 * Created by rafal on 01.12.17.
 */
public class CourierRegistrationData {

    private String licence;
    private String carLicence;

    public CourierRegistrationData() {}

    public CourierRegistrationData(String licence, String carLicence) {
        this.licence = licence;
        this.carLicence = carLicence;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getCarLicence() {
        return carLicence;
    }

    public void setCarLicence(String carLicence) {
        this.carLicence = carLicence;
    }
}

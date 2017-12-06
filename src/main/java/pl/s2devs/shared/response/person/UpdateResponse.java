package pl.s2devs.shared.response.person;

/**
 * Created by rafal on 01.12.17.
 */
public class UpdateResponse<T> {

    public static final Boolean UPDATED = true;
    public static final Boolean FAILED_TO_UPDATE = false;

    private T updatedObject;
    private Boolean isUpdated;

    public UpdateResponse(T updatedObject, Boolean isUpdated) {
        this.updatedObject = updatedObject;
        this.isUpdated = isUpdated;
    }

    public T getUpdatedObject() {
        return updatedObject;
    }

    public void setUpdatedObject(T updatedObject) {
        this.updatedObject = updatedObject;
    }

    public Boolean getUpdated() {
        return isUpdated;
    }

    public void setUpdated(Boolean updated) {
        isUpdated = updated;
    }
}

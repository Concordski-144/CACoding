package interface_adapter.clear_users;

public class ClearState {
    private String clearError = null;
    private String deletedUsers = "";

    public ClearState(ClearState copy) {
        clearError = copy.clearError;
        deletedUsers = copy.deletedUsers;
    }

    public ClearState() {}

    public String getClearError() {
        return clearError;
    }

    public void setClearError(String clearError) {
        this.clearError = clearError;
    }

    public String getDeletedUsers() {
        return deletedUsers;
    }

    public void setDeletedUsers(String deletedUsers) {
        this.deletedUsers = deletedUsers;
    }
}

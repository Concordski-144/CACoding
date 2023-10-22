package use_case.clear_users;

public class ClearOutputData {

    private final String deletedUsers;
    private final boolean useCaseFailed;

    public ClearOutputData(String deletedUsers, boolean useCaseFailed) {
        this.deletedUsers = deletedUsers;
        this.useCaseFailed = useCaseFailed;
    }

    public String getDeletedUsers() {
        return deletedUsers;
    }
}

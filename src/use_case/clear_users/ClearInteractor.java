package use_case.clear_users;

public class ClearInteractor implements ClearInputBoundary {
    final ClearUserDataAccessInterface userDataAccessInterface;
    final ClearOutputBoundary clearPresenter;

    public ClearInteractor(ClearUserDataAccessInterface userDataAccessInterface,
                           ClearOutputBoundary clearOutputBoundary) {
        this.userDataAccessInterface = userDataAccessInterface;
        this.clearPresenter = clearOutputBoundary;
    }

    @Override
    public void execute(ClearInputData clearInputData) {
        if (userDataAccessInterface.isEmpty()) {
            clearPresenter.prepareFailView("Database already empty.");
        } else {
            String users = userDataAccessInterface.clear();
            ClearOutputData clearOutputData = new ClearOutputData(users, false);
            clearPresenter.prepareSuccessView(clearOutputData);
        }
    }
}

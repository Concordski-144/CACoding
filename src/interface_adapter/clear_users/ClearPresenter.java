package interface_adapter.clear_users;

import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;

public class ClearPresenter implements ClearOutputBoundary {

    private final ClearViewModel clearViewModel;
    private final SignupViewModel signupViewModel;
    private final ViewManagerModel viewManagerModel;

    public ClearPresenter(ClearViewModel clearViewModel,
                          SignupViewModel signupViewModel,
                          ViewManagerModel viewManagerModel) {
        this.clearViewModel = clearViewModel;
        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ClearOutputData response) {
        ClearState clearState = clearViewModel.getState();
        clearState.setDeletedUsers(response.getDeletedUsers());
        clearViewModel.firePropertyChanged();
        // On success switch to signup view
        viewManagerModel.setActiveView(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ClearState clearState = clearViewModel.getState();
        clearState.setClearError(error);
        clearViewModel.firePropertyChanged();
    }
}
